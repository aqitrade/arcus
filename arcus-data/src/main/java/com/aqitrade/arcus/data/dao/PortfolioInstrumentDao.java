package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.PortfolioInstrumentEntity;

public interface PortfolioInstrumentDao extends GenericDao<PortfolioInstrumentEntity, Long> {

  List<PortfolioInstrumentEntity> getPortfolioInstruments(int portfolioId);
}
