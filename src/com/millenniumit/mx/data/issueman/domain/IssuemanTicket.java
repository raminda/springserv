/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Vimukthi
 *
 */
@Entity(name = "IssuemanTicket")
@Table(name = "tickets")
public class IssuemanTicket extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    private Long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@Column(name = "ikey")
	private String key;
	
	@Column(name = "title")
	private String title;
		
	@ManyToOne
	@JoinColumn(name = "project_id")
	private IssuemanProject project;
	
	@ManyToOne
	@NotFound( action = NotFoundAction.IGNORE )
	@JoinColumn(name = "component_id")
	private IssuemanComponent component;
	
	@ManyToOne
	@JoinColumn(name = "reporter_id")
	private IssuemanUser reporter;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "reported_date")
	private Timestamp reportedDate;

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
	 * @return the nativeId
	 */
	public Long getNativeId() {
		return nativeId;
	}

	/**
	 * @param nativeId the nativeId to set
	 */
	public void setNativeId(Long nativeId) {
		this.nativeId = nativeId;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
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
	 * @return the reportedDate
	 */
	public Timestamp getReportedDate() {
		return reportedDate;
	}

	/**
	 * @param reportedDate the reportedDate to set
	 */
	public void setReportedDate(Timestamp reportedDate) {
		this.reportedDate = reportedDate;
	}

	/**
	 * @return the component
	 */
	public IssuemanComponent getComponent() {
		return component;
	}

	/**
	 * @param component the component to set
	 */
	public void setComponent(IssuemanComponent component) {
		this.component = component;
	}

	/**
	 * @return the reporter
	 */
	public IssuemanUser getReporter() {
		return reporter;
	}

	/**
	 * @param reporter the reporter to set
	 */
	public void setReporter(IssuemanUser reporter) {
		this.reporter = reporter;
	}

	/**
	 * @return the projectId
	 */
	public IssuemanProject getProject() {
		return project;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProject(IssuemanProject projectId) {
		this.project = project;
	}
}
