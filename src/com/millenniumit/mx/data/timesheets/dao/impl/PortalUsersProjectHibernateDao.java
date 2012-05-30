/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.PortalUsersProject;

/**
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("portalUsersProjectDao")
public class PortalUsersProjectHibernateDao implements PortalUsersProjectDao {
	
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
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao#getUsersProject(com.millenniumit.mx.data.timesheets.domain.PortalUser, com.millenniumit.mx.data.timesheets.domain.PortalProject, com.millenniumit.mx.data.timesheets.domain.PortalRole)
	 */
	@Override
	public PortalUsersProject getUsersProject(PortalUser user,
			PortalProject project, PortalRole role) {
		return (PortalUsersProject) getSessionfactory().getCurrentSession()
				.createQuery("from PortalUsersProject where user=:user " +
						"and project=:project and role=:role")
				.setParameter("user", user)
				.setParameter("project", project)
				.setParameter("role", role).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao#getUsersProjects()
	 */
	@Override
	public List<PortalUsersProject> getUsersProjects() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalUsersProject").list();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao#getUsersProjects()
	 */
	@Override
	public List<PortalUsersProject> getUsersProjects(PortalUser user) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from PortalUsersProject where user=:user")
				.setParameter("user", user).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao#save(com.millenniumit.mx.data.timesheets.domain.PortalUsersProject)
	 */
	@Override
	public void save(PortalUsersProject usersProject) {
		getSessionfactory().getCurrentSession().saveOrUpdate(usersProject);
		getSessionfactory().getCurrentSession().flush();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao#save(com.millenniumit.mx.data.timesheets.domain.PortalUsersProject)
	 */
	@Override
	public void delete(PortalUsersProject usersProject) {
		getSessionfactory().getCurrentSession().delete(usersProject);
		getSessionfactory().getCurrentSession().flush();
	}

}
