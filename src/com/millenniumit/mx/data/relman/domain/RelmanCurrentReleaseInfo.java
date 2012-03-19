package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "RelmanCurrentReleaseInfo")
@Table(name = "relman_current_releaseinfo")
public class RelmanCurrentReleaseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "relman_project_id")
	private RelmanProject project;

	@ManyToOne
	@JoinColumn(name = "live")
	private RelmanRelease live;

	@ManyToOne
	@JoinColumn(name = "last_sent")
	private RelmanRelease lastSent;

	@ManyToOne
	@JoinColumn(name = "current_active_release")
	private RelmanRelease currentActiveRelease;

	@ManyToMany(targetEntity = RelmanRelease.class, cascade = {
			CascadeType.PERSIST},fetch=FetchType.EAGER)
	@JoinTable(name = "relman_additional_active_releases", 
	joinColumns = @JoinColumn(name = "relase_info_id"), 
	inverseJoinColumns = @JoinColumn(name = "additional_active_release_id"))
	private Collection<RelmanRelease> additionalActiveReleases;

	@Column(name = "last_sent_date")
	private Date lastSentDate;

	@Column(name = "date_created")
	private Date dateCreated;

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
	 * @return the project
	 */
	public RelmanProject getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(RelmanProject project) {
		this.project = project;
	}

	/**
	 * @return the live
	 */
	public RelmanRelease getLive() {
		return live;
	}

	/**
	 * @param live
	 *            the live to set
	 */
	public void setLive(RelmanRelease live) {
		this.live = live;
	}

	/**
	 * @return the lastSent
	 */
	public RelmanRelease getLastSent() {
		return lastSent;
	}

	/**
	 * @param lastSent
	 *            the lastSent to set
	 */
	public void setLastSent(RelmanRelease lastSent) {
		this.lastSent = lastSent;
	}

	/**
	 * @return the currentActiveRelease
	 */
	public RelmanRelease getCurrentActiveRelease() {
		return currentActiveRelease;
	}

	/**
	 * @param currentActiveRelease
	 *            the currentActiveRelease to set
	 */
	public void setCurrentActiveRelease(RelmanRelease currentActiveRelease) {
		this.currentActiveRelease = currentActiveRelease;
	}

	/**
	 * @return the lastSentDate
	 */
	public Date getLastSentDate() {
		return lastSentDate;
	}

	/**
	 * @param lastSentDate
	 *            the lastSentDate to set
	 */
	public void setLastSentDate(Date lastSentDate) {
		this.lastSentDate = lastSentDate;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the additionalActiveReleases
	 */
	public Collection<RelmanRelease> getAdditionalActiveReleases() {
		return additionalActiveReleases;
	}

	/**
	 * @param additionalActiveReleases the additionalActiveReleases to set
	 */
	public void setAdditionalActiveReleases(Collection<RelmanRelease> additionalActiveReleases) {
		this.additionalActiveReleases = additionalActiveReleases;
	}
}
