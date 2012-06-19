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

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Where;

/**
 * @author kalpag
 *
 */
@Entity(name = "IssuemanResolutionFieldHistory")
//@Cacheable
//@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("resolution")
@Where(clause="field_id != 0")
public class IssuemanResolutionFieldHistory extends IssuemanTicketFieldHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "new_id" ,insertable = false, updatable = false)
	private IssuemanResolution newResolution;
	
	@ManyToOne
	@JoinColumn(name = "old_id" ,insertable = false, updatable = false)
	private IssuemanResolution oldResolution;

	/**
	 * @return the newResolution
	 */
	public IssuemanResolution getNewResolution() {
		return newResolution;
	}

	/**
	 * @param newResolution the newResolution to set
	 */
	public void setNewResolution(IssuemanResolution newResolution) {
		this.newResolution = newResolution;
	}

	/**
	 * @return the oldResolution
	 */
	public IssuemanResolution getOldResolution() {
		return oldResolution;
	}

	/**
	 * @param oldResolution the oldResolution to set
	 */
	public void setOldResolution(IssuemanResolution oldResolution) {
		this.oldResolution = oldResolution;
	}
}
