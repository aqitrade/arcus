package com.aqitrade.arcus.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.ApplicationDto;
import com.aqitrade.arcus.data.entity.ApplicationEntity;
import com.aqitrade.arcus.service.ApplicationService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "applications", description = "Application APIs")
@RestController
@RequestMapping("applications")
public class ApplicationController
    extends GenericViewController<ApplicationEntity, ApplicationDto, Integer> {

  private ApplicationService applicationService;

  @Autowired
  public ApplicationController(ApplicationService applicationService) {
    super(applicationService);
    this.applicationService = applicationService;
  }

  @ApiOperation(value = "List Applications by Group", httpMethod = "GET")
  @RequestMapping(value = "groups", produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ServiceResponse<MultiValueMap> getApplicationsByGroup() {
    return new ServiceResponse<MultiValueMap>(applicationService.getAllApplicationsByGroup());
  }

  @ApiOperation(value = "View Applications by Group id", httpMethod = "GET")
  @RequestMapping(value = "groups/{applicationGroupId}",
      produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ServiceResponse<List<ApplicationDto>> getApplicationsByGroupId(
      @PathVariable Integer applicationGroupId) {

    List<ApplicationDto> list = applicationService.getAllApplicationsByGroupId(applicationGroupId);
    return new ServiceResponse<List<ApplicationDto>>(list);
  }

  @ApiOperation(value = "View Applications by Portfolio id", httpMethod = "GET")
  @RequestMapping(value = "{portfolioId}", produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ServiceResponse<List<ApplicationDto>> getApplicationsByPortfolioId(
      @PathVariable Integer applicationGroupId) {

    List<ApplicationDto> list = new ArrayList<ApplicationDto>();
    return new ServiceResponse<List<ApplicationDto>>(list);
  }



}
