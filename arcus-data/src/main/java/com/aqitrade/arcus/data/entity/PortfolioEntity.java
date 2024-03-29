/*
 * Created on 31 Jan 2016 ( Time 10:54:23 ) Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite)

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

// import javax.validation.constraints.* ;
// import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "portfolio"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "portfolio", catalog = "arcus")
// Define named queries here
@NamedQueries({@NamedQuery(name = "PortfolioEntity.countAll",
    query = "SELECT COUNT(x) FROM PortfolioEntity x")})
public class PortfolioEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  // ----------------------------------------------------------------------
  // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
  // ----------------------------------------------------------------------
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "portfolio_id", nullable = false)
  private Integer portfolioId;


  // ----------------------------------------------------------------------
  // ENTITY DATA FIELDS
  // ----------------------------------------------------------------------
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "create_date", nullable = false)
  private Date createDate;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "stop_loss", nullable = false)
  private Double stopLoss;

  @Column(name = "stop_win", nullable = false)
  private Double stopWin;

  @Column(name = "gain", nullable = false)
  private Double gain;

  @Column(name = "active", nullable = false)
  private Boolean active;


  @Column(name = "user_id", nullable = false)
  private Long userId;


  // ----------------------------------------------------------------------
  // CONSTRUCTOR(S)
  // ----------------------------------------------------------------------
  public PortfolioEntity() {
    super();
  }

  // ----------------------------------------------------------------------
  // GETTER & SETTER FOR THE KEY FIELD
  // ----------------------------------------------------------------------
  public void setPortfolioId(Integer portfolioId) {
    this.portfolioId = portfolioId;
  }

  public Integer getPortfolioId() {
    return this.portfolioId;
  }

  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR FIELDS
  // ----------------------------------------------------------------------
  // --- DATABASE MAPPING : create_date ( TIMESTAMP )
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getCreateDate() {
    return this.createDate;
  }

  // --- DATABASE MAPPING : name ( VARCHAR )
  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  // --- DATABASE MAPPING : stop_loss ( DOUBLE )
  public void setStopLoss(Double stopLoss) {
    this.stopLoss = stopLoss;
  }

  public Double getStopLoss() {
    return this.stopLoss;
  }

  // --- DATABASE MAPPING : stop_win ( DOUBLE )
  public void setStopWin(Double stopWin) {
    this.stopWin = stopWin;
  }

  public Double getStopWin() {
    return this.stopWin;
  }

  // --- DATABASE MAPPING : gain ( DOUBLE )
  public void setGain(Double gain) {
    this.gain = gain;
  }

  public Double getGain() {
    return this.gain;
  }

  // --- DATABASE MAPPING : active ( BIT )
  public void setActive(Boolean active) {
    this.active = active;
  }

  public Boolean getActive() {
    return this.active;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return this.userId;
  }

  // ----------------------------------------------------------------------
  // toString METHOD
  // ----------------------------------------------------------------------
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    sb.append(portfolioId);
    sb.append("]:");
    sb.append(createDate);
    sb.append("|");
    sb.append(name);
    sb.append("|");
    sb.append(stopLoss);
    sb.append("|");
    sb.append(stopWin);
    sb.append("|");
    sb.append(gain);
    sb.append("|");
    sb.append(active);
    return sb.toString();
  }

}
