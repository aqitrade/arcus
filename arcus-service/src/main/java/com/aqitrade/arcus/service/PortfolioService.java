package com.aqitrade.arcus.service;

import java.util.List;

import com.aqitrade.arcus.data.dto.PortfolioApplicationDto;
import com.aqitrade.arcus.data.dto.PortfolioDto;
import com.aqitrade.arcus.data.dto.PortfolioSummaryDto;
import com.aqitrade.arcus.data.entity.PortfolioEntity;

public interface PortfolioService extends GenericService<PortfolioEntity, PortfolioDto, Integer> {

  List<PortfolioDto> getPortfoliosByUser(Long userId);

  PortfolioSummaryDto getPortfolioSummary(Integer portfolioId);

  void createPortfolio(PortfolioDto dto);

  PortfolioDto getPortfolio(Integer portfolioId);

  List<PortfolioApplicationDto> getPortfolioApplications(int portfolioId);
}
