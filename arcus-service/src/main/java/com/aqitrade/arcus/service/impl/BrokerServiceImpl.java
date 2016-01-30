package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.BrokerDao;
import com.aqitrade.arcus.data.dto.BrokerDto;
import com.aqitrade.arcus.data.entity.BrokerEntity;
import com.aqitrade.arcus.service.BrokerService;

@Service
public class BrokerServiceImpl extends GenericServiceImpl<BrokerEntity, BrokerDto, Integer>
    implements BrokerService {

  @Autowired
  public BrokerServiceImpl(BrokerDao brokerDao) {
    super(brokerDao);
  }

}
