package com.aqitrade.arcus.service;

import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.data.entity.UserEntity;

public interface UserService extends GenericService<UserEntity, UserDto, Long>{

  boolean userExists(String userName);

  boolean authenticateUser(String userName, String password);
  
  UserDto getUserByUserName(String userName);
}
