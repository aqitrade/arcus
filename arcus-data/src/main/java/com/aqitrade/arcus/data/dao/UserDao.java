package com.aqitrade.arcus.data.dao;

import com.aqitrade.arcus.data.entity.UserEntity;

public interface UserDao extends GenericDao<UserEntity, Long> {

  /**
   * Returns User by name.
   *
   * @param userName user name
   * @return {@link UserEntity}
   */
  UserEntity getUserByUserName(String userName);

  /**
   * Returns user by phone number
   *
   * @param phoneNumber phone number
   * @return {@link UserEntity}
   */
  UserEntity getUserByPhoneNumber(Long phoneNumber);

  /**
   * Checks if user exists.
   *
   * @param userName user name
   * @return boolean true if use exists , false otherwise
   */
  boolean userExists(String userName);

  /**
   * Authenticates user based on username and password.
   *
   * @param userName user name
   * @param password password
   * @return boolean true if validation successful, false otherwise
   */
  boolean authenticateUser(String userName, String password);

}
