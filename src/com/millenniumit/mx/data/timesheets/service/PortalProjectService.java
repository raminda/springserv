/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalProject;

/**
 * @author Vimukthi
 *
 */
public interface PortalProjectService {
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	public PortalProject getProject(String title);
	
	/**
	 * 
	 * @return
	 */
	public List<PortalProject> getProjects();
	
	/**
	 * 
	 * @param project
	 */
	public void saveProject(PortalProject project);
	
	/**
	 * 
	 * @param project
	 */
	public void deleteProject(PortalProject project);

}
