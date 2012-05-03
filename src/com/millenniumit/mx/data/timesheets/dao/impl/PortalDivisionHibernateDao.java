/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.PortalDivisionDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("portalDivisionDao")
public class PortalDivisionHibernateDao implements PortalDivisionDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalDivisionDao#getDivision(java.lang.String)
	 */
	@Override
	public PortalDivision getDivision(String title) {
		return (PortalDivision) getSessionfactory().getCurrentSession()
				.createQuery("from PortalDivision where title=:title")
				.setParameter("title", title).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalDivisionDao#getDivisions()
	 */
	@Override
	public List<PortalDivision> getDivisions() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalDivision").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalDivisionDao#save(com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	public void save(PortalDivision division) {
		getSessionfactory().getCurrentSession().saveOrUpdate(division);
		getSessionfactory().getCurrentSession().flush();
	}
}
