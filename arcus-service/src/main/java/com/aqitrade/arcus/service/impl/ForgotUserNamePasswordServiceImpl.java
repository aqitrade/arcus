package com.aqitrade.arcus.service.impl;

import java.util.Random;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.core.notification.SmsClient;
import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.service.ForgotUserNamePasswordService;

@Service
public class ForgotUserNamePasswordServiceImpl implements ForgotUserNamePasswordService {

  private final static Logger LOG =
      LoggerFactory.getLogger(ForgotUserNamePasswordServiceImpl.class);

  @Autowired
  private UserDao userDao;

  @Autowired
  private SmsClient smsClient;

  @Transactional
  public void forgotPassword(String userName) {
    final UserEntity userEntity = userDao.getUserByUserName(userName);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    notifyUser(userEntity);
  }

  @Transactional
  public void forgotUserName(long phoneNumber) {
    final UserEntity userEntity = userDao.getUserByPhoneNumber(phoneNumber);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    notifyUser(userEntity);
  }

  private void notifyUser(UserEntity userEntity) {

    final long activationSecurityCode = generateActivationSecurityCode();
    LOG.debug("Activation security code to be sent: {}", activationSecurityCode);

    DateTime dateTime = new DateTime(System.currentTimeMillis()).plusHours(1);

    userEntity.setSecurityCode(activationSecurityCode);
    userEntity.setSecurityExpDate(dateTime.toDate());

    // save security code
    userDao.save(userEntity);

    smsClient.sendTextMessage(userEntity.getPhoneNumber(),
        String.format("Your AqiTrade security code is %s", activationSecurityCode));
  }

  private int generateActivationSecurityCode() {
    Random r = new Random(System.currentTimeMillis());
    return ((1 + r.nextInt(8)) * 10000 + r.nextInt(10000));
  }

  @Transactional
  public void changePassword(String userName, int securityCode, String password) {
    final UserEntity userEntity = userDao.getUserByUserName(userName);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    validateSecurityCodeAndExpiryDate(securityCode, userEntity);

    userEntity.setSecurityCode(null);
    userEntity.setSecurityExpDate(null);
    userEntity.setPassword(password);
    userDao.save(userEntity);
  }

  @Transactional
  public void changeUserName(Long phoneNumber, int securityCode, String userName) {
    final UserEntity userEntity = userDao.getUserByPhoneNumber(phoneNumber);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    validateSecurityCodeAndExpiryDate(securityCode, userEntity);

    userEntity.setSecurityCode(null);
    userEntity.setSecurityExpDate(null);
    userEntity.setUserName(userName);
    userDao.save(userEntity);
  }

  private void validateSecurityCodeAndExpiryDate(int securityCode, UserEntity userEntity) {
    if (userEntity.getSecurityCode() == null || userEntity.getSecurityExpDate() == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.SECURITY_CODE_EXPIRED);
    }

    if (userEntity.getSecurityCode() != securityCode) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.SECURITY_CODE_DOES_NOT_MATCH);
    }

    if (userEntity.getSecurityExpDate() != null) {
      DateTime dateTime = new DateTime(userEntity.getSecurityExpDate());
      if (!dateTime.isAfterNow()) {
        throw new ServiceException.EntityNotFoundException(ErrorCodes.SECURITY_CODE_EXPIRED);
      }
    }
  }
}
