package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 *
 */
@Entity(name = "TimeSheetsWork")
@Table(name = "timesheets_work")
public class TimeSheetsWork implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "project_id")
	private long projectId;

	@Column(name = "role_id")
	private long roleId;
	
	@Column(name = "work_date")
	private Date workDate;
		
	@Column(name = "reference")
	private String reference;
	
	@Column(name = "hours_planned")
	private long hoursPlanned;
	
	@Column(name = "hours_unplanned")
	private long hoursUnplanned;
		
	@Column(name = "note")
	private String note;
	
	@Column(name = "update_count")
	private long updateCount;
	
	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "date_modified")
	private Date dateModified;
	
	public TimeSheetsWork(){
		
	}

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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the projectId
	 */
	public long getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the roleId
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
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
	public long getHoursPlanned() {
		return hoursPlanned;
	}

	/**
	 * @param hoursPlanned the hoursPlanned to set
	 */
	public void setHoursPlanned(long hoursPlanned) {
		this.hoursPlanned = hoursPlanned;
	}

	/**
	 * @return the hoursUnplanned
	 */
	public long getHoursUnplanned() {
		return hoursUnplanned;
	}

	/**
	 * @param hoursUnplanned the hoursUnplanned to set
	 */
	public void setHoursUnplanned(long hoursUnplanned) {
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
	 * @return the updateCount
	 */
	public long getUpdateCount() {
		return updateCount;
	}

	/**
	 * @param updateCount the updateCount to set
	 */
	public void setUpdateCount(long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the dateModified
	 */
	public Date getDateModified() {
		return dateModified;
	}

	/**
	 * @param dateModified the dateModified to set
	 */
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
		
}
