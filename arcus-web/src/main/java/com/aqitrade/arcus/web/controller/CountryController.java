package com.aqitrade.arcus.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqitrade.arcus.data.dto.CountryDto;
import com.aqitrade.arcus.service.CountryService;
import com.aqitrade.arcus.web.model.ServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/country", description = "Country APIs")
@Controller
public class CountryController {

  @Autowired
  private CountryService countryService;

  @ApiOperation(value = "List all countries", httpMethod = "GET")
  @RequestMapping(value = "/countries", method = RequestMethod.GET)
  public @ResponseBody ServiceResponse<List<CountryDto>> getCountries() {
    return new ServiceResponse<List<CountryDto>>(countryService.findAll());
  }

  @ApiOperation(value = "View country by id", httpMethod = "GET")
  @RequestMapping(value = "/countries/{countryId}", method = RequestMethod.GET)
  public @ResponseBody ServiceResponse<CountryDto> getCountry(@PathVariable Long countryId) {
    return new ServiceResponse<CountryDto>(countryService.findOne(countryId));
  }

}
