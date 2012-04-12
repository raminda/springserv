/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * @author Kalpag
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("release")
public class IssuemanReleaseFieldCurrent extends IssuemanTicketFieldCurrent {

	private static final long serialVersionUID = 1L;

	@ManyToOne
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
