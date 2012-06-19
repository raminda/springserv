package com.millenniumit.mx.data.issueman.domain;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@MappedSuperclass
public class AuditFields2 {
	
	@Column(name="date_created")
	private Timestamp dateCreated;
	
	@Column(name="date_modified")
	private Timestamp dateModified;

	/**
	 * @return the dateCreated
	 */
	public Timestamp getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateModified
	 */
	public Timestamp getDateModified() {
		return dateModified;
	}

	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}	
}