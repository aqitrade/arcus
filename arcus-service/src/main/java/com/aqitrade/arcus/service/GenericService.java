package com.aqitrade.arcus.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService<ENTITY, DTO, ID extends Serializable> {

	DTO findOne(ID id);

	List<DTO> findAll();

	void save(DTO dto);
	
	void delete(ID id);
}
