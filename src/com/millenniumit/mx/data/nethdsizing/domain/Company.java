package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;


import javax.persistence.*;


/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/


@Entity(name="company")
@Table(name="company")
public class Company extends AuditFields implements Serializable {

	
	private static final long serialVersionUID = 1L;

	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="CompanyValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@Column(nullable=false,unique = true)
	private String CompanyName;	
	
				/*  Get Set Methods For Column*/
	/**
	 * @return the ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param name the ID to set
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return CompanyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}	
}