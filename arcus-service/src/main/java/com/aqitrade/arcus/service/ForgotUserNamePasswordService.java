package com.aqitrade.arcus.service;

public interface ForgotUserNamePasswordService {

  void forgotPassword(String userName);

  void changePassword(String userName, int securityCode, String password);

  void forgotUserName(long phoneNumber);
  
  public void changeUserName(Long phoneNumber, int securityCode, String userName);

}
