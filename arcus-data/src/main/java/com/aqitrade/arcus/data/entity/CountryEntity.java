package com.aqitrade.arcus.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "country")
public class CountryEntity {

  @Id
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  @Column(name = "country_id", nullable = false)
  private long countryId;

  @Column(name = "country_name", nullable = false)
  private String countryName;

  @Column(name = "country_display_name", nullable = false)
  private String countryDisplayName;

  @Column(name = "iso_2a_country_code", nullable = false)
  private String iso2aCountryCode;

  @Column(name = "iso_3a_country_code", nullable = true)
  private String iso3aCountryCode;

  @Column(name = "numcode", nullable = true)
  private int numCode;

  @Column(name = "phonecode", nullable = false)
  private Long phoneCode;

  @Column(name = "create_date", nullable = false)
  private Date createDate;



  /**
   * @return the country_id
   */
  public Long getCountryId() {
    return countryId;
  }

  /**
   * @param countryId the countryId to set
   */
  public void setCountryId(Long countryId) {
    this.countryId = countryId;
  }

  //country_name
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

  //country_display_name
  /**
   * @return the countryDisplayName
   */
  public String getCountryDisplayName() {
    return countryDisplayName;
  }

  /**
   * @param countryDisplayName the countryDisplayName to set
   */
  public void setCountryDisplayName(String countryDisplayName) {
    this.countryDisplayName = countryDisplayName;
  }
  //iso_2a_country_code
  /**
   * @return the iso2aCountryCode
   */
  public String getIso2aCountryCode() {
    return iso2aCountryCode;
  }

  /**
   * @param iso2aCountryCode the iso2aCountryCode to set
   */
  public void setIso2aCountryCode(String iso2aCountryCode) {
    this.iso2aCountryCode = iso2aCountryCode;
  }

  //iso_3a_country_code
  /**
   * @return the iso2aCountryCode
   */
  public String getIso3aCountryCode() {
    return iso3aCountryCode;
  }

  /**
   * @param iso3aCountryCode the iso2aCountryCode to set
   */
  public void setIso3aCountryCode(String iso3aCountryCode) {
    this.iso3aCountryCode = iso3aCountryCode;
  }
  //numcode
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
