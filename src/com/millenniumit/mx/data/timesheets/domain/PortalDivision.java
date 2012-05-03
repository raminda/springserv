/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import javax.persistence.*;

/**
 * This class represents a division from previous Portal.
 * Each of these divisions are matched(by title) to a single division in Mx.
 * @author Vimukthi
 *
 */
@Entity(name = "PortalDivision")
@Table(name = "divisions")
public class PortalDivision {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
