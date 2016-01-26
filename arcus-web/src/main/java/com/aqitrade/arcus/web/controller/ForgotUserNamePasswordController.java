package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.service.ForgotUserNamePasswordService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "forgot username password", description = "Forgot username/password APIs")
@RestController
public class ForgotUserNamePasswordController {

  @Autowired
  private ForgotUserNamePasswordService forgotUserNamePasswordService;

  @ApiOperation(
      value = "Forgot Password (This service will send security code text notification to user)",
      httpMethod = "POST")
  @RequestMapping(value = "password/forgot", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> forgotPassword(@RequestParam String userName) {
    forgotUserNamePasswordService.forgotPassword(userName);
    return new ServiceResponse<Void>();
  }

  @ApiOperation(value = "Change Password", httpMethod = "POST")
  @RequestMapping(value = "password/change", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> changePassword(@RequestParam String userName,
      @RequestParam int securityCode, @RequestParam String password) {
    forgotUserNamePasswordService.changePassword(userName, securityCode, password);
    return new ServiceResponse<Void>();
  }

  @ApiOperation(
      value = "Forgot UserName (This service will send security code text notification to user)",
      httpMethod = "POST")
  @RequestMapping(value = "username/forgot", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> forgotUserName(@RequestParam long phoneNumber) {
    forgotUserNamePasswordService.forgotUserName(phoneNumber);
    return new ServiceResponse<Void>();
  }

  @ApiOperation(value = "Change UserName", httpMethod = "POST")
  @RequestMapping(value = "username/change", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> changeUserName(@RequestParam long phoneNumber,
      @RequestParam int securityCode, @RequestParam String userName) {
    forgotUserNamePasswordService.changeUserName(phoneNumber, securityCode, userName);
    return new ServiceResponse<Void>();
  }

}
