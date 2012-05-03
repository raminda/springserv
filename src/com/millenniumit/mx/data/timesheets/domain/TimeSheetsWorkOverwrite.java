/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * This class represents a an overwrite record for a given
 * timesheets entry.
 * @author Vimukthi
 *
 */
@Entity(name = "TimeSheetsWorkOverwrite")
@Table(name = "timesheets_work_overwrites")
public class TimeSheetsWorkOverwrite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PortalUser user;
	
	@Column(name = "work_date")
	private Date workDate;
	
	@Column(name = "overwrites")
	private int overwrites;
	
	@Column(name = "date_overwritten")
	private Timestamp dateOverwritten;

	/**
	 * @param user
	 * @param workDate
	 * @param overwrites
	 */
	public TimeSheetsWorkOverwrite(PortalUser user, Date workDate,
			int overwrites) {
		super();
		this.user = user;
		this.workDate = workDate;
		this.overwrites = overwrites;
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
	 * @return the overwrites
	 */
	public int getOverwrites() {
		return overwrites;
	}

	/**
	 * @param overwrites the overwrites to set
	 */
	public void setOverwrites(int overwrites) {
		this.overwrites = overwrites;
	}

	/**
	 * @return the dateOverwritten
	 */
	public Timestamp getDateOverwritten() {
		return dateOverwritten;
	}

	/**
	 * @param dateOverwritten the dateOverwritten to set
	 */
	public void setDateOverwritten(Timestamp dateOverwritten) {
		this.dateOverwritten = dateOverwritten;
	}
}
