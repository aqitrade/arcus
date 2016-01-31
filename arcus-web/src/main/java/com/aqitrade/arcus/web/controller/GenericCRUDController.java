package com.aqitrade.arcus.web.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aqitrade.arcus.service.GenericService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.ApiOperation;

/**
 * Generic CRUD controller to support all basic CRUD operation for an entity.
 * 
 * @author pani
 *
 * @param <ENTITY> Entity class name
 * @param <DTO> DTO class
 * @param <ID> primary key of an entoty
 */
public class GenericCRUDController<ENTITY, DTO, ID extends Serializable> {

  private GenericService<ENTITY, DTO, ID> genericService;

  public GenericCRUDController(GenericService<ENTITY, DTO, ID> genericService) {
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

  @ApiOperation(value = "Create", httpMethod = "POST")
  @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public ServiceResponse<DTO> save(@RequestBody DTO dto) {
    genericService.create(dto);
    return new ServiceResponse<DTO>(dto);
  }

  @ApiOperation(value = "Update", httpMethod = "PUT")
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ServiceResponse<Void> update(@PathVariable ID id, @RequestBody DTO dto) {
    genericService.update(id, dto);
    return ServiceResponse.SUCCESS;
  }

  @ApiOperation(value = "Delete", httpMethod = "DELETE")
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ServiceResponse<Void> delete(@PathVariable ID id) {
    genericService.delete(id);
    return ServiceResponse.SUCCESS;
  }
}
