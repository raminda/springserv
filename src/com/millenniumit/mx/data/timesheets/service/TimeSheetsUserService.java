package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;


/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 * 
 */
public interface TimeSheetsUserService {
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public TimeSheetsUser getTimeSheetsUser(PortalUser user);
	
	/**
	 * 
	 * @return
	 */
	public List<TimeSheetsUser> getTimeSheetsUsers();
	
	/**
	 * 
	 * @return
	 */
	public List<TimeSheetsUser> getTimeSheetsUsers(int offset, int limit);
	
	/**
	 * 
	 * @return
	 */
	public Long getTimeSheetsUsersCount();
	
	/**
	 * 
	 * @param timeSheetsUser
	 */
	public void saveTimeSheetsUser(TimeSheetsUser timeSheetsUser);
	
	/**
	 * 
	 * @param user
	 */
	public void deleteTimeSheetsUser(PortalUser user);
}