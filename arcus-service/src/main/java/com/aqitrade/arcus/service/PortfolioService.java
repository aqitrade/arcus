package com.aqitrade.arcus.service;

import java.util.List;

import com.aqitrade.arcus.data.dto.AccountDto;
import com.aqitrade.arcus.data.dto.PortfolioApplicationDto;
import com.aqitrade.arcus.data.dto.PortfolioDto;
import com.aqitrade.arcus.data.dto.PortfolioInstrumentDto;
import com.aqitrade.arcus.data.dto.PortfolioSummaryDto;
import com.aqitrade.arcus.data.entity.PortfolioEntity;

public interface PortfolioService extends GenericService<PortfolioEntity, PortfolioDto, Integer> {

  List<PortfolioDto> getPortfoliosByUser(Long userId);

  PortfolioSummaryDto getPortfolioSummary(Integer portfolioId);

  void createPortfolio(PortfolioDto dto);

  PortfolioDto getPortfolio(Integer portfolioId);

  List<PortfolioApplicationDto> getPortfolioApplications(int portfolioId);

  void savePortfolioApplication(PortfolioApplicationDto portfolioApplicationDto);
  
  List<AccountDto> getPortfolioAccounts(Integer portfolioId);
  
  void savePortfolioAccount(AccountDto accountDto);
  
  List<PortfolioInstrumentDto> getPortfolioInstruments(Integer portfolioId);

  void savePortfolioInstrument(PortfolioInstrumentDto portfolioInstrumentDto);
}
