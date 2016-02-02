package com.aqitrade.arcus.data.dto;

import java.util.Date;

public class PortfolioSummaryDto {
  private Double value;
  private Double initialValue;
  private Double pnl;
  private Double gain;
  private Double change;
  private Double changePercentage;
  private Double sharpeRatio;
  private Double mDD;
  private Double iRR;
  private Double risk;
  private Double beta;
  private Date createDate;
  private Double stopLoss;
  private Double stopGain;
  private Double allocations;

  /**
   * @return the value
   */
  public Double getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(Double value) {
    this.value = value;
  }

  /**
   * @return the initialValue
   */
  public Double getInitialValue() {
    return initialValue;
  }

  /**
   * @param initialValue the initialValue to set
   */
  public void setInitialValue(Double initialValue) {
    this.initialValue = initialValue;
  }

  /**
   * @return the pnl
   */
  public Double getPnl() {
    return pnl;
  }

  /**
   * @param pnl the pnl to set
   */
  public void setPnl(Double pnl) {
    this.pnl = pnl;
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
   * @return the change
   */
  public Double getChange() {
    return change;
  }

  /**
   * @param change the change to set
   */
  public void setChange(Double change) {
    this.change = change;
  }

  /**
   * @return the changePercentage
   */
  public Double getChangePercentage() {
    return changePercentage;
  }

  /**
   * @param changePercentage the changePercentage to set
   */
  public void setChangePercentage(Double changePercentage) {
    this.changePercentage = changePercentage;
  }

  /**
   * @return the sharpeRatio
   */
  public Double getSharpeRatio() {
    return sharpeRatio;
  }

  /**
   * @param sharpeRatio the sharpeRatio to set
   */
  public void setSharpeRatio(Double sharpeRatio) {
    this.sharpeRatio = sharpeRatio;
  }

  /**
   * @return the mDD
   */
  public Double getmDD() {
    return mDD;
  }

  /**
   * @param mDD the mDD to set
   */
  public void setmDD(Double mDD) {
    this.mDD = mDD;
  }

  /**
   * @return the iRR
   */
  public Double getiRR() {
    return iRR;
  }

  /**
   * @param iRR the iRR to set
   */
  public void setiRR(Double iRR) {
    this.iRR = iRR;
  }

  /**
   * @return the risk
   */
  public Double getRisk() {
    return risk;
  }

  /**
   * @param risk the risk to set
   */
  public void setRisk(Double risk) {
    this.risk = risk;
  }

  /**
   * @return the beta
   */
  public Double getBeta() {
    return beta;
  }

  /**
   * @param beta the beta to set
   */
  public void setBeta(Double beta) {
    this.beta = beta;
  }

  /**
   * @return the createDate
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate the createDate to set
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
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
   * @return the stopGain
   */
  public Double getStopGain() {
    return stopGain;
  }

  /**
   * @param stopGain the stopGain to set
   */
  public void setStopGain(Double stopGain) {
    this.stopGain = stopGain;
  }

  /**
   * @return the allocations
   */
  public Double getAllocations() {
    return allocations;
  }

  /**
   * @param allocations the allocations to set
   */
  public void setAllocations(Double allocations) {
    this.allocations = allocations;
  }

}
