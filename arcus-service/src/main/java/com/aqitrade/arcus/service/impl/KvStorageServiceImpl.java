package com.aqitrade.arcus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aqitrade.arcus.data.dao.GenericDao;
import com.aqitrade.arcus.data.dto.KvStorageDto;
import com.aqitrade.arcus.data.entity.KvStorageEntity;
import com.aqitrade.arcus.service.KvStorageService;

@Service
public class KvStorageServiceImpl extends GenericServiceImpl<KvStorageEntity, KvStorageDto, Long>
    implements KvStorageService {

  @Autowired
  public KvStorageServiceImpl(GenericDao<KvStorageEntity, Long> dao) {
    super(dao);
  }
}
