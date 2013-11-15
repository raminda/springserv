package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author DECANS <draminda@gmail.com>
 * @category for Audit the data read write operations  
 */

@Entity(name="itemTypes")
@Table(name="itemTypes")
public class ItemTypes extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="itemtypesValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@Column(nullable=false,unique = true)
	private String TypeName;
	@Column(columnDefinition="Integer default '1'")
	private Integer AccsessLevel;
	
	/**
	 * @return the iD
	 */

	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the typeName
	 */
	@Column(nullable = false) 
	public String getTypeName() {
		return TypeName;
	}
	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	/**
	 * @return the accsessLevel
	 */
	public int getAccsessLevel() {
		return AccsessLevel;
	}
	/**
	 * @param accsessLevel the accsessLevel to set
	 */
	public void setAccsessLevel(int accsessLevel) {
		AccsessLevel = accsessLevel;
	}
}
