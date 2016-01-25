package com.aqitrade.arcus.data.dao;

import com.aqitrade.arcus.data.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity, Long> {

  UserEntity getUserByUserName(String userName);

  boolean userExists(String userName);

  boolean authenticateUser(String userName, String password);

}
