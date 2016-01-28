package com.aqitrade.arcus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aqitrade.arcus.data.dto.KvStorageDto;
import com.aqitrade.arcus.data.entity.KvStorageEntity;
import com.aqitrade.arcus.service.KvStorageService;

import io.swagger.annotations.Api;

@Api(value = "/kv", description = "Key Value Storage APIs")
@RestController
@RequestMapping("kv")
public class KvStorageController extends GenericController<KvStorageEntity, KvStorageDto, Long> {

  @Autowired
  public KvStorageController(KvStorageService kvStorageService) {
    super(kvStorageService);
  }
}
