package com.aqitrade.arcus.data.dto;

public class PortfolioApplicationDto {
  private Integer portfolioApplicationId;
  private Integer applicationId;
  private Integer portfolioId;

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
}
