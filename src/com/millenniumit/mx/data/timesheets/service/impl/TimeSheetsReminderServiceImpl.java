/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReminder;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService;

/**
 * @author Vimukthi
 *
 */
@Service("timeSheetsReminderService")
public class TimeSheetsReminderServiceImpl implements TimeSheetsReminderService {
	
	@Autowired
	@Qualifier("timeSheetsReminderDao")
	private TimeSheetsReminderDao reminderDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#getReminder(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	@Transactional
	public TimeSheetsReminder getReminder(PortalUser user, Date workDate) {
		return getReminderDao().getReminder(user, workDate);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#getReminders()
	 */
	@Override
	@Transactional
	public List<TimeSheetsReminder> getReminders() {
		return getReminderDao().getReminders();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#getReminders(java.sql.Date)
	 */
	@Override
	@Transactional
	public List<TimeSheetsReminder> getReminders(Date workDate) {
		return getReminderDao().getReminders(workDate);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#getReminders(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public List<TimeSheetsReminder> getReminders(PortalUser user) {
		return getReminderDao().getReminders(user);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#getActivityPercentage(java.util.List, java.sql.Date, java.sql.Date)
	 */
	@Override
	@Transactional
	public Map<String, Integer> getActivityPercentage(List<PortalUser> users,
			Date startDate, Date endDate) {
		List<TimeSheetsReminder> reminders = getReminderDao().getReminders(users, startDate, endDate);
		// records the number of timesheets replied
		int sentCount = 0;
		// records the number of timesheets not replied
		int notSentCount = 0;
		for (TimeSheetsReminder reminder : reminders) {
			if (reminder.getUpdateCount() > 0) {
				sentCount++;
			} else {
				notSentCount++;
			}
		}
		Map<String, Integer> percentages = new HashMap<String, Integer>();
		percentages.put("received", sentCount);
		percentages.put("notReceived", notSentCount);
		return percentages;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReminderService#saveReminder(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	@Transactional
	public void updateReminder(PortalUser user, Date workDate) {
		TimeSheetsReminder reminder = getReminderDao().getReminder(user, workDate);
		if (reminder == null){
			reminder = new TimeSheetsReminder();
			reminder.setUser(user);
			reminder.setWorkDate(workDate);
			reminder.setUpdateCount(1);
		} else {
			reminder.setUpdateCount(reminder.getUpdateCount() + 1);
		}
		getReminderDao().save(reminder);
	}

	/**
	 * @return the reminderDao
	 */
	public TimeSheetsReminderDao getReminderDao() {
		return reminderDao;
	}

	/**
	 * @param reminderDao the reminderDao to set
	 */
	public void setReminderDao(TimeSheetsReminderDao reminderDao) {
		this.reminderDao = reminderDao;
	}
}
