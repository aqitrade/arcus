package com.aqitrade.arcus.data.dto;

import java.util.Date;

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

}
