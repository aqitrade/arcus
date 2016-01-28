package com.aqitrade.arcus.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.aqitrade.arcus.data.dao.KvStorageDao;
import com.aqitrade.arcus.data.entity.KvStorageEntity;

@Repository
public class KvStorageDaoImpl extends GenericDaoImpl<KvStorageEntity, Long>
    implements KvStorageDao {

  public KvStorageDaoImpl() {
    super(KvStorageEntity.class);
  }

}
