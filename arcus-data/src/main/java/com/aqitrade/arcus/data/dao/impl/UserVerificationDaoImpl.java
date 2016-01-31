package com.aqitrade.arcus.data.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.UserVerificationDao;
import com.aqitrade.arcus.data.entity.UserVerificationEntity;

@Repository
public class UserVerificationDaoImpl extends GenericDaoImpl<UserVerificationEntity, Long>
    implements UserVerificationDao {
  
  private final Logger log = LoggerFactory.getLogger(getClass());
  public UserVerificationDaoImpl() {
    super(UserVerificationEntity.class);
  }

  public UserVerificationEntity getVerificationCodeByPhoneNumber(long phoneNumber) {
    try {
      return getEntityManager()
          .createQuery("from UserVerificationEntity where phone_number = :phoneNumber",
              UserVerificationEntity.class)
          .setParameter("phoneNumber", phoneNumber).getSingleResult();
    } catch (javax.persistence.NoResultException e) {
      log.error(e.getMessage(), e);
    }
    return null;
  }

  public UserVerificationEntity getVerificationCodeByPhoneNumberAndUser(long phoneNumber,
      String userName) {
    try {
      return getEntityManager()
          .createQuery(
              "from UserVerificationEntity where phone_number = :phoneNumber and user_name=:userName ",
              UserVerificationEntity.class)
          .setParameter("phoneNumber", phoneNumber).setParameter("userName", userName)
          .getSingleResult();
    } catch (javax.persistence.NoResultException e) {
      log.error(e.getMessage(), e);
    }
    return null;
  }

}
