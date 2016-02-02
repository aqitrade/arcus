package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.PortfolioEntity;

public interface PortfolioDao extends GenericDao<PortfolioEntity, Integer> {

  List<PortfolioEntity> getPortfoliosByUser(Long userId);
}
