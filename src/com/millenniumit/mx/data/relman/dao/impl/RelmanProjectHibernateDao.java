package com.millenniumit.mx.data.relman.dao.impl;

import java.util.*;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanProjectDao;
import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("relmanProjectDao")
@SuppressWarnings("unchecked")
public class RelmanProjectHibernateDao implements RelmanProjectDao {

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
	public RelmanProject getRelmanProject(Long id) {
		return (RelmanProject) sessionfactory.getCurrentSession().
				createQuery("from RelmanProject where id=:param")
				.setParameter("param", id).uniqueResult();	
	}

	@Override
	public RelmanProject getRelmanProject(String relman_id) {
		return (RelmanProject) sessionfactory.getCurrentSession().
				createQuery("from RelmanProject where relmanId=:param")
				.setParameter("param", relman_id).uniqueResult();	
	}
	
	/**************************************************************************
	 * get all functions
	 **************************************************************************/

	@Override
	public List<RelmanProject> getRelmanProjects() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanProject").list();
	}
	
	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId, String type) {
		
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, String type) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param3", type)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			String type) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"relmanLayerId=:param2")
				.setParameter("param2", relmanLayerId)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(RelmanLogicalLayer logicalLayer) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1")
				.setParameter("param1", logicalLayer)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(String type) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"type=:param3")
				.setParameter("param3", type)
				.list();
		return projects;
	}
	
	
	/**************************************************************************
	 * paginate functions
	 **************************************************************************/
	
	@Override
	public List<RelmanProject> getRelmanProjects(int offset, int limit) {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanProject")
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId,
			String type, int offset, int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId, int offset,
			int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, String type, int offset, int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param3", type)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			String type, int offset, int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			int offset, int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"relmanLayerId=:param2")
				.setParameter("param2", relmanLayerId)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, int offset, int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"logicalLayer=:param1")
				.setParameter("param1", logicalLayer)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}

	@Override
	public List<RelmanProject> getRelmanProjects(String type, int offset,
			int limit) {
		List<RelmanProject> projects = (List<RelmanProject>) sessionfactory
				.getCurrentSession()
				.createQuery("from RelmanProject where " +
						"type=:param3")
				.setParameter("param3", type)
				.setFirstResult(offset)
				.setMaxResults(limit)
				.list();
		return projects;
	}
	
	
	/**************************************************************************
	 * count functions
	 **************************************************************************/

	@Override
	public long getRelmanProjectsCount() {
		Map<String, Long> m = (Map<String, Long>) sessionfactory.getCurrentSession().
				createQuery("select new map(count(*) as total) from RelmanProject").uniqueResult();
		
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			Integer relmanLayerId, String type) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			Integer relmanLayerId) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"relmanLayerId=:param2")
				.setParameter("param1", logicalLayer)
				.setParameter("param2", relmanLayerId)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			String type) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"logicalLayer=:param1 and " +
						"type=:param3")
				.setParameter("param1", logicalLayer)
				.setParameter("param3", type)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(Integer relmanLayerId, String type) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"relmanLayerId=:param2 and " +
						"type=:param3")
				.setParameter("param2", relmanLayerId)
				.setParameter("param3", type)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(Integer relmanLayerId) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"relmanLayerId=:param2")
				.setParameter("param2", relmanLayerId)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"logicalLayer=:param1")
				.setParameter("param1", logicalLayer)
				.uniqueResult();
		return m.get("total");
	}

	@Override
	public long getRelmanProjectsCount(String type) {
		Map<String, Long> m = (Map<String, Long>) sessionfactory
				.getCurrentSession()
				.createQuery("select new map(count(*) as total) from RelmanProject where " +
						"type=:param3")
				.setParameter("param3", type)
				.uniqueResult();
		return m.get("total");
	}

}
