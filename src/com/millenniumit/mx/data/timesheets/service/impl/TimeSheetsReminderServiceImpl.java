/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.sql.Date;
import java.util.List;

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
