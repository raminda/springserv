/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;

import org.apache.commons.collections.functors.FalsePredicate;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

/**
 * 
// * @author kalpag
 * 
 */
@Entity(name = "IssuemanTicket")
//@Immutable
@Cacheable
@org.hibernate.annotations.Cache(usage=CacheConcurrencyStrategy.READ_ONLY,region = "Ticket")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name = "tickets")
//@Where(clause= "id <> 128488")
public class IssuemanTicket extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY,generator="")
	private Long id;

	@Column(name = "native_id")
	private Long nativeId;

	@Column(name = "ikey")
	private String key;

	@Column(name = "title")
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private IssuemanProject project;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "component_id")
	private IssuemanComponent component;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reporter_id")
	private IssuemanUser reporter;

	@Column(name = "description")
	private String description;

	@Column(name = "reported_date")
	private Timestamp reportedDate;

	@OneToMany(targetEntity = IssuemanTicketLink.class)
	@JoinColumn(name = "destination_ticket_id")
	private List<IssuemanTicketLink> ticketLinks;

	@OneToMany(targetEntity = IssuemanStatusFieldHistory.class)
	@JoinColumn(name = "ticket_id")
	@Where(clause = "field_type ='status'")
	private List<IssuemanStatusFieldHistory> statusHistory;

	@OneToMany(targetEntity = IssuemanStatusFieldCurrent.class)
	@JoinColumn(name = "ticket_id")
	@Where(clause = "field_type ='status'")
	private List<IssuemanStatusFieldCurrent> currentStatus;

	@OneToMany(targetEntity = IssuemanTypeFieldCurrent.class)
	@JoinColumn(name = "ticket_id")
	//@Where(clause = "field_type ='type'")
	private List<IssuemanTypeFieldCurrent> currentType;

	@OneToMany(targetEntity = IssuemanPriorityFieldCurrent.class)
	@JoinColumn(name = "ticket_id")
	private List<IssuemanPriorityFieldCurrent> currentPriority;
	
	
	@OneToMany(targetEntity = IssuemanSeverityFieldCurrent.class)
	@JoinColumn(name = "ticket_id")
	@Where(clause = "field_type ='severity'")
	private List<IssuemanSeverityFieldCurrent> currentSeverity;

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

	/**
	 * @return the component
	 */
	public IssuemanComponent getComponent() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	public void setComponent(IssuemanComponent component) {
		this.component = component;
	}

	/**
	 * @return the ticketLinks
	 */
	public List<IssuemanTicketLink> getTicketLinks() {
		return ticketLinks;
	}

	/**
	 * @param ticketLinks
	 *            the ticketLinks to set
	 */
	public void setTicketLinks(List<IssuemanTicketLink> ticketLinks) {
		this.ticketLinks = ticketLinks;
	}

	/**
	 * @return the currentType
	 */
	public List<IssuemanTypeFieldCurrent> getCurrentType() {
		return currentType;
	}

	/**
	 * @param currentType
	 *            the currentType to set
	 */
	public void setCurrentType(List<IssuemanTypeFieldCurrent> currentType) {
		this.currentType = currentType;
	}

	/**
	 * @return the currentPriority
	 */
	public List<IssuemanPriorityFieldCurrent> getCurrentPriority() {
		return currentPriority;
	}

	/**
	 * @param currentPriority
	 *            the currentPriority to set
	 */
	public void setCurrentPriority(
			List<IssuemanPriorityFieldCurrent> currentPriority) {
		this.currentPriority = currentPriority;
	}

	/**
	 * @return the currentStatus
	 */
	public List<IssuemanStatusFieldCurrent> getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * @param currentStatus
	 *            the currentStatus to set
	 */
	public void setCurrentStatus(List<IssuemanStatusFieldCurrent> currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * @return the currentSeverity
	 */
	public List<IssuemanSeverityFieldCurrent> getCurrentSeverity() {
		return currentSeverity;
	}

	/**
	 * @param currentSeverity the currentSeverity to set
	 */
	public void setCurrentSeverity(
			List<IssuemanSeverityFieldCurrent> currentSeverity) {
		this.currentSeverity = currentSeverity;
	}

	/**
	 * @return the statusHistory
	 */
	public List<IssuemanStatusFieldHistory> getStatusHistory() {
		return statusHistory;
	}

	/**
	 * @param statusHistory the statusHistory to set
	 */
	public void setStatusHistory(List<IssuemanStatusFieldHistory> statusHistory) {
		this.statusHistory = statusHistory;
	}
}
