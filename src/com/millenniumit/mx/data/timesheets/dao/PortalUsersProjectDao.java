/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.PortalUsersProject;

/**
 * @author Vimukthi
 *
 */
public interface PortalUsersProjectDao {

	/**
	 * @param user
	 * @param project
	 * @param role
	 * @return
	 */
	public PortalUsersProject getUsersProject(PortalUser user, PortalProject project,
			PortalRole role);

	/**
	 * @return
	 */
	public List<PortalUsersProject> getUsersProjects();

	/**
	 * @param usersProject
	 */
	public void save(PortalUsersProject usersProject);

	/**
	 * @param usersProject
	 */
	public void delete(PortalUsersProject usersProject);

	/**
	 * @param user
	 * @return
	 */
	public List<PortalUsersProject> getUsersProjects(PortalUser user);

}
