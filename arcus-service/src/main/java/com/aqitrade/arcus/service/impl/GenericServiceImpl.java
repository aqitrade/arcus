package com.aqitrade.arcus.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.data.dao.GenericDao;
import com.aqitrade.arcus.service.GenericService;

public class GenericServiceImpl<T, D, ID extends Serializable> implements GenericService<T, D, ID> {

  @Autowired
  private DozerBeanMapper mapper;

  protected Class<T> entityClass;

  protected Class<D> dtoClass;

  GenericDao<T, ID> dao;

  @SuppressWarnings("unchecked")
  public GenericServiceImpl(GenericDao<T, ID> dao) {
    this.dao = dao;
    ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
    this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    this.dtoClass = (Class<D>) genericSuperclass.getActualTypeArguments()[1];

  }

  public D findOne(ID id) {
    return mapper.map(dao.get(id), dtoClass);
  }

  public List<D> findAll() {
    List<D> result = new ArrayList<D>();
    for (T t : dao.getAll()) {
      result.add(mapper.map(t, dtoClass));
    }
    return result;
  }

  @Transactional
  public void create(D dto) {
    try {
      T t = dao.save(mapper.map(dto, entityClass));
      mapper.map(t, dto);
    } catch (Exception e) {
      throw new ServiceException.DataAccessException(ErrorCodes.SAVE_FAILED, e);
    }
  }

  @Transactional
  public void update(ID id, D dto) {
    try {
      T entity = dao.get(id);
      mapper.map(dto, entity);
      dao.save(entity);
    } catch (Exception e) {
      throw new ServiceException.DataAccessException(ErrorCodes.SAVE_FAILED, e);
    }
  }

  @Transactional
  public void delete(ID id) {
    try {
      dao.remove(id);
    } catch (Exception e) {
      throw new ServiceException.DataAccessException(ErrorCodes.DELETION_FAILED, e);
    }
  }

  public List<D> convert(List<T> list) {
    List<D> result = new ArrayList<D>();
    for (T t : list) {
      result.add(mapper.map(t, dtoClass));
    }
    return result;
  }
}
