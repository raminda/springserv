/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * @author Kalpag
 *
 */


@Entity(name="IssuemanStatusFieldCurrent")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("status")
@Where(clause="ticket_id <> 0")
public class IssuemanStatusFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;
	
	@NotFound(action=NotFoundAction.IGNORE)
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
