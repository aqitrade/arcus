package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.CountryDao;
import com.aqitrade.arcus.data.entity.CountryEntity;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<CountryEntity, Long> implements CountryDao {

  public CountryDaoImpl() {
    super(CountryEntity.class);
  }
}
