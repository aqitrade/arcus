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
import com.aqitrade.arcus.data.dao.PortfolioApplicationDao;
import com.aqitrade.arcus.data.dao.PortfolioDao;
import com.aqitrade.arcus.data.dto.PortfolioApplicationDto;
import com.aqitrade.arcus.data.dto.PortfolioDto;
import com.aqitrade.arcus.data.dto.PortfolioSummaryDto;
import com.aqitrade.arcus.data.entity.PortfolioApplicationEntity;
import com.aqitrade.arcus.data.entity.PortfolioEntity;
import com.aqitrade.arcus.service.PortfolioService;

@Service
public class PortfolioServiceImpl extends GenericServiceImpl<PortfolioEntity, PortfolioDto, Integer>
    implements PortfolioService {

  private PortfolioDao portfolioDao;

  @Autowired
  private PortfolioApplicationDao portfolioApplicationDao;

  @Autowired
  private DozerBeanMapper mapper;

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
      PortfolioEntity entity = mapper.map(dto, PortfolioEntity.class);
      entity.setCreateDate(new Date());
      dao.save(entity);
    } catch (Exception e) {
      throw new ServiceException.DataAccessException(ErrorCodes.SAVE_FAILED, e);
    }
  }

  public PortfolioDto getPortfolio(Integer portfolioId) {
    PortfolioDto portfolioDto = findOne(portfolioId);
    if (!UserContext.get().getUserId().equals(portfolioDto.getUserId())) {
      throw new ServiceException.Unauthorized(ErrorCodes.HTTP_UNAUTHORIZED,
          "User does not have permission to view this portfolio");
    }
    return portfolioDto;
  }

  public List<PortfolioApplicationDto> getPortfolioApplications(int portfolioId) {
    List<PortfolioApplicationDto> dtoList = new ArrayList<PortfolioApplicationDto>();
    List<PortfolioApplicationEntity> portfolioAppList =
        portfolioApplicationDao.getPortfolioApplications(portfolioId);
    if (portfolioAppList != null && portfolioAppList.size() > 0) {
      for (PortfolioApplicationEntity portfolioApplicationEntity : portfolioAppList) {
        dtoList.add(mapper.map(portfolioApplicationEntity, PortfolioApplicationDto.class));
      }
    }

    return dtoList;
  }


}
