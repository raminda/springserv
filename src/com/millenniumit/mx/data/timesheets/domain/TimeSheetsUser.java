package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * This class represents a user in the timesheets system.
 * @author Vimukthi
 *
 */
@Entity(name = "TimeSheetsUser")
@Table(name = "timesheets_users")
public class TimeSheetsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PortalUser user;
	
	@Column(name = "active")
	private int active;
	
	@Column(name = "receive_reminders")
	private int receiveReminders;

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
}
