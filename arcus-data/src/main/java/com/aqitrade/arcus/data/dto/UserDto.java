package com.aqitrade.arcus.data.dto;

import java.util.Date;

/**
 * Client contract for User entity
 * 
 * @author pani
 *
 */
public class UserDto {
  private Long userId;
  private String userName;
  private String firstName;
  private String lastName;
  private String countryName;
  private String password;
  private Long phoneNumber;
  private String emailId;
  private Long securityCode;
  private Date securityExpDate;

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
   * @return the securityExpDate
   */
  public Date getSecurityExpDate() {
    return securityExpDate;
  }

  /**
   * @param securityExpDate the securityExpDate to set
   */
  public void setSecurityExpDate(Date securityExpDate) {
    this.securityExpDate = securityExpDate;
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
        + ", securityExpDate=" + securityExpDate + "]";
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
    result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result + ((securityCode == null) ? 0 : securityCode.hashCode());
    result = prime * result + ((securityExpDate == null) ? 0 : securityExpDate.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserDto other = (UserDto) obj;
    if (countryName == null) {
      if (other.countryName != null)
        return false;
    } else if (!countryName.equals(other.countryName))
      return false;
    if (emailId == null) {
      if (other.emailId != null)
        return false;
    } else if (!emailId.equals(other.emailId))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    if (securityCode == null) {
      if (other.securityCode != null)
        return false;
    } else if (!securityCode.equals(other.securityCode))
      return false;
    if (securityExpDate == null) {
      if (other.securityExpDate != null)
        return false;
    } else if (!securityExpDate.equals(other.securityExpDate))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    } else if (!userName.equals(other.userName))
      return false;
    return true;
  }

}
