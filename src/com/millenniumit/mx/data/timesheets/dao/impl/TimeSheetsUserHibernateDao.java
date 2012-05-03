package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;

/**
 * 
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("timeSheetsUserDao")
public class TimeSheetsUserHibernateDao implements TimeSheetsUserDao {

	@Autowired
	@Qualifier("timeSheetsSessionFactory")
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#getTimeSheetsUser(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	public TimeSheetsUser getTimeSheetsUser(PortalUser user) {
		return (TimeSheetsUser) getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsUser where user=:user")
				.setParameter("user", user).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#getTimeSheetsUsers()
	 */
	@Override
	public List<TimeSheetsUser> getTimeSheetsUsers() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsUser").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#getTimeSheetsUsers(int, int)
	 */
	@Override
	public List<TimeSheetsUser> getTimeSheetsUsers(int offset, int limit) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsUser").setFirstResult(offset)
				.setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#getTimeSheetsUsersCount()
	 */
	@Override
	public Long getTimeSheetsUsersCount() {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from TimeSheetsUser")
				.uniqueResult();
		return m.get("total");
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#save(com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser)
	 */
	@Override
	public void save(TimeSheetsUser timeSheetsUser) {
		getSessionfactory().getCurrentSession().saveOrUpdate(timeSheetsUser);
		getSessionfactory().getCurrentSession().flush();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao#delete(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	public void delete(PortalUser user) {
		getSessionfactory().getCurrentSession().delete(user);
		getSessionfactory().getCurrentSession().flush();
	}	
}