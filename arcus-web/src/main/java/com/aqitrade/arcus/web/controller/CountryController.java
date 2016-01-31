package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.CountryDto;
import com.aqitrade.arcus.data.entity.CountryEntity;
import com.aqitrade.arcus.service.CountryService;

import io.swagger.annotations.Api;

/**
 * Exposes REST endpoints for country.
 * 
 * @author pani
 *
 */
@Api(value = "/countries", description = "Country APIs")
@RestController
@RequestMapping("/countries")
public class CountryController extends GenericViewController<CountryEntity, CountryDto, Long> {

  @Autowired
  public CountryController(CountryService countryService) {
    super(countryService);
  }
}
