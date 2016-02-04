package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.InstrumentDao;
import com.aqitrade.arcus.data.entity.InstrumentEntity;

@Repository
public class InstrumentDaoImpl extends GenericDaoImpl<InstrumentEntity, Integer>
    implements InstrumentDao {

  public InstrumentDaoImpl() {
    super(InstrumentEntity.class);
  }

}
