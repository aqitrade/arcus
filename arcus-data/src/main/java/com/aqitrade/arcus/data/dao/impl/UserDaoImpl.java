package com.aqitrade.arcus.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.entity.UserEntity;

@Repository
public class UserDaoImpl extends GenericDaoImpl<UserEntity, Long> implements UserDao {
  private final static Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

  public UserDaoImpl() {
    super(UserEntity.class);
  }

  public UserEntity getUserByUserName(String userName) {
    try {
      final UserEntity entity =
          getEntityManager().createQuery("select x from UserEntity x where user_name =?1", UserEntity.class)
              .setParameter(1, userName).getSingleResult();
      return entity;
    } catch (final javax.persistence.NoResultException e) {
      return null;
    }
  }

  public UserEntity getUserByPhoneNumber(Long phoneNumber) {
    try {
      final Object result =
          getEntityManager().createQuery("select x from UserEntity x where phone_number =?1")
              .setParameter(1, phoneNumber).getSingleResult();
      return (UserEntity) result;
    } catch (final javax.persistence.NoResultException e) {
      return null;
    }
  }

  public boolean userExists(String userName) {
    return getUserByUserName(userName) != null;
  }

  public boolean authenticateUser(String userName, String password) {
    try {
      final Object result = getEntityManager()
          .createQuery("select x from UserEntity x where user_name =?1 and password=?2")
          .setParameter(1, userName).setParameter(2, password).getSingleResult();
      return result != null;
    } catch (final javax.persistence.NoResultException e) {
      LOG.error(e.getMessage(), e);
      return false;
    }
  }
}
