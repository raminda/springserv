package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Where;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanProjectLevelActivity")
@Where(clause = "state='COMPLETED'")
@Table(name = "relman_project_level_activities")
public class RelmanProjectLevelActivity extends AuditFields implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "activity_id")
	private String activityId;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "duration_str")
	private String durationStr;
	
	@Column(name = "action")
	private String action;
	
	@Column(name = "sub_action")
	private String subAction;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "machine_ip")
	private String machineIp;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private RelmanProject project;

	@Column(name = "item_type")
	private String itemType;
	
	@Column(name = "item_id")
	private String itemId;
	
	@Column(name = "additional_fields")
	private String additionalFields;
	
	@Column(name = "note")
	private String note;
	
	/**
	 * 
	 */
	public RelmanProjectLevelActivity() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the activityId
	 */
	public String getActivityId() {
		return activityId;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @return the durationStr
	 */
	public String getDurationStr() {
		return durationStr;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @return the subAction
	 */
	public String getSubAction() {
		return subAction;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @return the machineIp
	 */
	public String getMachineIp() {
		return machineIp;
	}

	/**
	 * @return the project
	 */
	public RelmanProject getProject() {
		return project;
	}

	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}

	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}

	/**
	 * @return the additionalFields
	 */
	public String getAdditionalFields() {
		return additionalFields;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
}
