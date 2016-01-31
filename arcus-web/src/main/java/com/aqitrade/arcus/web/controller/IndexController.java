package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;

@Api(value = "index")
@Controller
public class IndexController {

  @Value("${home.page.url}")
  private String homePageUrl;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "redirect:" + homePageUrl;
  }
}
