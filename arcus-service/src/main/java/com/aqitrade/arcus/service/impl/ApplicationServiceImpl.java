package com.aqitrade.arcus.service.impl;

import java.util.List;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.ApplicationDao;
import com.aqitrade.arcus.data.dao.ApplicationGroupDao;
import com.aqitrade.arcus.data.dto.ApplicationDto;
import com.aqitrade.arcus.data.entity.ApplicationEntity;
import com.aqitrade.arcus.data.entity.ApplicationGroupEntity;
import com.aqitrade.arcus.service.ApplicationService;

@Service
public class ApplicationServiceImpl extends
    GenericServiceImpl<ApplicationEntity, ApplicationDto, Integer> implements ApplicationService {

  private ApplicationDao applicationDao;

  @Autowired
  private ApplicationGroupDao applicationGroupDao;

  @Autowired
  public ApplicationServiceImpl(ApplicationDao applicationDao) {
    super(applicationDao);
    this.applicationDao = applicationDao;
  }

  public MultiValueMap getAllApplicationsByGroup() {
    List<ApplicationGroupEntity> appGroups = applicationGroupDao.findAllOrderByDisplayOrder();
    MultiValueMap groupByMap = new MultiValueMap();
    for (ApplicationGroupEntity applicationGroupEntity : appGroups) {
      groupByMap.put(applicationGroupEntity.getGroupName(), applicationDao
          .getAllApplicationsByGroupId(applicationGroupEntity.getApplicationGroupId()));
    }
    return groupByMap;
  }

  public List<ApplicationDto> getAllApplicationsByGroupId(Integer applicationGroupId) {
    List<ApplicationEntity> entities =
        applicationDao.getAllApplicationsByGroupId(applicationGroupId);
    return convert(entities);
  }

}
