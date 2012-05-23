/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReminder;

/**
 * @author Vimukthi
 *
 */
public interface TimeSheetsReminderService {
	
	/**
	 * 
	 * @param user
	 * @param workDate
	 * @return
	 */
	public TimeSheetsReminder getReminder(PortalUser user, Date workDate);
	
	/**
	 * 
	 * @return
	 */
	public List<TimeSheetsReminder> getReminders();
	
	/**
	 * 
	 * @param workDate
	 * @return
	 */
	public List<TimeSheetsReminder> getReminders(Date workDate);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<TimeSheetsReminder> getReminders(PortalUser user);
	
	/**
	 * This will return the sum of number of timesheets missing vs
	 * sum of number of timesheets receieved for the given time period.
	 * @param users
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Map<String, Integer> getActivityPercentage(List<PortalUser> users, Date startDate, Date endDate);
	
	/**
	 * 
	 * @param reminder
	 */
	public void updateReminder(PortalUser user, Date workDate);

}
