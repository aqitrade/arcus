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

/**
 * Exposes REST endpoints for forgot username and password.
 *
 * @author pani
 *
 */
@Api(value = "forgot username password", description = "Forgot username/password APIs")
@RestController
public class ForgotUserNamePasswordController {

  @Autowired
  private ForgotUserNamePasswordService forgotUserNamePasswordService;

  /**
   * REST endpoint to handle forgot password. Calling this service will send SMS notification with
   * security code to user's phone number.
   *
   * @param userName user name for which password need to be changed
   * @return ServiceResponse success/error status
   */
  @ApiOperation(
      value = "Forgot Password (This service will send security code text notification to user)",
      httpMethod = "POST")
  @RequestMapping(value = "password/forgot", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> forgotPassword(@RequestParam String userName) {
    forgotUserNamePasswordService.forgotPassword(userName);
    return ServiceResponse.SUCCESS;
  }

  /**
   * REST endpoint to handle password change after receiving security code through notification
   * service either SMS or email.
   *
   * @param userName user name
   * @param securityCode security code received from forgot password
   * @param password new password
   * @return ServiceResponse with success/error status
   */
  @ApiOperation(value = "Change Password", httpMethod = "POST")
  @RequestMapping(value = "password/change", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> changePassword(@RequestParam String userName,
      @RequestParam int securityCode, @RequestParam String password) {
    forgotUserNamePasswordService.changePassword(userName, securityCode, password);
    return ServiceResponse.SUCCESS;
  }

  /**
   * REST endpoint to handle forgot username. This service will send security code through
   * notification service.
   *
   * @param phoneNumber phone number of an user
   * @return ServiceResponse success or error status
   */
  @ApiOperation(
      value = "Forgot UserName (This service will send security code text notification to user)",
      httpMethod = "POST")
  @RequestMapping(value = "username/forgot", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> forgotUserName(@RequestParam long phoneNumber) {
    forgotUserNamePasswordService.forgotUserName(phoneNumber);
    return ServiceResponse.SUCCESS;
  }

  /**
   * REST endpoint to change username after receiving security code from notification.
   *
   * @param phoneNumber phone number of an user
   * @param securityCode security code received from notification service
   * @param userName new user name
   * @return ServiceResponse success/error status
   */
  @ApiOperation(value = "Change UserName", httpMethod = "POST")
  @RequestMapping(value = "username/change", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public ServiceResponse<Void> changeUserName(@RequestParam long phoneNumber,
      @RequestParam int securityCode, @RequestParam String userName) {
    forgotUserNamePasswordService.changeUserName(phoneNumber, securityCode, userName);
    return ServiceResponse.SUCCESS;
  }

}
