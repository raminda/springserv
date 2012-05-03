/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Where;

/**
 * @author kalpag
 *
 */
@Entity(name = "IssuemanUserProjectRole")
@Table(name = "user_project_roles")
@Where(clause="user_id <> 0")
public class IssuemanUserProjectRole extends AuditFields implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private IssuemanProject project;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private IssuemanRole role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private IssuemanUser user;


	/**
	 * @return the user
	 */
	public IssuemanUser getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(IssuemanUser user) {
		this.user = user;
	}


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
	 * @return the role
	 */
	public IssuemanRole getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(IssuemanRole role) {
		this.role = role;
	}
}
