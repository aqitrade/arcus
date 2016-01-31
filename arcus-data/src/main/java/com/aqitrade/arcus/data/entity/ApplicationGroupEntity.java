/*
 * Created on 31 Jan 2016 ( Time 10:54:23 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.aqitrade.arcus.data.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.List;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "application_group"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="application_group", catalog="arcus" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ApplicationGroupEntity.countAll", query="SELECT COUNT(x) FROM ApplicationGroupEntity x" )
} )
public class ApplicationGroupEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="application_group_id", nullable=false)
    private Integer    applicationGroupId ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="group_name", nullable=false, length=45)
    private String     groupName    ;

    @Column(name="display_order", nullable=false)
    private Short      displayOrder ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ApplicationGroupEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setApplicationGroupId( Integer applicationGroupId ) {
        this.applicationGroupId = applicationGroupId ;
    }
    public Integer getApplicationGroupId() {
        return this.applicationGroupId;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : group_name ( VARCHAR ) 
    public void setGroupName( String groupName ) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return this.groupName;
    }

    //--- DATABASE MAPPING : display_order ( SMALLINT ) 
    public void setDisplayOrder( Short displayOrder ) {
        this.displayOrder = displayOrder;
    }
    public Short getDisplayOrder() {
        return this.displayOrder;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(applicationGroupId);
        sb.append("]:"); 
        sb.append(groupName);
        sb.append("|");
        sb.append(displayOrder);
        return sb.toString(); 
    } 

}
