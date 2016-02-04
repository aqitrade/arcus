package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.InstrumentDao;
import com.aqitrade.arcus.data.dto.InstrumentDto;
import com.aqitrade.arcus.data.entity.InstrumentEntity;
import com.aqitrade.arcus.service.InstrumentService;

@Service
public class InstrumentServiceImpl extends GenericServiceImpl<InstrumentEntity, InstrumentDto, Integer>
    implements InstrumentService {

  @Autowired
  public InstrumentServiceImpl(InstrumentDao dao) {
    super(dao);
  }


}
