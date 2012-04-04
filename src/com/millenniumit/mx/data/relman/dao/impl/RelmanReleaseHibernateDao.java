package com.millenniumit.mx.data.relman.dao.impl;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanReleaseDao;
import com.millenniumit.mx.data.relman.domain.*;

/**
 * RelmanReleaseDao for Hibernate
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Repository("relmanReleaseDao")
@SuppressWarnings("unchecked")
public class RelmanReleaseHibernateDao implements RelmanReleaseDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public RelmanRelease getRelmanRelease(String relmanId) {
		return (RelmanRelease) sessionfactory.getCurrentSession()
				.createQuery("from RelmanRelease where relmanId=:param")
				.setParameter("param", relmanId).uniqueResult();
	}

	@Override
	public RelmanRelease getRelmanRelease(Long id) {
		return (RelmanRelease) sessionfactory.getCurrentSession()
				.createQuery("from RelmanRelease where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/*********************************************************************
	 * Return all functions
	 *********************************************************************/

	@Override
	public List<RelmanRelease> getRelmanReleases() {
		return sessionfactory.getCurrentSession()
				.createQuery("from RelmanRelease").list();
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanProject project) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where project=:param")
				.setParameter("param", project).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where parentRelease=:param")
				.setParameter("param", parentRelease).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(String status) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where status=:param")
				.setParameter("param", status).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			String status) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"from RelmanRelease where project=:param1 and status=:param2")
				.setParameter("param1", project).setParameter("param2", status)
				.list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease,
			String status) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"from RelmanRelease where parentRelease=:param1 and status=:param2")
				.setParameter("param1", parentRelease)
				.setParameter("param2", status).list();
		return releases;
	}

	/*********************************************************************
	 * Count functions
	 *********************************************************************/

	@Override
	public long getRelmanReleasesCount() {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) from RelmanRelease")
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanReleasesCount(RelmanProject project) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from RelmanRelease where project=:param")
				.setParameter("param", project).uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanReleasesCount(RelmanRelease parentRelease) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from RelmanRelease where parentRelease=:param")
				.setParameter("param", parentRelease).uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanReleasesCount(String status) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from RelmanRelease where status=:param")
				.setParameter("param", status).uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanReleasesCount(RelmanProject project, String status) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from RelmanRelease where project=:param1 and status=:param2")
				.setParameter("param1", project).setParameter("param2", status)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanReleasesCount(RelmanRelease parentRelease,
			String status) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"select new map(count(*) as total) " +
						"from RelmanRelease where parentRelease=:param1 and status=:param2")
				.setParameter("param1", parentRelease)
				.setParameter("param2", status).uniqueResult();
		return m.get("total");
	}

	/*********************************************************************
	 * Paginate functions
	 *********************************************************************/

	@Override
	public List<RelmanRelease> getRelmanReleases(int offset, int limit) {
		return sessionfactory.getCurrentSession()
				.createQuery("from RelmanRelease").setFirstResult(offset)
				.setMaxResults(limit).list();
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			int offset, int limit) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where project=:param")
				.setParameter("param", project).setFirstResult(offset)
				.setMaxResults(limit).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease,
			int offset, int limit) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where parentRelease=:param")
				.setParameter("param", parentRelease).setFirstResult(offset)
				.setMaxResults(limit).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease,
			String state, int offset, int limit) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"from RelmanRelease where parentRelease=:param1 and status=:param2")
				.setParameter("param1", parentRelease)
				.setParameter("param2", state).setFirstResult(offset)
				.setMaxResults(limit).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			String state, int offset, int limit) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery(
						"from RelmanRelease where project=:param1 and status=:param2")
				.setParameter("param1", project).setParameter("param2", state)
				.setFirstResult(offset).setMaxResults(limit).list();
		return releases;
	}

	@Override
	public List<RelmanRelease> getRelmanReleases(String status, int offset,
			int limit) {
		List<RelmanRelease> releases = (List<RelmanRelease>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanRelease where status=:param")
				.setParameter("param", status).setFirstResult(offset)
				.setMaxResults(limit).list();
		return releases;
	}
}
