package com.aqitrade.arcus.data.dao;

import java.util.List;

import com.aqitrade.arcus.data.entity.ApplicationEntity;

public interface ApplicationDao extends GenericDao<ApplicationEntity, Integer> {

  List<ApplicationEntity> getAllOrderByDisplayOrder();

  List<ApplicationEntity> getAllApplicationsByGroupId(Integer applicationGroupId);

}
