package com.aqitrade.arcus.service;

import com.aqitrade.arcus.data.entity.UserVerificationEntity;

public interface UserVerificationService {

  void save(UserVerificationEntity entity);

  void sendSecurityCode(Long phoneNumber);

  void sendSecurityCode(String userName, Long phoneNumber);

  UserVerificationEntity getVerification(Long phoneNumber);
}
