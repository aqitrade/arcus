/*
 * Created on 27 Jan 2016 ( Time 23:24:24 ) Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite)

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

// import javax.validation.constraints.* ;
// import org.hibernate.validator.constraints.* ;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * Persistent class for entity stored in table "kv_storage"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name = "kv_storage", catalog = "arcus")
// Define named queries here
@NamedQueries({@NamedQuery(name = "KvStorageEntity.countAll",
    query = "SELECT COUNT(x) FROM KvStorageEntity x")})
@Cacheable(true)
public class KvStorageEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  // ----------------------------------------------------------------------
  // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
  // ----------------------------------------------------------------------
  @Id
  @GenericGenerator(name = "generator", strategy = "increment")
  @GeneratedValue(generator = "generator")
  @Column(name = "kv_storage_id", nullable = false)
  private Long kvStorageId;


  // ----------------------------------------------------------------------
  // ENTITY DATA FIELDS
  // ----------------------------------------------------------------------
  @Column(name = "storage_key", nullable = false, length = 255)
  private String storageKey;

  @Column(name = "storage_value", nullable = false)
  private String storageValue;

  @Column(name = "storage_metadata")
  private String storageMetadata;



  // ----------------------------------------------------------------------
  // ENTITY LINKS ( RELATIONSHIP )
  // ----------------------------------------------------------------------

  // ----------------------------------------------------------------------
  // CONSTRUCTOR(S)
  // ----------------------------------------------------------------------
  public KvStorageEntity() {
    super();
  }

  // ----------------------------------------------------------------------
  // GETTER & SETTER FOR THE KEY FIELD
  // ----------------------------------------------------------------------
  public void setKvStorageId(Long kvStorageId) {
    this.kvStorageId = kvStorageId;
  }

  public Long getKvStorageId() {
    return this.kvStorageId;
  }

  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR FIELDS
  // ----------------------------------------------------------------------
  // --- DATABASE MAPPING : storage_key ( VARCHAR )
  public void setStorageKey(String storageKey) {
    this.storageKey = storageKey;
  }

  public String getStorageKey() {
    return this.storageKey;
  }

  // --- DATABASE MAPPING : storage_value ( TEXT )
  public void setStorageValue(String storageValue) {
    this.storageValue = storageValue;
  }

  public String getStorageValue() {
    return this.storageValue;
  }

  // --- DATABASE MAPPING : storage_metadata ( TEXT )
  public void setStorageMetadata(String storageMetadata) {
    this.storageMetadata = storageMetadata;
  }

  public String getStorageMetadata() {
    return this.storageMetadata;
  }


  // ----------------------------------------------------------------------
  // GETTERS & SETTERS FOR LINKS
  // ----------------------------------------------------------------------

  // ----------------------------------------------------------------------
  // toString METHOD
  // ----------------------------------------------------------------------
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    sb.append(kvStorageId);
    sb.append("]:");
    sb.append(storageKey);
    // attribute 'storageValue' not usable (type = String Long Text)
    // attribute 'storageMetadata' not usable (type = String Long Text)
    return sb.toString();
  }

}