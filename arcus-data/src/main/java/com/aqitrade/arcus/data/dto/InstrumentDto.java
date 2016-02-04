package com.aqitrade.arcus.data.dto;

import java.io.Serializable;

public class InstrumentDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer instrumentId;

  private String symbol;

  private String name;

  private Double price;

  private Long volume;

  private Double openPrice;

  private Double closePrice;

  private Double highPrice;

  private Double lowPrice;

  private Double highLimit;

  private Double lowLimit;

  private String type;

  private Double marginRate;

  private Double commissionRate;

  private Double settlementPrice;

  private Long unitSize;

  private Double bid;

  private Double ask;

  private String exchangeId;

  /**
   * @return the instrumentId
   */
  public Integer getInstrumentId() {
    return instrumentId;
  }

  /**
   * @param instrumentId the instrumentId to set
   */
  public void setInstrumentId(Integer instrumentId) {
    this.instrumentId = instrumentId;
  }

  /**
   * @return the symbol
   */
  public String getSymbol() {
    return symbol;
  }

  /**
   * @param symbol the symbol to set
   */
  public void setSymbol(String symbol) {
    this.symbol = symbol;
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
   * @return the price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * @param price the price to set
   */
  public void setPrice(Double price) {
    this.price = price;
  }

  /**
   * @return the volume
   */
  public Long getVolume() {
    return volume;
  }

  /**
   * @param volume the volume to set
   */
  public void setVolume(Long volume) {
    this.volume = volume;
  }

  /**
   * @return the openPrice
   */
  public Double getOpenPrice() {
    return openPrice;
  }

  /**
   * @param openPrice the openPrice to set
   */
  public void setOpenPrice(Double openPrice) {
    this.openPrice = openPrice;
  }

  /**
   * @return the closePrice
   */
  public Double getClosePrice() {
    return closePrice;
  }

  /**
   * @param closePrice the closePrice to set
   */
  public void setClosePrice(Double closePrice) {
    this.closePrice = closePrice;
  }

  /**
   * @return the highPrice
   */
  public Double getHighPrice() {
    return highPrice;
  }

  /**
   * @param highPrice the highPrice to set
   */
  public void setHighPrice(Double highPrice) {
    this.highPrice = highPrice;
  }

  /**
   * @return the lowPrice
   */
  public Double getLowPrice() {
    return lowPrice;
  }

  /**
   * @param lowPrice the lowPrice to set
   */
  public void setLowPrice(Double lowPrice) {
    this.lowPrice = lowPrice;
  }

  /**
   * @return the highLimit
   */
  public Double getHighLimit() {
    return highLimit;
  }

  /**
   * @param highLimit the highLimit to set
   */
  public void setHighLimit(Double highLimit) {
    this.highLimit = highLimit;
  }

  /**
   * @return the lowLimit
   */
  public Double getLowLimit() {
    return lowLimit;
  }

  /**
   * @param lowLimit the lowLimit to set
   */
  public void setLowLimit(Double lowLimit) {
    this.lowLimit = lowLimit;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the marginRate
   */
  public Double getMarginRate() {
    return marginRate;
  }

  /**
   * @param marginRate the marginRate to set
   */
  public void setMarginRate(Double marginRate) {
    this.marginRate = marginRate;
  }

  /**
   * @return the commissionRate
   */
  public Double getCommissionRate() {
    return commissionRate;
  }

  /**
   * @param commissionRate the commissionRate to set
   */
  public void setCommissionRate(Double commissionRate) {
    this.commissionRate = commissionRate;
  }

  /**
   * @return the settlementPrice
   */
  public Double getSettlementPrice() {
    return settlementPrice;
  }

  /**
   * @param settlementPrice the settlementPrice to set
   */
  public void setSettlementPrice(Double settlementPrice) {
    this.settlementPrice = settlementPrice;
  }

  /**
   * @return the unitSize
   */
  public Long getUnitSize() {
    return unitSize;
  }

  /**
   * @param unitSize the unitSize to set
   */
  public void setUnitSize(Long unitSize) {
    this.unitSize = unitSize;
  }

  /**
   * @return the bid
   */
  public Double getBid() {
    return bid;
  }

  /**
   * @param bid the bid to set
   */
  public void setBid(Double bid) {
    this.bid = bid;
  }

  /**
   * @return the ask
   */
  public Double getAsk() {
    return ask;
  }

  /**
   * @param ask the ask to set
   */
  public void setAsk(Double ask) {
    this.ask = ask;
  }

  /**
   * @return the exchangeId
   */
  public String getExchangeId() {
    return exchangeId;
  }

  /**
   * @param exchangeId the exchangeId to set
   */
  public void setExchangeId(String exchangeId) {
    this.exchangeId = exchangeId;
  }



}
