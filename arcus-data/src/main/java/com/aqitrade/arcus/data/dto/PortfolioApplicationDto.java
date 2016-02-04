package com.aqitrade.arcus.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PortfolioApplicationDto {
  private Integer portfolioApplicationId;
  private Integer applicationId;
  private Integer portfolioId;
  private ApplicationDto application;

  /**
   * @return the portfolioApplicationId
   */
  public Integer getPortfolioApplicationId() {
    return portfolioApplicationId;
  }

  /**
   * @param portfolioApplicationId the portfolioApplicationId to set
   */
  public void setPortfolioApplicationId(Integer portfolioApplicationId) {
    this.portfolioApplicationId = portfolioApplicationId;
  }

  /**
   * @return the applicationId
   */
  public Integer getApplicationId() {
    return applicationId;
  }

  /**
   * @param applicationId the applicationId to set
   */
  public void setApplicationId(Integer applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * @return the portfolioId
   */
  public Integer getPortfolioId() {
    return portfolioId;
  }

  /**
   * @param portfolioId the portfolioId to set
   */
  public void setPortfolioId(Integer portfolioId) {
    this.portfolioId = portfolioId;
  }

  /**
   * @return the applicationDto
   */
  public ApplicationDto getApplication() {
    return application;
  }

  /**
   * @param applicationDto the applicationDto to set
   */
  public void setApplication(ApplicationDto applicationDto) {
    this.application = applicationDto;
  }
}
