/*
 * Created on 31 Jan 2016 ( Time 11:27:56 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Persistent class for entity stored in table "user"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="user", catalog="arcus" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="UserEntity.countAll", query="SELECT COUNT(x) FROM UserEntity x" )
} )
@Cacheable(true)
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)

public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id", nullable=false)
    private Long       userId       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="user_name", nullable=false, length=45)
    private String     userName     ;

    @Column(name="password", nullable=false, length=128)
    private String     password     ;

    @Column(name="first_name", nullable=false, length=45)
    private String     firstName    ;

    @Column(name="last_name", nullable=false, length=45)
    private String     lastName     ;

    @Column(name="country_name", nullable=false, length=45)
    private String     countryName  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_date", nullable=false)
    private Date       createDate   ;

    @Column(name="phone_number", nullable=false)
    private Long       phoneNumber  ;

    @Column(name="email_id", length=45)
    private String     emailId      ;

    @Column(name="active_ind")
    private Boolean    activeInd    ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_date")
    private Date       modifyDate   ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public UserEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setUserId( Long userId ) {
        this.userId = userId ;
    }
    public Long getUserId() {
        return this.userId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : user_name ( VARCHAR ) 
    public void setUserName( String userName ) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }

    //--- DATABASE MAPPING : password ( VARCHAR ) 
    public void setPassword( String password ) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }

    //--- DATABASE MAPPING : first_name ( VARCHAR ) 
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return this.firstName;
    }

    //--- DATABASE MAPPING : last_name ( VARCHAR ) 
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return this.lastName;
    }

    //--- DATABASE MAPPING : country_name ( VARCHAR ) 
    public void setCountryName( String countryName ) {
        this.countryName = countryName;
    }
    public String getCountryName() {
        return this.countryName;
    }

    //--- DATABASE MAPPING : create_date ( TIMESTAMP ) 
    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }

    //--- DATABASE MAPPING : phone_number ( BIGINT ) 
    public void setPhoneNumber( Long phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }
    public Long getPhoneNumber() {
        return this.phoneNumber;
    }

    //--- DATABASE MAPPING : email_id ( VARCHAR ) 
    public void setEmailId( String emailId ) {
        this.emailId = emailId;
    }
    public String getEmailId() {
        return this.emailId;
    }

    //--- DATABASE MAPPING : active_ind ( BIT ) 
    public void setActiveInd( Boolean activeInd ) {
        this.activeInd = activeInd;
    }
    public Boolean getActiveInd() {
        return this.activeInd;
    }

    //--- DATABASE MAPPING : modify_date ( TIMESTAMP ) 
    public void setModifyDate( Date modifyDate ) {
        this.modifyDate = modifyDate;
    }
    public Date getModifyDate() {
        return this.modifyDate;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(userId);
        sb.append("]:"); 
        sb.append(userName);
        sb.append("|");
        sb.append(password);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        sb.append("|");
        sb.append(countryName);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(phoneNumber);
        sb.append("|");
        sb.append(emailId);
        sb.append("|");
        sb.append(activeInd);
        sb.append("|");
        sb.append(modifyDate);
        return sb.toString(); 
    } 

}
