/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao.impl;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.MetricDao;

/**
 * @author kalpag
 * 
 */

@Repository("metricDao")
public class MetricDaoImpl implements MetricDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.MetricDao#getTickets(long, long,
	 * long, long, java.lang.String, java.lang.String, java.lang.String)
	 */

	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory kpiSessionFactory;

	@Override
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String tableName, String columnName, String weekOperator) {

		Query query = getKpiSessionFactory().getCurrentSession().createSQLQuery(
				"select group_concat(" + columnName + ") " + " from " + tableName
						+ " where as_at = :asAt and week " + weekOperator + " :week "
						+ "and role_category_id = :role " + "and project_id = :project");

		query.setParameter("asAt", as_at);
		query.setParameter("week", week);
		query.setParameter("role", roleCategoryId);
		query.setParameter("project", projectId);

		return (String) query.uniqueResult();
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

}
