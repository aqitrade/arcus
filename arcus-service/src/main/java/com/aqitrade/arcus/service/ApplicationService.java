package com.aqitrade.arcus.service;

import java.util.List;

import org.apache.commons.collections.map.MultiValueMap;

import com.aqitrade.arcus.data.dto.ApplicationDto;
import com.aqitrade.arcus.data.entity.ApplicationEntity;

public interface ApplicationService
    extends GenericService<ApplicationEntity, ApplicationDto, Integer> {

  MultiValueMap getAllApplicationsByGroup();

  List<ApplicationDto> getAllApplicationsByGroupId(Integer applicationGroupId);
}
