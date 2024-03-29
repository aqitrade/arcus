/*
 * Created on 31 Jan 2016 ( Time 10:54:23 ) Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite)

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

// import javax.validation.constraints.* ;
// import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Persistent class for entity stored in table "user_verification"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "user_verification", catalog = "arcus")
// Define named queries here
@NamedQueries({@NamedQuery(name = "UserVerificationEntity.countAll",
    query = "SELECT COUNT(x) FROM UserVerificationEntity x")})
public class UserVerificationEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  // ----------------------------------------------------------------------
  // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
  // ----------------------------------------------------------------------
  @Id
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  @Column(name = "user_verification_id", nullable = false)
  private Long userVerificationId;


  // ----------------------------------------------------------------------
  // ENTITY DATA FIELDS
  // ----------------------------------------------------------------------
  @Column(name = "user_name", length = 45)
  private String userName;

  @Column(name = "phone_number")
  private Long phoneNumber;

  @Column(name = "email_id", length = 45)
  private String emailId;

  @Column(name = "security_code")
  private Long securityCode;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "security_exp_date")
  private Date securityExpDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modify_date")
  private Date modifyDate;



  // ----------------------------------------------------------------------
  // ENTITY LINKS ( RELATIONSHIP )
  // ----------------------------------------------------------------------

  // ----------------------------------------------------------------------
  // CONSTRUCTOR(S)
  // ----------------------------------------------------------------------
  public UserVerificationEntity() {
    super();
  }

  // ----------------------------------------------------------------------
  // GETTER & SETTER FOR THE KEY FIELD
  // ----------------------------------------------------------------------
  public void setUserVerificationId(Long userVerificationId) {
    this.userVerificationId = userVerificationId;
  }

  public Long getUserVerificationId() {
    return this.userVerificationId;
  }

  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR FIELDS
  // ----------------------------------------------------------------------
  // --- DATABASE MAPPING : user_name ( VARCHAR )
  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserName() {
    return this.userName;
  }

  // --- DATABASE MAPPING : phone_number ( BIGINT )
  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Long getPhoneNumber() {
    return this.phoneNumber;
  }

  // --- DATABASE MAPPING : email_id ( VARCHAR )
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public String getEmailId() {
    return this.emailId;
  }

  // --- DATABASE MAPPING : security_code ( BIGINT )
  public void setSecurityCode(Long securityCode) {
    this.securityCode = securityCode;
  }

  public Long getSecurityCode() {
    return this.securityCode;
  }

  // --- DATABASE MAPPING : security_exp_date ( TIMESTAMP )
  public void setSecurityExpDate(Date securityExpDate) {
    this.securityExpDate = securityExpDate;
  }

  public Date getSecurityExpDate() {
    return this.securityExpDate;
  }

  // --- DATABASE MAPPING : modify_date ( TIMESTAMP )
  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Date getModifyDate() {
    return this.modifyDate;
  }


  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR LINKS
  // ----------------------------------------------------------------------

  // ----------------------------------------------------------------------
  // toString METHOD
  // ----------------------------------------------------------------------
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    sb.append(userVerificationId);
    sb.append("]:");
    sb.append(userName);
    sb.append("|");
    sb.append(phoneNumber);
    sb.append("|");
    sb.append(emailId);
    sb.append("|");
    sb.append(securityCode);
    sb.append("|");
    sb.append(securityExpDate);
    sb.append("|");
    sb.append(modifyDate);
    return sb.toString();
  }

}
