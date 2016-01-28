package com.aqitrade.arcus.data.dto;

import java.util.Date;

/**
 * Client contact for country entity.
 * 
 * @author pani
 *
 */
public class CountryDto {
  private Long countryId;
  private String countryName;
  private String countryDisplayName;
  private String iso2aCountryCode;
  private String iso3aCountryCode;
  private int numCode;
  private Long phoneCode;
  private Date createDate;

  /**
   * @return the countryId
   */
  public Long getCountryId() {
    return countryId;
  }

  /**
   * @param userId the countryId to set
   */
  public void setCountryId(Long countryId) {
    this.countryId = countryId;
  }

  /**
   * @return the countryName
   */
  public String getCountryName() {
    return countryName;
  }

  /**
   * @param countryName the countryName to set
   */
  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  /**
   * @return the countryDisplayName
   */
  public String getCountryDisplayName() {
    return countryDisplayName;
  }

  /**
   * @param countryDisplayName the countryDisplayName to set
   */
  public void setcountryDisplayName(String countryDisplayName) {
    this.countryDisplayName = countryDisplayName;
  }

  /**
   * @return the iso2aCountryCode
   */
  public String getIso2aCountryCode() {
    return iso2aCountryCode;
  }

  /**
   * @param password the iso2aCountryCode to set
   */
  public void setIso2aCountryCode(String iso2aCountryCode) {
    this.iso2aCountryCode = iso2aCountryCode;
  }

  /**
   * @return the iso3aCountryCode
   */
  public String getIso3aCountryCode() {
    return iso3aCountryCode;
  }

  /**
   * @param iso3aCountryCode the iso3aCountryCode to set
   */
  public void setIso3aCountryCode(String iso3aCountryCode) {
    this.iso3aCountryCode = iso3aCountryCode;
  }

  /**
   * @return the numCode
   */
  public int getNumCode() {
    return numCode;
  }

  /**
   * @param numCode the numCode to set
   */
  public void setNumCode(int numCode) {
    this.numCode = numCode;
  }

  /**
   * @return the phoneCode
   */
  public Long getPhoneCode() {
    return phoneCode;
  }

  /**
   * @param phoneCode the phoneCode to set
   */
  public void setPhoneCode(Long phoneCode) {
    this.phoneCode = phoneCode;
  }

  /**
   * @return the createDate
   */
  public Date getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate the createDate to set
   */
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "CountryDto [countryId=" + countryId + ", countryName=" + countryName
        + ", countryDisplayName=" + countryDisplayName + ", iso2aCountryCode=" + iso2aCountryCode
        + ", iso3aCountryCode=" + iso3aCountryCode + ", numCode=" + numCode + ", phoneCode="
        + phoneCode + ", createDate=" + createDate + "]";
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
    result = prime * result + ((countryDisplayName == null) ? 0 : countryDisplayName.hashCode());
    result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
    result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
    result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
    result = prime * result + ((iso2aCountryCode == null) ? 0 : iso2aCountryCode.hashCode());
    result = prime * result + ((iso3aCountryCode == null) ? 0 : iso3aCountryCode.hashCode());
    result = prime * result + numCode;
    result = prime * result + ((phoneCode == null) ? 0 : phoneCode.hashCode());
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
    CountryDto other = (CountryDto) obj;
    if (countryDisplayName == null) {
      if (other.countryDisplayName != null)
        return false;
    } else if (!countryDisplayName.equals(other.countryDisplayName))
      return false;
    if (countryId == null) {
      if (other.countryId != null)
        return false;
    } else if (!countryId.equals(other.countryId))
      return false;
    if (countryName == null) {
      if (other.countryName != null)
        return false;
    } else if (!countryName.equals(other.countryName))
      return false;
    if (createDate == null) {
      if (other.createDate != null)
        return false;
    } else if (!createDate.equals(other.createDate))
      return false;
    if (iso2aCountryCode == null) {
      if (other.iso2aCountryCode != null)
        return false;
    } else if (!iso2aCountryCode.equals(other.iso2aCountryCode))
      return false;
    if (iso3aCountryCode == null) {
      if (other.iso3aCountryCode != null)
        return false;
    } else if (!iso3aCountryCode.equals(other.iso3aCountryCode))
      return false;
    if (numCode != other.numCode)
      return false;
    if (phoneCode == null) {
      if (other.phoneCode != null)
        return false;
    } else if (!phoneCode.equals(other.phoneCode))
      return false;
    return true;
  }

}
