package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.ApplicationGroupEntity;

public interface ApplicationGroupDao extends GenericDao<ApplicationGroupEntity, Integer> {

  List<ApplicationGroupEntity> findAllOrderByDisplayOrder();
}
