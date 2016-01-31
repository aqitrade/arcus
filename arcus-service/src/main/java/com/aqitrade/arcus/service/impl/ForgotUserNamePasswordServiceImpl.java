package com.aqitrade.arcus.service.impl;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.data.entity.UserVerificationEntity;
import com.aqitrade.arcus.service.ForgotUserNamePasswordService;
import com.aqitrade.arcus.service.UserVerificationService;

@Service
public class ForgotUserNamePasswordServiceImpl implements ForgotUserNamePasswordService {

  private final static Logger LOG =
      LoggerFactory.getLogger(ForgotUserNamePasswordServiceImpl.class);

  @Autowired
  private UserDao userDao;

  @Autowired
  private UserVerificationService userVerificationService;

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
    userVerificationService.sendSecurityCode(userEntity.getUserName(), userEntity.getPhoneNumber());
  }

  @Transactional
  public void changePassword(String userName, int securityCode, String password) {
    final UserEntity userEntity = userDao.getUserByUserName(userName);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    final UserVerificationEntity userVerificationEntity =
        userVerificationService.getVerification(userEntity.getPhoneNumber());

    validateSecurityCodeAndExpiryDate(securityCode, userVerificationEntity);

    // reset
    userVerificationEntity.setSecurityCode(null);
    userVerificationEntity.setSecurityExpDate(null);

    userEntity.setPassword(password);
    userDao.save(userEntity);
  }

  @Transactional
  public void changeUserName(Long phoneNumber, int securityCode, String userName) {
    final UserEntity userEntity = userDao.getUserByPhoneNumber(phoneNumber);
    if (userEntity == null) {
      throw new ServiceException.EntityNotFoundException(ErrorCodes.USER_DOES_NOT_EXISTS);
    }

    final UserVerificationEntity userVerificationEntity =
        userVerificationService.getVerification(userEntity.getPhoneNumber());

    validateSecurityCodeAndExpiryDate(securityCode, userVerificationEntity);

    // reset
    userVerificationEntity.setSecurityCode(null);
    userVerificationEntity.setSecurityExpDate(null);

    userEntity.setUserName(userName);
    userDao.save(userEntity);
  }

  private void validateSecurityCodeAndExpiryDate(int securityCode,
      UserVerificationEntity userVerificationEntity) {
    if (userVerificationEntity.getSecurityCode() == null
        || userVerificationEntity.getSecurityExpDate() == null) {
      throw new ServiceException.BadRequest(ErrorCodes.SECURITY_CODE_EXPIRED);
    }

    if (userVerificationEntity.getSecurityCode() != securityCode) {
      throw new ServiceException.BadRequest(ErrorCodes.BAD_REQUEST);
    }

    if (userVerificationEntity.getSecurityExpDate() != null) {
      final DateTime dateTime = new DateTime(userVerificationEntity.getSecurityExpDate());
      if (!dateTime.isAfterNow()) {
        throw new ServiceException.BadRequest(ErrorCodes.SECURITY_CODE_EXPIRED);
      }
    }
  }
}
