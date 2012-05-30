/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import javax.persistence.*;

/**
 * This class represents a user-project-role relationship
 * from previous Portal.
 * Each of these relationships are matched to a single 
 * relationship in Mx.
 * @author Vimukthi
 *
 */
@Entity(name = "PortalUsersProject")
@Table(name = "user_projects")
public class PortalUsersProject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PortalUser user;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private PortalProject project;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private PortalRole role;

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
	 * @return the project
	 */
	public PortalProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(PortalProject project) {
		this.project = project;
	}

	/**
	 * @return the role
	 */
	public PortalRole getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(PortalRole role) {
		this.role = role;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {		
		PortalUsersProject up = (PortalUsersProject)obj;
		return up.getUser().getId().equals(this.getUser().getId()) && 
				up.getProject().getId().equals(this.getProject().getId()) && 
				up.getRole().getId().equals(this.getRole().getId());
	}

}
