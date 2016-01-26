package com.aqitrade.arcus.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.service.UserService;
import com.aqitrade.arcus.web.util.WebConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/login", description = "Login APIs")
@RestController
public class LoginController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "Login", httpMethod = "POST")
  @RequestMapping(value = "/login", method = RequestMethod.POST,
      consumes = "application/x-www-form-urlencoded")
  public ResponseEntity<Void> login(HttpServletRequest request,
      @RequestParam String userName, @RequestParam String password) {
    HttpSession session = request.getSession(true);
    if (session.isNew()) {
      if (userService.authenticateUser(userName, password)) {
        session.setAttribute(WebConstants.SessionAttributes.USER.name(),
            userService.getUserByUserName(userName));
        return new ResponseEntity<Void>(HttpStatus.OK);
      } else {
        return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
      }
    }
    return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
  }

  @ApiOperation(value = "Logout", httpMethod = "GET")
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ResponseEntity<Void> logout(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

}
