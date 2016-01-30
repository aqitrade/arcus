package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @Value("${home.page.url}")
  private String homePageUrl;

  @RequestMapping("/")
  public String index() {
    return "redirect:"+homePageUrl;
  }
}
