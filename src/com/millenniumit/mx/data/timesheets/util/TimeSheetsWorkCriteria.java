package com.millenniumit.mx.data.timesheets.util;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.*;

/**
 * 
 * @author Vimukthi
 * 
 */
public class TimeSheetsWorkCriteria {

	private List<PortalProject> projects = null;
	private List<PortalRole> roles = null;
	private List<PortalUser> users = null;
	private Date startDate = null;
	private Date endDate = null;

	/**
	 * @return the projects
	 */
	public List<PortalProject> getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(List<PortalProject> projects) {
		this.projects = projects;
	}

	/**
	 * @return the roles
	 */
	public List<PortalRole> getRoles() {
		return roles;
	}

	/**
	 * @param roles
	 *            the roles to set
	 */
	public void setRoles(List<PortalRole> roles) {
		this.roles = roles;
	}

	/**
	 * @return the users
	 */
	public List<PortalUser> getUsers() {
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<PortalUser> users) {
		this.users = users;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param projects
	 * @param roles
	 * @param users
	 * @param startDate
	 * @param endDate
	 */
	public TimeSheetsWorkCriteria(List<PortalProject> projects,
			List<PortalRole> roles, List<PortalUser> users, Date startDate,
			Date endDate) {
		super();
		this.projects = projects;
		this.roles = roles;
		this.users = users;
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
