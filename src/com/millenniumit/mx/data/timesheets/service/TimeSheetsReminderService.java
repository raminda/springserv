/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.sql.Date;
import java.util.List;

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
	 * 
	 * @param reminder
	 */
	public void updateReminder(PortalUser user, Date workDate);

}
