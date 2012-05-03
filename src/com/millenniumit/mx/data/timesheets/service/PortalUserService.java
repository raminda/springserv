/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;

/**
 * @author Vimukthi
 *
 */
public interface PortalUserService {
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public PortalUser getUser(String email);
	
	/**
	 * 
	 * @return
	 */
	public List<PortalUser> getUsers();
	
	/**
	 * 
	 * @return
	 */
	public List<PortalUser> getUsers(int offset, int limit);
	
	/**
	 * 
	 * @return
	 */
	public Long getUsersCount();
	
	/**
	 * 
	 * @param user
	 */
	public void saveUser(PortalUser user);

}
