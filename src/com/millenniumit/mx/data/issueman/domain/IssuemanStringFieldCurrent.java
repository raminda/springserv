/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Kalpag
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("string")
public class IssuemanStringFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "value_string" ,insertable = false, updatable = false)
	private String valueString;

	/**
	 * @return the valueString
	 */
	public String getValueString() {
		return valueString;
	}

	/**
	 * @param valueString the valueString to set
	 */
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
}
