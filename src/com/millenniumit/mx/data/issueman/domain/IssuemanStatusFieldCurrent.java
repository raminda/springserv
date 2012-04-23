/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.*;

/**
 * @author Kalpag
 *
 */
@Entity(name="IssuemanStatusFieldCurrent")
@DiscriminatorValue("status")
public class IssuemanStatusFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "value_id")
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
