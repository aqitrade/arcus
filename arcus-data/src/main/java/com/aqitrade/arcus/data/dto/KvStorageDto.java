package com.aqitrade.arcus.data.dto;

public class KvStorageDto {
  private Long kvStorageId;
  private String storageKey;
  private String storageValue;
  private String storageMetadata;

  /**
   * @return the kvStorageId
   */
  public Long getKvStorageId() {
    return kvStorageId;
  }

  /**
   * @param kvStorageId the kvStorageId to set
   */
  public void setKvStorageId(Long kvStorageId) {
    this.kvStorageId = kvStorageId;
  }

  /**
   * @return the storageKey
   */
  public String getStorageKey() {
    return storageKey;
  }

  /**
   * @param storageKey the storageKey to set
   */
  public void setStorageKey(String storageKey) {
    this.storageKey = storageKey;
  }

  /**
   * @return the storageValue
   */
  public String getStorageValue() {
    return storageValue;
  }

  /**
   * @param storageValue the storageValue to set
   */
  public void setStorageValue(String storageValue) {
    this.storageValue = storageValue;
  }

  /**
   * @return the storageMetadata
   */
  public String getStorageMetadata() {
    return storageMetadata;
  }

  /**
   * @param storageMetadata the storageMetadata to set
   */
  public void setStorageMetadata(String storageMetadata) {
    this.storageMetadata = storageMetadata;
  }


}
