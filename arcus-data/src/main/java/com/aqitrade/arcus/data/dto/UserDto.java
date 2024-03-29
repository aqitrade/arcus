package com.aqitrade.arcus.data.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Client contract for User entity
 * 
 * @author pani
 *
 */
@JsonInclude(Include.NON_NULL)
public class UserDto implements Serializable {
  private static final long serialVersionUID = -6986662084151454606L;
  private Long userId;
  private String userName;
  private String firstName;
  private String lastName;
  private String countryName;
  private String password;
  private Long phoneNumber;
  private String emailId;
  private Long securityCode;

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

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
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
   * @return the phoneNumber
   */
  public Long getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * @return the emailId
   */
  public String getEmailId() {
    return emailId;
  }

  /**
   * @param emailId the emailId to set
   */
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  /**
   * @return the securityCode
   */
  public Long getSecurityCode() {
    return securityCode;
  }

  /**
   * @param securityCode the securityCode to set
   */
  public void setSecurityCode(Long securityCode) {
    this.securityCode = securityCode;
  }

  /**
   * @return the userName
   */
  public String getUserName() {
    return userName;
  }

  /**
   * @param userName the userName to set
   */
  public void setUserName(String userName) {
    this.userName = userName;
  }

  /**
   * @return the countryName
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * @param countryName the countryName to set
   */
  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UserDto [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName
        + ", lastName=" + lastName + ", countryName=" + countryName + ", password=" + password
        + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", securityCode=" + securityCode
        + "]";
  }
}
