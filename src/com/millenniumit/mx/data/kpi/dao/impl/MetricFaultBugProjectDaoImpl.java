/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.MetricFaultBugProjectDao;
import com.millenniumit.mx.data.kpi.domain.MetricFaultBugProject;

/**
 * @author kalpag
 * 
 */
@Repository("metricFaultBugProjectDao")
public class MetricFaultBugProjectDaoImpl implements MetricFaultBugProjectDao {

	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.Dao#get(java.lang.Long)
	 */
	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory kpiSessionFactory;

	@Override
	public MetricFaultBugProject get(Long id) {

		return (MetricFaultBugProject) kpiSessionFactory.getCurrentSession()
				.createQuery("from MetricFaultBugProject where id = :id").setParameter("id", id)
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.Dao#getAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MetricFaultBugProject> getAll() {
		return (List<MetricFaultBugProject>) getKpiSessionFactory().getCurrentSession()
				.createQuery("from MetricFaultBugProject").list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<MetricFaultBugProject> getAll(int start, int limit) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(MetricFaultBugProject object) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(MetricFaultBugProject object) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.MetricFaultBugProjectDao#
	 * getMetricFaultBugProject(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MetricFaultBugProject> getMetricFaultBugProject(long as_at) {

		return (List<MetricFaultBugProject>) getKpiSessionFactory().getCurrentSession()
				.createQuery("from MetricFaultBugProject where as_at = :asAt ")
				.setParameter("asAt", as_at).list();
	}

	/**
	 * @return the kpiSessionFactory
	 */
	public SessionFactory getKpiSessionFactory() {
		return kpiSessionFactory;
	}

	/**
	 * @param kpiSessionFactory
	 *            the kpiSessionFactory to set
	 */
	public void setKpiSessionFactory(SessionFactory kpiSessionFactory) {
		this.kpiSessionFactory = kpiSessionFactory;
	}

	@Override
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String columnName, String weekOperator) {

		Query query = getKpiSessionFactory().getCurrentSession().createSQLQuery(
				"select group_concat(" + columnName + ") "
						+ " from metric_fault_bug_project where as_at = :asAt and week "
						+ weekOperator + " :week " 
						+ "and role_category_id = :role " 
						+ "and project_id = :project");

		query.setParameter("asAt", as_at);
		query.setParameter("week", week);
		query.setParameter("role", roleCategoryId);
		query.setParameter("project", projectId);
		
		return (String) query.uniqueResult();
	}
}
