package com.aqitrade.arcus.data.dto;

public class PortfolioDto {

  private Integer portfolioId;

  private String name;

  private Double stopLoss;

  private Double stopWin;

  private Double gain;

  private Boolean active;

  private Long userId;

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
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the stopLoss
   */
  public Double getStopLoss() {
    return stopLoss;
  }

  /**
   * @param stopLoss the stopLoss to set
   */
  public void setStopLoss(Double stopLoss) {
    this.stopLoss = stopLoss;
  }

  /**
   * @return the stopWin
   */
  public Double getStopWin() {
    return stopWin;
  }

  /**
   * @param stopWin the stopWin to set
   */
  public void setStopWin(Double stopWin) {
    this.stopWin = stopWin;
  }

  /**
   * @return the gain
   */
  public Double getGain() {
    return gain;
  }

  /**
   * @param gain the gain to set
   */
  public void setGain(Double gain) {
    this.gain = gain;
  }

  /**
   * @return the active
   */
  public Boolean getActive() {
    return active;
  }

  /**
   * @param active the active to set
   */
  public void setActive(Boolean active) {
    this.active = active;
  }

  /**
   * @return the userId
   */
  public Long getUserId() {
    return userId;
  }

  /**
   * @param userId the userId to set
   */
  public void setUserId(Long userId) {
    this.userId = userId;
  }

}
