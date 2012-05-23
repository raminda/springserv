/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.sql.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReminder;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("timeSheetsReminderDao")
public class TimeSheetsReminderHibernateDao implements TimeSheetsReminderDao {
	
	@Autowired
	@Qualifier("timeSheetsSessionFactory")
	private SessionFactory sessionfactory;

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	/**
	 * @param sessionfactory the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#getReminder(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	public TimeSheetsReminder getReminder(PortalUser user, Date workDate) {
		return (TimeSheetsReminder) getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReminder where user=:user and " +
						"workDate=:workDate")
				.setParameter("user", user)
				.setParameter("workDate", workDate).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#getReminders()
	 */
	@Override
	public List<TimeSheetsReminder> getReminders() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReminder").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#getReminders(java.sql.Date)
	 */
	@Override
	public List<TimeSheetsReminder> getReminders(Date workDate) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReminder where workDate=:workDate")
				.setParameter("workDate", workDate).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#getReminders(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	public List<TimeSheetsReminder> getReminders(PortalUser user) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReminder where user=:user")
				.setParameter("user", user).list();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#getReminders(java.util.List, java.sql.Date, java.sql.Date)
	 */
	@Override
	public List<TimeSheetsReminder> getReminders(List<PortalUser> users,
			Date startDate, Date endDate) {
		if (startDate == null && endDate == null){
			return getSessionfactory().getCurrentSession()
					.createQuery("from TimeSheetsReminder where user in (:users)")
					.setParameterList("users", users).list();
		} else if (startDate == null){
			return getSessionfactory().getCurrentSession()
					.createQuery("from TimeSheetsReminder where user in (:users) and " +
							"workDate <= :end")
					.setParameterList("users", users)
					.setParameter("end", endDate).list();
		} else if (endDate == null){
			return getSessionfactory().getCurrentSession()
					.createQuery("from TimeSheetsReminder where user in (:users) and " +
							"workDate >= :start")
					.setParameterList("users", users)
					.setParameter("start", startDate).list();
		} else {
			return getSessionfactory().getCurrentSession()
					.createQuery("from TimeSheetsReminder where user in (:users) and " +
							"workDate between :start and :end")
					.setParameterList("users", users)
					.setParameter("start", startDate)
					.setParameter("end", endDate).list();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReminderDao#save(com.millenniumit.mx.data.timesheets.domain.TimeSheetsReminder)
	 */
	@Override
	public void save(TimeSheetsReminder reminder) {
		getSessionfactory().getCurrentSession().saveOrUpdate(reminder);
		getSessionfactory().getCurrentSession().flush();
	}
}
