package com.aqitrade.arcus.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
	public void save(D dto) {
		dao.save(mapper.map(dto, entityClass));
	}

}
