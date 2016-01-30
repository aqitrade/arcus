/*
 * Created on 26 Jan 2016 ( Time 21:53:29 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "country"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="country", catalog="arcus" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CountryEntity.countAll", query="SELECT COUNT(x) FROM CountryEntity x" )
} )
@Cacheable(true)
public class CountryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="country_id", nullable=false)
    private Long       countryId    ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="country_name", nullable=false, length=45)
    private String     countryName  ;

    @Column(name="country_display_name", nullable=false, length=45)
    private String     countryDisplayName ;

    @Column(name="iso_2a_country_code", nullable=false, length=128)
    private String     iso2aCountryCode ;

    @Column(name="iso_3a_country_code", length=128)
    private String     iso3aCountryCode ;

    @Column(name="numcode")
    private Short      numcode      ;

    @Column(name="phonecode", nullable=false)
    private Integer    phonecode    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date       createDate   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CountryEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setCountryId( Long countryId ) {
        this.countryId = countryId ;
    }
    public Long getCountryId() {
        return this.countryId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : country_name ( VARCHAR ) 
    public void setCountryName( String countryName ) {
        this.countryName = countryName;
    }
    public String getCountryName() {
        return this.countryName;
    }

    //--- DATABASE MAPPING : country_display_name ( VARCHAR ) 
    public void setCountryDisplayName( String countryDisplayName ) {
        this.countryDisplayName = countryDisplayName;
    }
    public String getCountryDisplayName() {
        return this.countryDisplayName;
    }

    //--- DATABASE MAPPING : iso_2a_country_code ( VARCHAR ) 
    public void setIso2aCountryCode( String iso2aCountryCode ) {
        this.iso2aCountryCode = iso2aCountryCode;
    }
    public String getIso2aCountryCode() {
        return this.iso2aCountryCode;
    }

    //--- DATABASE MAPPING : iso_3a_country_code ( VARCHAR ) 
    public void setIso3aCountryCode( String iso3aCountryCode ) {
        this.iso3aCountryCode = iso3aCountryCode;
    }
    public String getIso3aCountryCode() {
        return this.iso3aCountryCode;
    }

    //--- DATABASE MAPPING : numcode ( SMALLINT ) 
    public void setNumcode( Short numcode ) {
        this.numcode = numcode;
    }
    public Short getNumcode() {
        return this.numcode;
    }

    //--- DATABASE MAPPING : phonecode ( INT ) 
    public void setPhonecode( Integer phonecode ) {
        this.phonecode = phonecode;
    }
    public Integer getPhonecode() {
        return this.phonecode;
    }

    //--- DATABASE MAPPING : create_date ( TIMESTAMP ) 
    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(countryId);
        sb.append("]:"); 
        sb.append(countryName);
        sb.append("|");
        sb.append(countryDisplayName);
        sb.append("|");
        sb.append(iso2aCountryCode);
        sb.append("|");
        sb.append(iso3aCountryCode);
        sb.append("|");
        sb.append(numcode);
        sb.append("|");
        sb.append(phonecode);
        sb.append("|");
        sb.append(createDate);
        return sb.toString(); 
    } 

}
