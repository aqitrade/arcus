package com.aqitrade.arcus.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.CountryDao;
import com.aqitrade.arcus.data.entity.CountryEntity;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<CountryEntity, Long> implements CountryDao {
  private final static Logger LOG = LoggerFactory.getLogger(CountryDaoImpl.class);

  public CountryDaoImpl() {
    super(CountryEntity.class);
  }
}
