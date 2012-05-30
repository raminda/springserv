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

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("timeSheetsWorkOverwriteDao")
public class TimeSheetsWorkOverwriteHibernateDao implements TimeSheetsWorkOverwriteDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao#getTimeSheetsWorkOverwrite(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	public TimeSheetsWorkOverwrite getTimeSheetsWorkOverwrite(PortalUser user,
			Date workDate) {
		return (TimeSheetsWorkOverwrite) getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWorkOverwrite where user=:user and " +
						"workDate=:workDate")
				.setParameter("user", user)
				.setParameter("workDate", workDate).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao#getTimeSheetsWorkOverwrites()
	 */
	@Override
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWorkOverwrite").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao#getTimeSheetsWorkOverwrites(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			PortalUser user) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWorkOverwrite where user=:user")
				.setParameter("user", user).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao#getTimeSheetsWorkOverwrites(java.sql.Date)
	 */
	@Override
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			Date workDate) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWorkOverwrite where workDate=:workDate")
				.setParameter("workDate", workDate).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao#save(com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite)
	 */
	@Override
	public void save(TimeSheetsWorkOverwrite overwrite) {
		getSessionfactory().getCurrentSession().saveOrUpdate(overwrite);
		getSessionfactory().getCurrentSession().flush();
	}
}
