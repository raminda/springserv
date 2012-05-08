/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalProject;

/**
 * @author Vimukthi
 *
 */
public interface PortalProjectDao {

	/**
	 * @param title
	 * @return
	 */
	public PortalProject getProject(String title);

	/**
	 * @return
	 */
	public List<PortalProject> getProjects();

	/**
	 * @param project
	 */
	public void save(PortalProject project);

	/**
	 * @param project
	 */
	public void delete(PortalProject project);

}
