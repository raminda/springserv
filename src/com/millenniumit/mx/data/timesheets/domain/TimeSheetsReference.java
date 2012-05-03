/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * This class represents a reference used in a timesheets entry.
 * @author Kalpag
 *
 */

@Entity(name = "TimeSheetsReference")
@Table(name = "timesheets_reference")
public class TimeSheetsReference implements Serializable {
	
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@ManyToOne
	@JoinColumn(name = "division_id")
	private PortalDivision division;
	
	@Column(name = "name")
	private String name;
	
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

}
