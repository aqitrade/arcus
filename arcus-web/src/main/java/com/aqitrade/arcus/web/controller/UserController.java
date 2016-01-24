package com.aqitrade.arcus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.service.UserService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/user", description = "User APIs")
@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "List all registered users", httpMethod = "GET")
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public @ResponseBody ServiceResponse<List<UserDto>> getUsers() {
    return new ServiceResponse<List<UserDto>>(userService.findAll());
  }

  @ApiOperation(value = "List user by id", httpMethod = "GET")
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
  public @ResponseBody ServiceResponse<UserDto> getUser(@PathVariable long userId) {
    return new ServiceResponse<UserDto>(userService.findOne(userId));
  }

  @ApiOperation(value = "Create new user", httpMethod = "POST")
  @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
  public @ResponseBody ServiceResponse<Void> saveUser(@RequestBody UserDto userDto) {
    userService.save(userDto);
    return new ServiceResponse<Void>();
  }

  @ApiOperation(value = "Delete user by id", httpMethod = "DELETE")
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
  public @ResponseBody ServiceResponse<Void> deleteUser(@PathVariable long userId) {
    userService.delete(userId);
    return new ServiceResponse<Void>();
  }

}
