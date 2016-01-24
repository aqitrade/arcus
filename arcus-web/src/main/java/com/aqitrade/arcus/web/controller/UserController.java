package com.aqitrade.arcus.web.controller;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<UserDto> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public @ResponseBody UserDto getUser(@PathVariable long userId) {
		return userService.findOne(userId);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody void getUser(@RequestBody UserDto userDto) {
		userService.save(userDto);
	}
}
