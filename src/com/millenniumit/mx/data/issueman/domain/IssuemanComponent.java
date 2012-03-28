/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "IssuemanComponent")
@Table(name = "components")
public class IssuemanComponent extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    private Long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private IssuemanProject project;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
}
