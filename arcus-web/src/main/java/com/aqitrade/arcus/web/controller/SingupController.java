package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.service.UserSignupService;
import com.aqitrade.arcus.service.UserVerificationService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;

@Api(value = "signup", description = "User signup APIs")
@RestController
public class SingupController {

  @Autowired
  private UserVerificationService userVerificationService;
  
  @Autowired
  private UserSignupService userSignupService;

  @RequestMapping(value = "signup/verification/{phoneNumber}", method = RequestMethod.GET)
  public ServiceResponse<Void> sendVerification(@PathVariable long phoneNumber) {
    userVerificationService.sendSecurityCode(phoneNumber);
    return ServiceResponse.SUCCESS;
  }

  @RequestMapping(value = "signup", method = RequestMethod.POST)
  public ServiceResponse<Void> send(@RequestBody UserDto userDto) {
    userSignupService.signupUser(userDto);
    return ServiceResponse.SUCCESS;
  }

}
