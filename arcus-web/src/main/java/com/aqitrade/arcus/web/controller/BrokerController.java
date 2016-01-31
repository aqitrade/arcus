package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.BrokerDto;
import com.aqitrade.arcus.data.entity.BrokerEntity;
import com.aqitrade.arcus.service.BrokerService;

import io.swagger.annotations.Api;

@Api(value = "brokers", description = "Broker APIs")
@RestController
@RequestMapping("brokers")
public class BrokerController extends GenericViewController<BrokerEntity, BrokerDto, Integer> {

  @Autowired
  public BrokerController(BrokerService brokerService) {
    super(brokerService);
  }
}
