package com.aqitrade.arcus.service.impl;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.core.notification.SmsClient;
import com.aqitrade.arcus.core.util.CoreUtils;
import com.aqitrade.arcus.data.dao.UserVerificationDao;
import com.aqitrade.arcus.data.entity.UserVerificationEntity;
import com.aqitrade.arcus.service.UserVerificationService;
import com.google.common.base.Preconditions;

@Service
public class UserVerificationServiceImpl implements UserVerificationService {
  private final Logger log = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserVerificationDao userVerificationDao;

  @Autowired
  private SmsClient smsClient;

  @Transactional
  public void sendSecurityCode(Long phoneNumber) {
    sendSecurityCode(null, phoneNumber);
  }

  public void save(UserVerificationEntity entity) {
    userVerificationDao.save(entity);
  }

  public UserVerificationEntity getVerification(Long phoneNumber) {
    UserVerificationEntity entity = null;
    try {
      entity = userVerificationDao.getVerificationCodeByPhoneNumber(phoneNumber);
    } catch (javax.persistence.NoResultException e) {
      log.warn("No user verification record found!");
    }
    return entity;
  }

  @Transactional
  public void sendSecurityCode(String userName, Long phoneNumber) {
    Preconditions.checkArgument(phoneNumber != null, "phoneNumber must not be null");
    UserVerificationEntity entity = null;
    entity = userVerificationDao.getVerificationCodeByPhoneNumber(phoneNumber);
    if (entity != null) {
      if (entity.getSecurityExpDate() != null) {
        final DateTime dateTime = new DateTime(entity.getSecurityExpDate());
        if (dateTime.isAfterNow()) {
          throw new ServiceException.BadRequest(ErrorCodes.BAD_REQUEST,
              "Secruity code has been already sent to phone number: " + phoneNumber);
        }
      }
    } else {
      entity = new UserVerificationEntity();
    }

    long securityCode = CoreUtils.generateSecurityCode();
    entity.setSecurityCode(securityCode);

    DateTime dateTime = new DateTime(System.currentTimeMillis()).plusHours(1);;
    Date securityExpDate = dateTime.toDate();
    entity.setSecurityExpDate(securityExpDate);
    entity.setPhoneNumber(phoneNumber);

    if (userName != null) {
      entity.setUserName(userName);
    }
    smsClient.sendTextMessage(phoneNumber,
        String.format("Your AQiTrade security code is %s", securityCode));

    userVerificationDao.save(entity);
  }

}
