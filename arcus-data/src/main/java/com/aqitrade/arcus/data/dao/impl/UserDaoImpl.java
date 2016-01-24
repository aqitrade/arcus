package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.entity.UserEntity;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements
		UserDao {

	public UserDaoImpl() {
		super(UserEntity.class);
	}
}
