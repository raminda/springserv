/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * 
 * @author kalpag
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

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private IssuemanProject project;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "component_id")
	private IssuemanComponent component;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "reporter_id")
	private IssuemanUser reporter;

	@Column(name = "description")
	private String description;

	@Column(name = "reported_date")
	private Timestamp reportedDate;

	@OneToMany(targetEntity = IssuemanTicketLink.class)
	@JoinColumn(name = "destination_ticket_id")
	private Collection<IssuemanTicketLink> ticketLinks;

	@OneToMany(targetEntity = IssuemanStatusFieldHistory.class)
	@JoinColumn(name = "ticket_id")	
	private Collection<IssuemanStatusFieldHistory> statusHistoy;

	@OneToOne(targetEntity = IssuemanStatusFieldCurrent.class, mappedBy="ticket", fetch=FetchType.EAGER)
	private IssuemanStatusFieldCurrent currentStatus;
//
//	@OneToOne(targetEntity = IssuemanTypeFieldCurrent.class, mappedBy = "ticket", fetch=FetchType.LAZY)
//	private IssuemanTypeFieldCurrent currentType;
//
//	@OneToOne(targetEntity = IssuemanPriorityFieldCurrent.class, mappedBy = "ticket", fetch=FetchType.LAZY)
//	private IssuemanPriorityFieldCurrent currentPriority;

	

//	/**
//	 * @return the statusHistoy
//	 */
//	public Collection<IssuemanStatusFieldHistory> getStatusHistoy() {
//		return statusHistoy;
//	}
//
//	/**
//	 * @param statusHistoy the statusHistoy to set
//	 */
//	public void setStatusHistoy(Collection<IssuemanStatusFieldHistory> statusHistoy) {
//		this.statusHistoy = statusHistoy;
//	}
	
//	/**
//	 * @return the currentPriority
//	 */
//	public IssuemanPriorityFieldCurrent getCurrentPriority() {
//		return currentPriority;
//	}
//
//	/**
//	 * @param currentPriority
//	 *            the currentPriority to set
//	 */
//	public void setCurrentPriority(IssuemanPriorityFieldCurrent currentPriority) {
//		this.currentPriority = currentPriority;
//	}
//
//	/**
//	 * @return the currentType
//	 */
//	public IssuemanTypeFieldCurrent getCurrentType() {
//		return currentType;
//	}
//
//	/**
//	 * @param currentType
//	 *            the currentType to set
//	 */
//	public void setCurrentType(IssuemanTypeFieldCurrent currentType) {
//		this.currentType = currentType;
//	}
//
//	/**
//	 * @return the currentStatus
//	 */
//	public IssuemanStatusFieldCurrent getCurrentStatus() {
//		return currentStatus;
//	}
//
//	/**
//	 * @param currentStatus
//	 *            the currentStatus to set
//	 */
//	public void setCurrentStatus(IssuemanStatusFieldCurrent currentStatus) {
//		this.currentStatus = currentStatus;
//	}

//	/**
//	 * @return the ticketLinks
//	 */
//	public Collection<IssuemanTicketLink> getTicketLinks() {
//		return ticketLinks;
//	}
//
//	/**
//	 * @param ticketLinks
//	 *            the ticketLinks to set
//	 */
//	public void setTicketLinks(Collection<IssuemanTicketLink> ticketLinks) {
//		this.ticketLinks = ticketLinks;
//	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
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
	 * @param nativeId
	 *            the nativeId to set
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
	 * @param key
	 *            the key to set
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
	 * @param title
	 *            the title to set
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
	 * @param description
	 *            the description to set
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
	 * @param reportedDate
	 *            the reportedDate to set
	 */
	public void setReportedDate(Timestamp reportedDate) {
		this.reportedDate = reportedDate;
	}

//	/**
//	 * @return the component
//	 */
//	public IssuemanComponent getComponent() {
//		return component;
//	}
//
//	/**
//	 * @param component
//	 *            the component to set
//	 */
//	public void setComponent(IssuemanComponent component) {
//		this.component = component;
//	}

	/**
	 * @return the reporter
	 */
	public IssuemanUser getReporter() {
		return reporter;
	}

	/**
	 * @param reporter
	 *            the reporter to set
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
	 * @param projectId
	 *            the projectId to set
	 */
	public void setProject(IssuemanProject project) {
		this.project = project;
	}
}
