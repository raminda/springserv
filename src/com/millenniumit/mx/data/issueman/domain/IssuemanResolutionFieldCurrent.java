/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import javax.persistence.*;

/**
 * @author Kalpag
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("resolution")
public class IssuemanResolutionFieldCurrent extends IssuemanTicketFieldCurrent {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "value_id" ,insertable = false, updatable = false)
	private IssuemanResolution resolution;

	/**
	 * @return the resolution
	 */
	public IssuemanResolution getResolution() {
		return resolution;
	}

	/**
	 * @param resolution the resolution to set
	 */
	public void setResolution(IssuemanResolution resolution) {
		this.resolution = resolution;
	}

	
}
