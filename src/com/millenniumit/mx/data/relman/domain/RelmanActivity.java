package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
//import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Where;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "RelmanActivity")
@Where(clause = "state='COMPLETED'")
@Table(name = "relman_activities")
public class RelmanActivity extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "activity_id")
	private String activityId;

	@Column(name = "state")
	private String state;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "duration")
	private int duration;

	@Column(name = "duration_str")
	private String durationStr;

	@Column(name = "action")
	private String action;

	@Column(name = "sub_action")
	private String subAction;

	// @ManyToOne
	// @JoinColumn(name="user_id")
	// private RelmanUser user;

	@Column(name = "machine_ip")
	private String machineIp;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private RelmanProject project;

	@ManyToOne
	@JoinColumn(name = "release_id")
	private RelmanRelease release;

	@Column(name = "item_type")
	private String itemType;

	@Column(name = "item_id")
	private String itemId;

	@Column(name = "additional_fields")
	private String additionalFields;

	@Column(name = "note")
	private String note;

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
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
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

	// /**
	// * @return the userId
	// */
	// public RelmanUser getUser() {
	// return user;
	// }
	//
	// /**
	// * @param userId the userId to set
	// */
	// public void setUser(RelmanUser user) {
	// this.user = user;
	// }

	/**
	 * @return the machineIp
	 */
	public String getMachineIp() {
		return machineIp;
	}

	/**
	 * @return the projectId
	 */
	public RelmanProject getProject() {
		return project;
	}

	/**
	 * @return the releaseId
	 */
	public RelmanRelease getRelease() {
		return release;
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

	/*
	 * {"id":1,"activityId":"mtech_1_20101021154136.983_16801","state":"COMPLETED",
	 * "startDate":"2010-10-21 15:41:36.0","endDate":"2010-10-21 15:52:09.0","duration":633,
	 * "durationStr":"10 M, 33 S","action":"Create","subAction":"Release [From Base]",
	 * "machineIp":"172.25.70.172","project":"mtech_1","release":"mtech_1:1.18.3.1",
	 * "itemType":"RELEASE","itemId":"mtech_1:1.18.3.1","additionalFields":"","note":"",
	 * "modifiedDate":"Jan 25, 2011 3:01:19 PM"}
	 * */
	
	public String toJSON(){
	
		String jsonstring  = "{ \"id\":\"" + this.id +"\",\"activityId\":\""+this.activityId+"\",\"state\":\""
				+this.state +"\",\"startDate\":\""+this.startDate +"\", \"endDate\":\""+this.endDate +"\",\"duration\":\""
				+this.duration+"\",\"durationStr\":\""+this.durationStr+"\",\"action\":\""
				+this.action+"\",\"subAction\":\""+this.subAction+"\",\"machineIp\":\""
				+this.machineIp+"\",\"project\":\""+this.project.getRelmanId()+"\",\"release\":\""+this.release.getRelmanId()
				+"\",\"itemType\":\""+this.itemType+"\",\"itemId\":\""+this.itemId+"\",\"note\":\""+this.note+"\",\"modifiedDate\":\""+super.getModifiedDate()+"\"}";
		
	return jsonstring;

	}

	/**
	 * 
	 */
	public RelmanActivity() {
		super();
	}
}
