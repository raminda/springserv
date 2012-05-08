package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;

/**
 * 
 * @author Vimukthi
 *
 */
public interface TimeSheetsUserDao {
	
	/**
	 * @param user
	 * @return
	 */
	public TimeSheetsUser getTimeSheetsUser(PortalUser user);

	/**
	 * @return
	 */
	public List<TimeSheetsUser> getTimeSheetsUsers();

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<TimeSheetsUser> getTimeSheetsUsers(int offset, int limit);

	/**
	 * @return
	 */
	public Long getTimeSheetsUsersCount();

	/**
	 * @param timeSheetsUser
	 */
	public void save(TimeSheetsUser timeSheetsUser);

	/**
	 * @param timeSheetsUser
	 */
	public void delete(TimeSheetsUser timeSheetsUser);
	
}