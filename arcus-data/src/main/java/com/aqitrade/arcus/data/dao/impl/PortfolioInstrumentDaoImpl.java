package com.aqitrade.arcus.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.PortfolioInstrumentDao;
import com.aqitrade.arcus.data.entity.PortfolioInstrumentEntity;

@Repository
public class PortfolioInstrumentDaoImpl extends GenericDaoImpl<PortfolioInstrumentEntity, Long>
 implements PortfolioInstrumentDao{

  public PortfolioInstrumentDaoImpl() {
    super(PortfolioInstrumentEntity.class);
  }

  public List<PortfolioInstrumentEntity> getPortfolioInstruments(int portfolioId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("portfolioId", portfolioId);
    return getListByQuery("from PortfolioInstrumentEntity x where x.portfolioId = :portfolioId",
        parameters);
  }

}
