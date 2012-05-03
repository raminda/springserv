/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.PortalUserDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("portalUserDao")
public class PortalUserHibernateDao implements PortalUserDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUserDao#getUser(java.lang.String)
	 */
	@Override
	public PortalUser getUser(String email) {
		return (PortalUser) getSessionfactory().getCurrentSession()
				.createQuery("from PortalUser where email=:email")
				.setParameter("email", email).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUserDao#getUsers()
	 */
	@Override
	public List<PortalUser> getUsers() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalUser").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUserDao#getUsers(int, int)
	 */
	@Override
	public List<PortalUser> getUsers(int offset, int limit) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalUser").setFirstResult(offset)
				.setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUserDao#getUsersCount()
	 */
	@Override
	public Long getUsersCount() {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from PortalUser")
				.uniqueResult();
		return m.get("total");
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUserDao#save(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	public void save(PortalUser user) {
		getSessionfactory().getCurrentSession().saveOrUpdate(user);
		getSessionfactory().getCurrentSession().flush();
	}

}
