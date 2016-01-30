package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.ApplicationGroupDao;
import com.aqitrade.arcus.data.dto.ApplicationGroupDto;
import com.aqitrade.arcus.data.entity.ApplicationGroupEntity;
import com.aqitrade.arcus.service.ApplicationGroupService;

@Service
public class ApplicationGroupServiceImpl
    extends GenericServiceImpl<ApplicationGroupEntity, ApplicationGroupDto, Integer>
    implements ApplicationGroupService {

  @Autowired
  public ApplicationGroupServiceImpl(ApplicationGroupDao applicationGroupDao) {
    super(applicationGroupDao);
  }

}
