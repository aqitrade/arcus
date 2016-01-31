package com.aqitrade.arcus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.service.UserService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Exposes endpoints for user entity.
 * 
 * @author pani
 *
 */
@Api(value = "/user", description = "User APIs")
@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @ApiOperation(value = "List all registered users", httpMethod = "GET")
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ServiceResponse<List<UserDto>> getUsers() {
    return new ServiceResponse<List<UserDto>>(userService.findAll());
  }

  @ApiOperation(value = "View user by id", httpMethod = "GET")
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
  public ServiceResponse<UserDto> getUser(@PathVariable long userId) {
    return new ServiceResponse<UserDto>(userService.findOne(userId));
  }

  @ApiOperation(value = "Check if user already exists", httpMethod = "HEAD")
  @RequestMapping(value = "/users/{userName}", method = RequestMethod.HEAD)
  public ResponseEntity<Void> checkUserExists(@PathVariable String userName) {
    if (userService.userExists(userName)) {
      return new ResponseEntity<Void>(HttpStatus.OK);
    }
    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
  }


  @ApiOperation(value = "Update existing user", httpMethod = "PUT")
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT,
      consumes = "application/json")
  public ServiceResponse<Void> updateUser(@RequestBody UserDto userDto, @PathVariable long userId) {
    userDto.setUserId(userId);
    userService.update(userId, userDto);
    return ServiceResponse.SUCCESS;
  }

  @ApiOperation(value = "Delete user by id", httpMethod = "DELETE")
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
  public ServiceResponse<Void> deleteUser(@PathVariable long userId) {
    userService.delete(userId);
    return ServiceResponse.SUCCESS;
  }
}
