package com.aqitrade.arcus.data.dto;

public class BrokerDto {
  private Integer brokerId;
  private String brokerName;

  /**
   * @return the brokerId
   */
  public Integer getBrokerId() {
    return brokerId;
  }

  /**
   * @param brokerId the brokerId to set
   */
  public void setBrokerId(Integer brokerId) {
    this.brokerId = brokerId;
  }

  /**
   * @return the brokerName
   */
  public String getBrokerName() {
    return brokerName;
  }

  /**
   * @param brokerName the brokerName to set
   */
  public void setBrokerName(String brokerName) {
    this.brokerName = brokerName;
  }

}
