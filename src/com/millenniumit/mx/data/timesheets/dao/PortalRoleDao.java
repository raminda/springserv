/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;

/**
 * @author Vimukthi
 *
 */
public interface PortalRoleDao {

	/**
	 * @param title
	 * @param division
	 * @return
	 */
	public PortalRole getRole(String title, PortalDivision division);

	/**
	 * @return
	 */
	public List<PortalRole> getRoles();

	/**
	 * @param role
	 */
	public void save(PortalRole role);

	/**
	 * @param role
	 */
	public void delete(PortalRole role);

}
