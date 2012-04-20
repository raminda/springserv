/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.Where;


/**
 * @author kalpag
 *
 */
@Entity(name = "IssuemanStringFieldHistory")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("string")
@Where(clause="field_id != 0")
public class IssuemanStringFieldHistory extends IssuemanTicketFieldHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "old_string_val" ,insertable = false, updatable = false)
	private String oldString;
	
	@Column(name = "string_val" ,insertable = false, updatable = false)
	private IssuemanTicketStatus newString;

	/**
	 * @return the oldString
	 */
	public String getOldString() {
		return oldString;
	}

	/**
	 * @param oldString the oldString to set
	 */
	public void setOldString(String oldString) {
		this.oldString = oldString;
	}

	/**
	 * @return the newString
	 */
	public IssuemanTicketStatus getNewString() {
		return newString;
	}

	/**
	 * @param newString the newString to set
	 */
	public void setNewString(IssuemanTicketStatus newString) {
		this.newString = newString;
	}
}
