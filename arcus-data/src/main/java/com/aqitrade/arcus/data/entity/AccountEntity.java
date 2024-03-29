/*
 * Created on 31 Jan 2016 ( Time 10:54:23 ) Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite)

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

// import javax.validation.constraints.* ;
// import org.hibernate.validator.constraints.* ;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "account"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "account", catalog = "arcus")
// Define named queries here
@NamedQueries({
    @NamedQuery(name = "AccountEntity.countAll", query = "SELECT COUNT(x) FROM AccountEntity x")})
public class AccountEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  // ----------------------------------------------------------------------
  // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
  // ----------------------------------------------------------------------
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "account_id", nullable = false)
  private Integer accountId;


  // ----------------------------------------------------------------------
  // ENTITY DATA FIELDS
  // ----------------------------------------------------------------------
  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "authentication_id", nullable = false, length = 65)
  private String authenticationId;

  @Column(name = "password", nullable = false, length = 128)
  private String password;

  @Column(name = "status", nullable = false, length = 9)
  private String status;

  // "portfolioId" (column "portfolio_id") is not defined by itself because used as FK in a link
  // "brokerId" (column "broker_id") is not defined by itself because used as FK in a link


  // ----------------------------------------------------------------------
  // ENTITY LINKS ( RELATIONSHIP )
  // ----------------------------------------------------------------------
  @Column(name = "portfolio_id", nullable = false)
  private Integer portfolioId;

  @Column(name = "broker_id", nullable = false)
  private Integer brokerId;


  // ----------------------------------------------------------------------
  // CONSTRUCTOR(S)
  // ----------------------------------------------------------------------
  public AccountEntity() {
    super();
  }

  // ----------------------------------------------------------------------
  // GETTER & SETTER FOR THE KEY FIELD
  // ----------------------------------------------------------------------
  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  public Integer getAccountId() {
    return this.accountId;
  }

  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR FIELDS
  // ----------------------------------------------------------------------
  // --- DATABASE MAPPING : name ( VARCHAR )
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  // --- DATABASE MAPPING : authentication_id ( VARCHAR )
  public void setAuthenticationId(String authenticationId) {
    this.authenticationId = authenticationId;
  }

  public String getAuthenticationId() {
    return this.authenticationId;
  }

  // --- DATABASE MAPPING : password ( VARCHAR )
  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return this.password;
  }

  // --- DATABASE MAPPING : status ( ENUM )
  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "AccountEntity [accountId=" + accountId + ", name=" + name + ", authenticationId="
        + authenticationId + ", password=" + password + ", status=" + status + ", portfolioId="
        + portfolioId + ", brokerId=" + brokerId + "]";
  }


}
