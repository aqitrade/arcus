package com.aqitrade.arcus.data.dto;

import java.io.Serializable;

public class ApplicationDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer applicationId;
  private String name;
  private ApplicationGroupDto applicationGroup;

  /**
   * @return the applicationId
   */
  public Integer getApplicationId() {
    return applicationId;
  }

  /**
   * @param applicationId the applicationId to set
   */
  public void setApplicationId(Integer applicationId) {
    this.applicationId = applicationId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the applicationGroup
   */
  public ApplicationGroupDto getApplicationGroup() {
    return applicationGroup;
  }

  /**
   * @param applicationGroup the applicationGroup to set
   */
  public void setApplicationGroup(ApplicationGroupDto applicationGroup) {
    this.applicationGroup = applicationGroup;
  }

}
