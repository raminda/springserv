/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.*;
import javax.persistence.Entity;


/**
 * @author Kalpag
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("release")
public class IssuemanReleaseFieldCurrent extends IssuemanTicketFieldCurrent {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "value_string", insertable = false, updatable = false)
	private IssuemanRelease release;

	/**
	 * @return the release
	 */
	public IssuemanRelease getRelease() {
		return release;
	}

	/**
	 * @param release
	 *            the release to set
	 */
	public void setRelease(IssuemanRelease release) {
		this.release = release;
	}
}
