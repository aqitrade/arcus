package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.BrokerDao;
import com.aqitrade.arcus.data.entity.BrokerEntity;

@Repository
public class BrokerDaoImpl extends GenericDaoImpl<BrokerEntity, Integer> implements BrokerDao {

  public BrokerDaoImpl() {
    super(BrokerEntity.class);
  }

}
