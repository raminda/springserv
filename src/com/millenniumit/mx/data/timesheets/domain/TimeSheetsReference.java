/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kalpag
 *
 */

@Entity(name = "TimeSheetsReference")
@Table(name = "timesheets_reference")
public class TimeSheetsReference implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "division_id")
	private long divisionId;
	
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "description")
	private String description;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the divisionId
	 */
	public long getDivisionId() {
		return divisionId;
	}

	/**
	 * @param divisionId the divisionId to set
	 */
	public void setDivisionId(long divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
