package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.CountryDao;
import com.aqitrade.arcus.data.dto.CountryDto;
import com.aqitrade.arcus.data.entity.CountryEntity;
import com.aqitrade.arcus.service.CountryService;

@Service
public class CountryServiceImpl extends GenericServiceImpl<CountryEntity, CountryDto, Long>
    implements CountryService {

  private CountryDao countryDao;

  @Autowired
  public CountryServiceImpl(CountryDao countryDao) {
    super(countryDao);
    this.countryDao = countryDao;
  }
}
