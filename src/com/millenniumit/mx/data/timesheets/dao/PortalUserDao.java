/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;

/**
 * @author Vimukthi
 *
 */
public interface PortalUserDao {

	/**
	 * @param email
	 * @return
	 */
	public PortalUser getUser(String email);

	/**
	 * @return
	 */
	public List<PortalUser> getUsers();

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<PortalUser> getUsers(int offset, int limit);

	/**
	 * @return
	 */
	public Long getUsersCount();

	/**
	 * @param user
	 */
	public void save(PortalUser user);

}
