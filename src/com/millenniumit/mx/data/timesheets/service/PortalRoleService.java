/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;

/**
 * @author Vimukthi
 *
 */
public interface PortalRoleService {
	
	/**
	 * 
	 * @param title
	 * @return
	 */
	public PortalRole getRole(String title, PortalDivision division);
	
	/**
	 * 
	 * @return
	 */
	public List<PortalRole> getRoles();
	
	/**
	 * 
	 * @param role
	 */
	public void saveRole(PortalRole role);
	
	/**
	 * 
	 * @param role
	 */
	public void deleteRole(PortalRole role);

}
