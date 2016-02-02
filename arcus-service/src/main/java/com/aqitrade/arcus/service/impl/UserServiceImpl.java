package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserEntity, UserDto, Long>
    implements UserService {

  private UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    super(userDao);
    this.userDao = userDao;
  }

  public boolean userExists(String userName) {
    return userDao.userExists(userName);
  }

  public boolean authenticateUser(String userName, String password) {
    return userDao.authenticateUser(userName, password);
  }

  public UserDto getUserByUserName(String userName) {
    return convert(userDao.getUserByUserName(userName));
  }
}
