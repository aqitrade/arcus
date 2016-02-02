package com.aqitrade.arcus.data.dto;

import java.io.Serializable;

public class ApplicationDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer applicationId;
  private String name;
  private Integer applicationGroupId;

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
   * @return the applicationGroupId
   */
  public Integer getApplicationGroupId() {
    return applicationGroupId;
  }

  /**
   * @param applicationGroupId the applicationGroupId to set
   */
  public void setApplicationGroupId(Integer applicationGroupId) {
    this.applicationGroupId = applicationGroupId;
  }


}
