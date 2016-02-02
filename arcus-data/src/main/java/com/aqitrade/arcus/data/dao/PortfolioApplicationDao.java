package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.PortfolioApplicationEntity;

public interface PortfolioApplicationDao extends GenericDao<PortfolioApplicationEntity, Integer> {

  List<PortfolioApplicationEntity> getPortfolioApplications(int portfolioId);
}
