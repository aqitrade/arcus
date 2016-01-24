package com.aqitrade.arcus.data.dao;

import com.aqitrade.arcus.data.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity, Long> {

  boolean userExists(String userName);

}
