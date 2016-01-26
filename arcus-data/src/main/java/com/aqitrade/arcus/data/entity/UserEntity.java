package com.aqitrade.arcus.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user")
public class UserEntity {

  @Id
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "first_name", nullable = true)
  private String firstName;

  @Column(name = "last_name", nullable = true)
  private String lastName;

  @Column(name = "user_name", nullable = false)
  private String userName;

  @Column(name = "country_name", nullable = false)
  private String countryName;

  @Column(name = "password", nullable = true)
  private String password;

  @Column(name = "phone_number", nullable = false)
  private Long phoneNumber;

  @Column(name = "email_id", nullable = true)
  private String emailId;

  @Column(name = "security_code", nullable = true)
  private Long securityCode;

  @Column(name = "security_exp_date", nullable = true)
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


}
