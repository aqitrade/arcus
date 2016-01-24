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

  public boolean userExists(String userName) {
    try {
      Object result =
          getEntityManager().createQuery("select x from UserEntity x where user_name =?1")
              .setParameter(1, userName).getSingleResult();
      return result != null;
    } catch (javax.persistence.NoResultException e) {
      LOG.error(e.getMessage(), e);
      return false;
    }
  }
}
