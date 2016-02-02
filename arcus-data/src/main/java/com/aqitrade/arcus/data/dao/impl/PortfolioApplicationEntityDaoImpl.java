package com.aqitrade.arcus.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.PortfolioApplicationDao;
import com.aqitrade.arcus.data.entity.PortfolioApplicationEntity;

@Repository
public class PortfolioApplicationEntityDaoImpl
    extends GenericDaoImpl<PortfolioApplicationEntity, Integer> implements PortfolioApplicationDao {

  public PortfolioApplicationEntityDaoImpl() {
    super(PortfolioApplicationEntity.class);
  }

  public List<PortfolioApplicationEntity> getPortfolioApplications(int portfolioId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("portfolioId", portfolioId);
    return getListByQuery("from PortfolioApplicationEntity x where x.portfolioId = :portfolioId",
        parameters);
  }

}
