package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.service.UserService;

@Service
public class UserServiceImpl extends
		GenericServiceImpl<UserEntity, UserDto, Long> implements UserService {

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
	}

}