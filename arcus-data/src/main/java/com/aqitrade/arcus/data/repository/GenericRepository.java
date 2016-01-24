package com.aqitrade.arcus.data.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<ENTITY, ID extends Serializable> extends
		JpaRepository<ENTITY, ID> {

}
