/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Kalpag
 *
 */
@Entity(name="IssuemanStatusFieldCurrent")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("status")
public class IssuemanStatusFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "value_id" ,insertable = false, updatable = false)
	private IssuemanTicketStatus status;

	/**
	 * @return the status
	 */
	public IssuemanTicketStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(IssuemanTicketStatus status) {
		this.status = status;
	}

	
}
