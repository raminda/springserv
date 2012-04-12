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

/**
 * @author Kalpag
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("user")
public class IssuemanUserFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "value_id" ,insertable = false, updatable = false)
	private IssuemanUser user;

	/**
	 * @return the user
	 */
	public IssuemanUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(IssuemanUser user) {
		this.user = user;
	}

}
