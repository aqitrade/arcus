package com.aqitrade.arcus.data.dao;

import com.aqitrade.arcus.data.entity.UserVerificationEntity;

public interface UserVerificationDao extends GenericDao<UserVerificationEntity, Long> {

  UserVerificationEntity getVerificationCodeByPhoneNumber(long phoneNumber);

  UserVerificationEntity getVerificationCodeByPhoneNumberAndUser(long phoneNumber, String userName);
}
