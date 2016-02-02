package com.aqitrade.arcus.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.PortfolioDao;
import com.aqitrade.arcus.data.entity.PortfolioEntity;

@Repository
public class PortfolioDaoImpl extends GenericDaoImpl<PortfolioEntity, Integer>
    implements PortfolioDao {

  public PortfolioDaoImpl() {
    super(PortfolioEntity.class);
  }

  public List<PortfolioEntity> getPortfoliosByUser(Long userId) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("userId", userId);
    return getListByQuery("from PortfolioEntity x where x.userId=:userId and x.active=true", params);
  }
}
