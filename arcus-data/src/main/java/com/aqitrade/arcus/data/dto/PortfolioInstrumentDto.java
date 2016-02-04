package com.aqitrade.arcus.data.dto;

import java.io.Serializable;

public class PortfolioInstrumentDto implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long portfolioInstrumentId;
  private Double avgPrice;
  private Double qty;
  private Integer instrumentId;
  private Integer portfolioId;

  private InstrumentDto instrument;

  public PortfolioInstrumentDto() {
    super();
  }

  /**
   * @return the portfolioInstrumentId
   */
  public Long getPortfolioInstrumentId() {
    return portfolioInstrumentId;
  }

  /**
   * @param portfolioInstrumentId the portfolioInstrumentId to set
   */
  public void setPortfolioInstrumentId(Long portfolioInstrumentId) {
    this.portfolioInstrumentId = portfolioInstrumentId;
  }

  /**
   * @return the avgPrice
   */
  public Double getAvgPrice() {
    return avgPrice;
  }

  /**
   * @param avgPrice the avgPrice to set
   */
  public void setAvgPrice(Double avgPrice) {
    this.avgPrice = avgPrice;
  }

  /**
   * @return the qty
   */
  public Double getQty() {
    return qty;
  }

  /**
   * @param qty the qty to set
   */
  public void setQty(Double qty) {
    this.qty = qty;
  }

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
   * @return the instrument
   */
  public InstrumentDto getInstrument() {
    return instrument;
  }

  /**
   * @param instrument the instrument to set
   */
  public void setInstrument(InstrumentDto instrument) {
    this.instrument = instrument;
  }

}
