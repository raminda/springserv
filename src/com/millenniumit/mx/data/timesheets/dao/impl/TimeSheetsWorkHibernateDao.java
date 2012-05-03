package com.millenniumit.mx.data.timesheets.dao.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.WorkDao;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;

/**
 * 
 * @author Vimukthi
 * 
 */
@SuppressWarnings("unchecked")
@Repository("timeSheetsWorkDao")
public class TimeSheetsWorkHibernateDao implements WorkDao<TimeSheetsWork> {

	/**
	 * 
	 */
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
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsUserWork
	 * (com.millenniumit.mx.data.timesheets.domain.PortalUser,
	 * com.millenniumit.mx.data.timesheets.domain.PortalProject,
	 * com.millenniumit.mx.data.timesheets.domain.PortalRole, java.sql.Date)
	 */
	@Override
	public TimeSheetsWork getTimeSheetsUserWork(PortalUser user,
			PortalProject project, PortalRole role, Date workDate, String reference) {
		return (TimeSheetsWork) getSessionfactory()
				.getCurrentSession()
				.createQuery(
						"from TimeSheetsWork where user=:user and "
								+ "project=:project and role=:role and " +
								"workDate=:workDate and reference=:reference")
				.setParameter("user", user).setParameter("project", project)
				.setParameter("role", role).setParameter("workDate", workDate)
				.setParameter("reference", reference)
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWork()
	 */
	@Override
	public List<TimeSheetsWork> getTimeSheetsWork() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWork").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWork(long,
	 * long)
	 */
	@Override
	public List<TimeSheetsWork> getTimeSheetsWork(int offset, int limit) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsWork").setFirstResult(offset)
				.setMaxResults(limit).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWorkCount()
	 */
	@Override
	public Long getTimeSheetsWorkCount() {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) "
								+ "from TimeSheetsWork").uniqueResult();
		return m.get("total");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWork(java
	 * .util.List, java.util.List, java.util.List, java.sql.Date, java.sql.Date)
	 */
	@Override
	public List<TimeSheetsWork> getTimeSheetsWork(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate) {
		if (users.isEmpty() && projects.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where workDate "
									+ "between :startDate and :endDate")
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (users.isEmpty() && projects.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (projects.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (users.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (users.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where project in :projects "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (projects.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users).setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else if (roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}

		else {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and project in :projects and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).list();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWork(java
	 * .util.List, java.util.List, java.util.List, java.sql.Date, java.sql.Date,
	 * int, int)
	 */
	@Override
	public List<TimeSheetsWork> getTimeSheetsWork(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate, int offset, int limit) {
		if (users.isEmpty() && projects.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where workDate "
									+ "between :startDate and :endDate")
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (users.isEmpty() && projects.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (projects.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (users.isEmpty() && roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (users.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where project in :projects "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (projects.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users).setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else if (roles.isEmpty()) {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}

		else {
			return getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"from TimeSheetsWork where user in :users "
									+ "and project in :projects and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).setFirstResult(offset)
					.setMaxResults(limit).list();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#getTimeSheetsWorkCount
	 * (java.util.List, java.util.List, java.util.List, java.sql.Date,
	 * java.sql.Date)
	 */
	@Override
	public Long getTimeSheetsWorkCount(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate) {
		Map<String, Long> m;
		if (users.isEmpty() && projects.isEmpty() && roles.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where workDate "
									+ "between :startDate and :endDate")
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (users.isEmpty() && projects.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (projects.isEmpty() && roles.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where user in :users and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (users.isEmpty() && roles.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (users.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where project in :projects "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (projects.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where user in :users "
									+ "and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users).setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else if (roles.isEmpty()) {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where user in :users "
									+ "and project in :projects and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}

		else {
			m = (Map<String, Long>) getSessionfactory()
					.getCurrentSession()
					.createQuery(
							"select new map(count(*) as total) from TimeSheetsWork where user in :users "
									+ "and project in :projects and role in :roles and workDate "
									+ "between :startDate and :endDate")
					.setParameterList("users", users)
					.setParameterList("projects", projects)
					.setParameterList("roles", roles)
					.setParameter("startDate", startDate)
					.setParameter("endDate", endDate).uniqueResult();
		}
		return m.get("total");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.dao.WorkDao#save(com.millenniumit
	 * .mx.data.timesheets.domain.TimeSheetsWork)
	 */
	@Override
	public void save(TimeSheetsWork timesheetWork) {
		getSessionfactory().getCurrentSession().save(timesheetWork);
		getSessionfactory().getCurrentSession().flush();
	}

}