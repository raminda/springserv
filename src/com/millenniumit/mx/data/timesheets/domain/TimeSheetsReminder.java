/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * This class represents a email timesheets reminder and a 
 * reply by a user.
 * @author Vimukthi
 *
 */
@Entity(name = "TimeSheetsReminder")
@Table(name = "timesheets_reminders")
public class TimeSheetsReminder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PortalUser user;
	
	@Column(name = "work_date")
	private Date workDate;
	
	@Column(name = "mail_id")
	private String mailId;
	
	@Column(name = "reply_mail_id")
	private String replyMailId;
	
	@Column(name = "update_count")
	private int updateCount;
	
	@Column(name = "date_sent")
	private Timestamp dateSent;
	
	@Column(name = "date_received")
	private Timestamp dateReceived;

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
	 * @return the mailId
	 */
	public String getMailId() {
		return mailId;
	}

	/**
	 * @param mailId the mailId to set
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	/**
	 * @return the replyMailId
	 */
	public String getReplyMailId() {
		return replyMailId;
	}

	/**
	 * @param replyMailId the replyMailId to set
	 */
	public void setReplyMailId(String replyMailId) {
		this.replyMailId = replyMailId;
	}

	/**
	 * @return the updateCount
	 */
	public int getUpdateCount() {
		return updateCount;
	}

	/**
	 * @param updateCount the updateCount to set
	 */
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * @return the dateSent
	 */
	public Timestamp getDateSent() {
		return dateSent;
	}

	/**
	 * @param dateSent the dateSent to set
	 */
	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	/**
	 * @return the dateReceived
	 */
	public Timestamp getDateReceived() {
		return dateReceived;
	}

	/**
	 * @param dateReceived the dateReceived to set
	 */
	public void setDateReceived(Timestamp dateReceived) {
		this.dateReceived = dateReceived;
	}
}
