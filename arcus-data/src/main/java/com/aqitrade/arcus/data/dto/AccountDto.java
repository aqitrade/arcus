package com.aqitrade.arcus.data.dto;

public class AccountDto {
  private Integer accountId;
  private String name;
  private String authenticationId;
  private String password;
  private String status;
  private Integer portfolioId;
  private Integer brokerId;
  
  private BrokerDto broker;
  /**
   * @return the accountId
   */
  public Integer getAccountId() {
    return accountId;
  }
  /**
   * @param accountId the accountId to set
   */
  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
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
   * @return the authenticationId
   */
  public String getAuthenticationId() {
    return authenticationId;
  }
  /**
   * @param authenticationId the authenticationId to set
   */
  public void setAuthenticationId(String authenticationId) {
    this.authenticationId = authenticationId;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }
  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }
  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
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
   * @return the broker
   */
  public BrokerDto getBroker() {
    return broker;
  }
  /**
   * @param broker the broker to set
   */
  public void setBroker(BrokerDto broker) {
    this.broker = broker;
  }

}
