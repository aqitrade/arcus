package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.ApplicationGroupDto;
import com.aqitrade.arcus.data.entity.ApplicationGroupEntity;
import com.aqitrade.arcus.service.ApplicationGroupService;

import io.swagger.annotations.Api;

@Api(value = "applicationgroups", description = "Application group APIs")
@RestController
@RequestMapping("applicationgroups")
public class ApplicationGroupController
    extends GenericViewController<ApplicationGroupEntity, ApplicationGroupDto, Integer> {

  @Autowired
  public ApplicationGroupController(ApplicationGroupService applicationGroupService) {
    super(applicationGroupService);
  }
}
