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
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("priority")
public class IssuemanPriorityFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "value_id" ,insertable = false, updatable = false)
	private IssuemanPriority priority;

	/**
	 * @return the priority
	 */
	public IssuemanPriority getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(IssuemanPriority priority) {
		this.priority = priority;
	}

}
