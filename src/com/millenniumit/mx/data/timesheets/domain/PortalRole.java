/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import javax.persistence.*;

/**
 * This class represents a role from previous Portal.
 * Each of these roles are matched(by title and division) to a single 
 * role in Mx.
 * @author Vimukthi
 *
 */
@Entity(name = "PortalRole")
@Table(name = "roles")
public class PortalRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "division_id")
	private PortalDivision division;

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

	/**
	 * @return the division
	 */
	public PortalDivision getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(PortalDivision division) {
		this.division = division;
	}

}
