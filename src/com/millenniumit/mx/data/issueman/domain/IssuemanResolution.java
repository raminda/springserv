/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Vimukthi
 *
 */
@Entity(name = "IssuemanResolution")
@Table(name = "resolutions")
public class IssuemanResolution extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
