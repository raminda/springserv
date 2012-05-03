/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.PortalProjectDao;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("portalProjectDao")
public class PortalProjectHibernateDao implements PortalProjectDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalProjectDao#getProject(java.lang.String)
	 */
	@Override
	public PortalProject getProject(String title) {
		return (PortalProject) getSessionfactory().getCurrentSession()
				.createQuery("from PortalProject where title=:title")
				.setParameter("title", title).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalProjectDao#getProjects()
	 */
	@Override
	public List<PortalProject> getProjects() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalProject").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalProjectDao#save(com.millenniumit.mx.data.timesheets.domain.PortalProject)
	 */
	@Override
	public void save(PortalProject project) {
		getSessionfactory().getCurrentSession().saveOrUpdate(project);
		getSessionfactory().getCurrentSession().flush();
	}
}
