package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.millenniumit.mx.data.kpi.domain.IssuemanProject;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "KpiWatchedRelease")
@Table(name = "kpi_watched_releases")
public class KpiWatchedRelease extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private IssuemanProject project;
	
	@Column(name = "release_name_prefix")
	private String prefix;
	
	@Column(name = "status")
	private String status;

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
	 * @return the project
	 */
	public IssuemanProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(IssuemanProject project) {
		this.project = project;
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
