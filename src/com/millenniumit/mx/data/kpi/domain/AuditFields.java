package com.millenniumit.mx.data.kpi.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@MappedSuperclass
public class AuditFields {
	
	@Column(name="date_logged")
	private Date dateLogged;

	/**
	 * @return the dateLogged
	 */
	public Date getDateLogged() {
		return dateLogged;
	}

	/**
	 * @param dateLogged the dateLogged to set
	 */
	public void setDateLogged(Date dateLogged) {
		this.dateLogged = dateLogged;
	}
}