package com.aqitrade.arcus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.core.context.UserContext;
import com.aqitrade.arcus.data.dto.PortfolioApplicationDto;
import com.aqitrade.arcus.data.dto.PortfolioDto;
import com.aqitrade.arcus.data.dto.PortfolioSummaryDto;
import com.aqitrade.arcus.service.PortfolioService;
import com.aqitrade.arcus.web.model.ServiceResponse;

@RestController
public class UserPortfolioController {

  @Autowired
  private PortfolioService portfolioService;

  @RequestMapping(value = "portfolios/{portfolioId}/summary", method = RequestMethod.GET)
  public ServiceResponse<PortfolioSummaryDto> getPortfolioSummary(
      @PathVariable Integer portfolioId) {
    return new ServiceResponse<PortfolioSummaryDto>(
        portfolioService.getPortfolioSummary(portfolioId));
  }

  @RequestMapping(value = "portfolios", method = RequestMethod.POST)
  public ServiceResponse<Void> createPortfolio(@RequestBody PortfolioDto portfolioDto) {
    portfolioDto.setUserId(UserContext.get().getUserId());
    portfolioService.createPortfolio(portfolioDto);
    return ServiceResponse.SUCCESS;
  }

  @RequestMapping(value = "portfolios", method = RequestMethod.GET)
  public ServiceResponse<List<PortfolioDto>> getUserPortfolio() {
    Long userId = UserContext.get().getUserId();
    return new ServiceResponse<List<PortfolioDto>>(portfolioService.getPortfoliosByUser(userId));
  }

  @RequestMapping(value = "portfolios/{portfolioId}", method = RequestMethod.GET)
  public ServiceResponse<PortfolioDto> getPortfolio(@PathVariable int portfolioId) {
    return new ServiceResponse<PortfolioDto>(portfolioService.getPortfolio(portfolioId));
  }

  @RequestMapping(value = "portfolios/{portfolioId}/applications", method = RequestMethod.GET)
  public ServiceResponse<List<PortfolioApplicationDto>> getPortfolioApplication(
      @PathVariable int portfolioId) {
    return new ServiceResponse<List<PortfolioApplicationDto>>(
        portfolioService.getPortfolioApplications(portfolioId));
  }

}
