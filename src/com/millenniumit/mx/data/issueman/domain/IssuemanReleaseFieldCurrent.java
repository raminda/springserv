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

/**
 * @author Kalpag
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("release")
public class IssuemanReleaseFieldCurrent extends IssuemanTicketFieldCurrent {


	private static final long serialVersionUID = 1L;
	
	@Column(name = "value_id" ,insertable = false, updatable = false)
	private Long valueId;

	/**
	 * @return the valueId
	 */
	public Long getValueId() {
		return valueId;
	}

	/**
	 * @param valueId the valueId to set
	 */
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	
}
