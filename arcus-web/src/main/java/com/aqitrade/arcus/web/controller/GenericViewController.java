package com.aqitrade.arcus.web.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aqitrade.arcus.service.GenericService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.ApiOperation;

/**
 * Generic view controller class to support get all and get by id operations.
 * 
 * @author pani
 *
 * @param <ENTITY>
 * @param <DTO>
 * @param <ID>
 */
public class GenericViewController<ENTITY, DTO, ID extends Serializable> {

  private GenericService<ENTITY, DTO, ID> genericService;

  public GenericViewController(GenericService<ENTITY, DTO, ID> genericService) {
    this.genericService = genericService;
  }

  @ApiOperation(value = "List All", httpMethod = "GET")
  @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ServiceResponse<List<DTO>> getAll() {
    return new ServiceResponse<List<DTO>>(genericService.findAll());
  }

  @ApiOperation(value = "Get by id", httpMethod = "GET")
  @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
      method = RequestMethod.GET)
  public ServiceResponse<DTO> getById(@PathVariable ID id) {
    return new ServiceResponse<DTO>(genericService.findOne(id));
  }
}
