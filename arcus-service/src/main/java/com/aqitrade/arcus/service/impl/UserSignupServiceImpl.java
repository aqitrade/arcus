package com.aqitrade.arcus.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aqitrade.arcus.core.ErrorCodes;
import com.aqitrade.arcus.core.exception.ServiceException;
import com.aqitrade.arcus.data.dao.UserDao;
import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.data.entity.UserVerificationEntity;
import com.aqitrade.arcus.service.UserSignupService;
import com.aqitrade.arcus.service.UserVerificationService;
import com.google.common.base.Preconditions;

@Service
public class UserSignupServiceImpl implements UserSignupService {

  @Autowired
  private UserVerificationService userVerificationService;

  @Autowired
  private UserDao userDao;

  @Autowired
  private DozerBeanMapper mapper;


  @Transactional
  public void signupUser(UserDto userDto) {
    try {
      Preconditions.checkArgument(StringUtils.isNotBlank(userDto.getUserName()),
          "User Name must be not null");
      Preconditions.checkArgument(userDto.getPhoneNumber() != null, "User Name must be not null");
      Preconditions.checkArgument(userDto.getSecurityCode() != null, "Security must be not null");
      Preconditions.checkArgument(StringUtils.isNotBlank(userDto.getFirstName()),
          "First Name must be not null");
      Preconditions.checkArgument(StringUtils.isNotBlank(userDto.getLastName()),
          "Last Name must be not null");
      Preconditions.checkArgument(StringUtils.isNotBlank(userDto.getCountryName()),
          "Country name must be not null");

      final UserVerificationEntity vertificationEntity =
          userVerificationService.getVerification(userDto.getPhoneNumber());

      if (vertificationEntity == null || vertificationEntity.getSecurityCode() == null
          || vertificationEntity.getSecurityExpDate() == null) {
        throw new ServiceException.BadRequest("User identity not verified.");
      }

      if (!vertificationEntity.getSecurityCode().equals(userDto.getSecurityCode())) {
        throw new ServiceException.BadRequest("Security code does not match.");
      }

      final UserEntity userEntity = mapper.map(userDto, UserEntity.class);
      userEntity.setCreateDate(new Date());
      userEntity.setActiveInd(true);

//      vertificationEntity.setSecurityCode(null);
//      vertificationEntity.setSecurityExpDate(null);
      userVerificationService.save(vertificationEntity);

      userDao.save(userEntity);
    } catch (final Exception e) {
      throw new ServiceException.UserSignupException(ErrorCodes.USER_SIGN_UP_FAILED, e.getMessage(), e);
    }
  }
}
