/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.*;

/**
 * @author Vimukthi
 *
 */
public interface PortalUserProjectService {
	
	/**
	 * 
	 * @param user
	 * @param project
	 * @param role
	 * @return
	 */
	public PortalUsersProject getUsersProject(PortalUser user, PortalProject project, PortalRole role);
	
	/**
	 * 
	 * @return
	 */
	public List<PortalUsersProject> getUsersProjects();
	
	/**
	 * 
	 * @param usersProject
	 */
	public void saveUsersProject(PortalUsersProject usersProject);
}
