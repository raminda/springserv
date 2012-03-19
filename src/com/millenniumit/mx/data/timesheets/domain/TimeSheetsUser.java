package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
//import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 *
 */
@Entity(name = "TimeSheetsUser")
@Table(name = "timesheets_users")
public class TimeSheetsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private long id;
	
	@Column(name = "user_id")
	private long userId;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "receive_reminders")
	private int receiveReminders;
	
	@Column(name = "can_view_reports")
	private int canViewReports;
	
	@Column(name = "can_administer")
	private int canAdminister;
	
	@Column(name = "date_created")
	private Date dateCreated;

	@Column(name = "date_modified")
	private Date dateModified;
	
	
	public TimeSheetsUser()	{
		
	}
	
	/**
	 * @param id
	 * @param user
	 * @param userId
	 * @param active
	 * @param receiveReminders
	 * @param canViewReports
	 * @param canAdminister
	 * @param dateCreated
	 */
	public TimeSheetsUser(long id, long userId, int active,
			int receiveReminders, int canViewReports, int canAdminister, Date dateCreated) {
		
		this.id = id;
		this.userId = userId;
		this.active = active;
		this.receiveReminders = receiveReminders;
		this.canViewReports = canViewReports;
		this.canAdminister = canAdminister;
		this.dateCreated = dateCreated;
	}


	/**
	 * @param id
	 * @param user
	 * @param userId
	 * @param active
	 * @param receiveReminders
	 * @param canViewReports
	 * @param canAdminister
	 * @param dateCreated
	 */
	public TimeSheetsUser(long id, long userId, Boolean active,
			Boolean receiveReminders, Boolean canViewReports, Boolean canAdminister, Date dateCreated) {
		
		this.id = id;
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.active = (active == true) ? 1 : 0;
		this.receiveReminders = (receiveReminders == true) ? 1 : 0;
		this.canViewReports = (canViewReports == true) ? 1 : 0;
		this.canAdminister = (canAdminister == true) ? 1 : 0;
		
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
	 * @return the active
	 */
	public int getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}

	/**
	 * @return the receiveReminders
	 */
	public int getReceiveReminders() {
		return receiveReminders;
	}

	/**
	 * @param receiveReminders the receiveReminders to set
	 */
	public void setReceiveReminders(int receiveReminders) {
		this.receiveReminders = receiveReminders;
	}

	/**
	 * @return the canViewReports
	 */
	public int getCanViewReports() {
		return canViewReports;
	}

	/**
	 * @param canViewReports the canViewReports to set
	 */
	public void setCanViewReports(int canViewReports) {
		this.canViewReports = canViewReports;
	}

	/**
	 * @return the canAdminister
	 */
	public int getCanAdminister() {
		return canAdminister;
	}

	/**
	 * @param canAdminister the canAdminister to set
	 */
	public void setCanAdminister(int canAdminister) {
		this.canAdminister = canAdminister;
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
