package com.aqitrade.arcus.data.dto;

public class ApplicationGroupDto {
  private Integer applicationGroupId;
  private String groupName;
  private Short displayOrder;

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

  /**
   * @return the groupName
   */
  public String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName the groupName to set
   */
  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  /**
   * @return the displayOrder
   */
  public Short getDisplayOrder() {
    return displayOrder;
  }

  /**
   * @param displayOrder the displayOrder to set
   */
  public void setDisplayOrder(Short displayOrder) {
    this.displayOrder = displayOrder;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "ApplicationGroupDto [applicationGroupId=" + applicationGroupId + ", groupName="
        + groupName + ", displayOrder=" + displayOrder + "]";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((applicationGroupId == null) ? 0 : applicationGroupId.hashCode());
    result = prime * result + ((displayOrder == null) ? 0 : displayOrder.hashCode());
    result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ApplicationGroupDto other = (ApplicationGroupDto) obj;
    if (applicationGroupId == null) {
      if (other.applicationGroupId != null)
        return false;
    } else if (!applicationGroupId.equals(other.applicationGroupId))
      return false;
    if (displayOrder == null) {
      if (other.displayOrder != null)
        return false;
    } else if (!displayOrder.equals(other.displayOrder))
      return false;
    if (groupName == null) {
      if (other.groupName != null)
        return false;
    } else if (!groupName.equals(other.groupName))
      return false;
    return true;
  }
}
