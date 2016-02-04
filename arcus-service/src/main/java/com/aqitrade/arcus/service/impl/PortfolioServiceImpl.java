package com.aqitrade.arcus.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.context.UserContext;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.data.dao.AccountDao;
import com.aqitrade.arcus.data.dao.InstrumentDao;
import com.aqitrade.arcus.data.dao.PortfolioApplicationDao;
import com.aqitrade.arcus.data.dao.PortfolioDao;
import com.aqitrade.arcus.data.dao.PortfolioInstrumentDao;
import com.aqitrade.arcus.data.dto.AccountDto;
import com.aqitrade.arcus.data.dto.BrokerDto;
import com.aqitrade.arcus.data.dto.InstrumentDto;
import com.aqitrade.arcus.data.dto.PortfolioApplicationDto;
import com.aqitrade.arcus.data.dto.PortfolioDto;
import com.aqitrade.arcus.data.dto.PortfolioInstrumentDto;
import com.aqitrade.arcus.data.dto.PortfolioSummaryDto;
import com.aqitrade.arcus.data.entity.AccountEntity;
import com.aqitrade.arcus.data.entity.PortfolioApplicationEntity;
import com.aqitrade.arcus.data.entity.PortfolioEntity;
import com.aqitrade.arcus.data.entity.PortfolioInstrumentEntity;
import com.aqitrade.arcus.service.ApplicationService;
import com.aqitrade.arcus.service.BrokerService;
import com.aqitrade.arcus.service.InstrumentService;
import com.aqitrade.arcus.service.PortfolioService;
import com.google.common.base.Preconditions;

@Service
public class PortfolioServiceImpl extends GenericServiceImpl<PortfolioEntity, PortfolioDto, Integer>
    implements PortfolioService {

  private final PortfolioDao portfolioDao;

  @Autowired
  private PortfolioApplicationDao portfolioApplicationDao;

  @Autowired
  private ApplicationService applicationService;

  @Autowired
  private AccountDao accountDao;

  @Autowired
  private DozerBeanMapper mapper;

  @Autowired
  private BrokerService brokerService;

  @Autowired
  private PortfolioInstrumentDao portfolioInstrumentDao;

  @Autowired
  private InstrumentService instrumentService;

  @Autowired
  public PortfolioServiceImpl(PortfolioDao portfolioDao) {
    super(portfolioDao);
    this.portfolioDao = portfolioDao;
  }

  public List<PortfolioDto> getPortfoliosByUser(Long userId) {
    return convert(portfolioDao.getPortfoliosByUser(userId));
  }

  public PortfolioSummaryDto getPortfolioSummary(Integer portfolioId) {
    return new PortfolioSummaryDto();
  }

  @Transactional
  public void createPortfolio(PortfolioDto dto) {
    try {
      final PortfolioEntity entity = mapper.map(dto, PortfolioEntity.class);
      entity.setCreateDate(new Date());
      dao.save(entity);
    } catch (final Exception e) {
      throw new ServiceException.DataAccessException(ErrorCodes.SAVE_FAILED, e);
    }
  }

  public PortfolioDto getPortfolio(Integer portfolioId) {
    final PortfolioDto portfolioDto = findOne(portfolioId);
    if (!UserContext.get().getUserId().equals(portfolioDto.getUserId())) {
      throw new ServiceException.Unauthorized(ErrorCodes.HTTP_UNAUTHORIZED,
          "User does not have permission to view this portfolio");
    }
    return portfolioDto;
  }

  public List<PortfolioApplicationDto> getPortfolioApplications(int portfolioId) {
    final List<PortfolioApplicationDto> dtoList = new ArrayList<PortfolioApplicationDto>();
    final List<PortfolioApplicationEntity> portfolioAppList =
        portfolioApplicationDao.getPortfolioApplications(portfolioId);
    if (portfolioAppList != null && portfolioAppList.size() > 0) {
      for (final PortfolioApplicationEntity portfolioApplicationEntity : portfolioAppList) {
        final PortfolioApplicationDto dto =
            mapper.map(portfolioApplicationEntity, PortfolioApplicationDto.class);
        dto.setApplicationId(null);
        dto.setApplication(
            applicationService.findOne(portfolioApplicationEntity.getApplicationId()));
        dtoList.add(dto);
      }
    }

    return dtoList;
  }

  @Transactional
  public void savePortfolioApplication(PortfolioApplicationDto portfolioApplicationDto) {
    Preconditions.checkNotNull(portfolioApplicationDto);
    Preconditions.checkNotNull(portfolioApplicationDto.getApplicationId());
    Preconditions.checkNotNull(portfolioApplicationDto.getPortfolioId());

    final PortfolioApplicationEntity entity = new PortfolioApplicationEntity();
    entity.setApplicationId(portfolioApplicationDto.getApplicationId());
    entity.setPortfolioId(portfolioApplicationDto.getPortfolioId());
    portfolioApplicationDao.save(entity);
  }

  public List<AccountDto> getPortfolioAccounts(Integer portfolioId) {
    List<AccountEntity> accountEntities = accountDao.getAccountsByPortfolioId(portfolioId);
    List<AccountDto> accountDtos = new ArrayList<AccountDto>();
    for (AccountEntity accountEntity : accountEntities) {
      AccountDto accountDto = mapper.map(accountEntity, AccountDto.class);
      BrokerDto brokerDto = brokerService.findOne(accountDto.getBrokerId());
      accountDto.setBroker(brokerDto);

      accountDtos.add(accountDto);
    }
    return accountDtos;
  }

  @Transactional
  public void savePortfolioAccount(AccountDto accountDto) {
    Preconditions.checkNotNull(accountDto);
    Preconditions.checkNotNull(accountDto.getAuthenticationId());
    Preconditions.checkNotNull(accountDto.getPassword());
    Preconditions.checkNotNull(accountDto.getPortfolioId());
    Preconditions.checkNotNull(accountDto.getBrokerId());
    Preconditions.checkNotNull(accountDto.getStatus());

    AccountEntity accountEntity = mapper.map(accountDto, AccountEntity.class);
    accountDao.save(accountEntity);
  }

  public List<PortfolioInstrumentDto> getPortfolioInstruments(Integer portfolioId) {
    List<PortfolioInstrumentEntity> entities =
        portfolioInstrumentDao.getPortfolioInstruments(portfolioId);

    List<PortfolioInstrumentDto> portfolioInstrumentDtos = new ArrayList<PortfolioInstrumentDto>();
    for (PortfolioInstrumentEntity portfolioInstrumentEntity : entities) {
      PortfolioInstrumentDto dto =
          mapper.map(portfolioInstrumentEntity, PortfolioInstrumentDto.class);
      dto.setInstrument(instrumentService.findOne(dto.getInstrumentId()));

      portfolioInstrumentDtos.add(dto);
    }
    return portfolioInstrumentDtos;
  }

  @Transactional
  public void savePortfolioInstrument(PortfolioInstrumentDto portfolioInstrumentDto) {
    Preconditions.checkNotNull(portfolioInstrumentDto);
    Preconditions.checkNotNull(portfolioInstrumentDto.getQty());
    Preconditions.checkNotNull(portfolioInstrumentDto.getInstrumentId());
    Preconditions.checkNotNull(portfolioInstrumentDto.getPortfolioId());

    // TODO find out how to calculate avg price
    PortfolioInstrumentEntity portfolioInstrumentEntity =
        mapper.map(portfolioInstrumentDto, PortfolioInstrumentEntity.class);
    portfolioInstrumentEntity.setCreateDate(new Date());
    portfolioInstrumentDao.save(portfolioInstrumentEntity);

  }

}
