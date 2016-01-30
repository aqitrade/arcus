package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.ApplicationGroupDao;
import com.aqitrade.arcus.data.entity.ApplicationGroupEntity;

@Repository
public class ApplicationGroupDaoImpl extends GenericDaoImpl<ApplicationGroupEntity, Integer>
    implements ApplicationGroupDao {

  public ApplicationGroupDaoImpl() {
    super(ApplicationGroupEntity.class);
  }

}
