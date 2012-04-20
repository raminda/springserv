/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * @author kalpag
 * 
 */

@Entity(name = "IssuemanStatusFieldHistory")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("status")
@Where(clause="field_id != 0")
public class IssuemanStatusFieldHistory extends IssuemanTicketFieldHistory {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "old_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private IssuemanTicketStatus oldStatus;

	@ManyToOne
	@JoinColumn(name = "new_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private IssuemanTicketStatus newStatus;

	/**
	 * @return the oldStatus
	 */
	public IssuemanTicketStatus getOldStatus() {
		return oldStatus;
	}

	/**
	 * @param oldStatus
	 *            the oldStatus to set
	 */
	public void setOldStatus(IssuemanTicketStatus oldStatus) {
		this.oldStatus = oldStatus;
	}

	/**
	 * @return the newStatus
	 */
	public IssuemanTicketStatus getNewStatus() {
		return newStatus;
	}

	/**
	 * @param newStatus
	 *            the newStatus to set
	 */
	public void setNewStatus(IssuemanTicketStatus newStatus) {
		this.newStatus = newStatus;
	}

}
