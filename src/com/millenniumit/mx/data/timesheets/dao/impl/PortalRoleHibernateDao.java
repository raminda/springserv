/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.PortalRoleDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("portalRoleDao")
public class PortalRoleHibernateDao implements PortalRoleDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalRoleDao#getRole(java.lang.String, com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	public PortalRole getRole(String title, PortalDivision division) {
		return (PortalRole) getSessionfactory().getCurrentSession()
				.createQuery("from PortalRole where title=:title and division=:division")
				.setParameter("title", title)
				.setParameter("division", division).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalRoleDao#getRoles()
	 */
	@Override
	public List<PortalRole> getRoles() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalRole").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalRoleDao#save(com.millenniumit.mx.data.timesheets.domain.PortalRole)
	 */
	@Override
	public void save(PortalRole role) {
		getSessionfactory().getCurrentSession().saveOrUpdate(role);
		getSessionfactory().getCurrentSession().flush();
	}

}
