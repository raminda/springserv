/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * This class represents a timesheets entry.
 * @author Vimukthi
 *
 */
@MappedSuperclass
public class Work {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PortalUser user;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private PortalProject project;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private PortalRole role;
	
	@Column(name = "work_date")
	private Date workDate;
		
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "hours_planned")
	private float hoursPlanned;
	
	@Column(name = "hours_unplanned")
	private float hoursUnplanned;
		
	@Column(name = "note")
	private String note;
	
	@Column(name = "date_created")
	private Timestamp dateCreated;

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
	 * @return the user
	 */
	public PortalUser getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(PortalUser user) {
		this.user = user;
	}

	/**
	 * @return the project
	 */
	public PortalProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(PortalProject project) {
		this.project = project;
	}

	/**
	 * @return the role
	 */
	public PortalRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(PortalRole role) {
		this.role = role;
	}

	/**
	 * @return the workDate
	 */
	public Date getWorkDate() {
		return workDate;
	}

	/**
	 * @param workDate the workDate to set
	 */
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
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
	 * @return the hoursPlanned
	 */
	public float getHoursPlanned() {
		return hoursPlanned;
	}

	/**
	 * @param hoursPlanned the hoursPlanned to set
	 */
	public void setHoursPlanned(float hoursPlanned) {
		this.hoursPlanned = hoursPlanned;
	}

	/**
	 * @return the hoursUnplanned
	 */
	public float getHoursUnplanned() {
		return hoursUnplanned;
	}

	/**
	 * @param hoursUnplanned the hoursUnplanned to set
	 */
	public void setHoursUnplanned(float hoursUnplanned) {
		this.hoursUnplanned = hoursUnplanned;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

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
}
