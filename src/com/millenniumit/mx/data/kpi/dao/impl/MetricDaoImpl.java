/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, String tableName, String columnName, String weekOperator) {

		String sql = "select " + columnName  + " from " + tableName
				+ " where as_at = :asAt and week " + weekOperator + " :week "
				+ "and role_category_id = :role " + "and project_id = :project";

		if (watchedReleaseId != 0) {
			sql += " and watched_release_id = :watchedReleaseId ";
		}

		Query query = getKpiSessionFactory().getCurrentSession().createSQLQuery(sql);
		System.out.println("Query = " + query.getQueryString());

		query.setParameter("asAt", as_at);
		query.setParameter("week", week);
		query.setParameter("role", roleCategoryId);
		query.setParameter("project", projectId);

		if (watchedReleaseId != 0) {
			query.setParameter("watchedReleaseId", watchedReleaseId);
		}
	    List<String> tickt = (List<String>)query.list();
		
		return tickt;
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.dao.MetricDao#getSourceTickets(long,
	 * long, long, long, long, java.lang.String[], java.lang.String[],
	 * java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, Map<String, String> tablecolumns, String weekOperator) {

		List<String> tickets = new ArrayList<String>();
		
		for (Map.Entry<String, String> entry : tablecolumns.entrySet()) {

			String table = entry.getKey();
			String column = entry.getValue();

			String sql = "select " + column + " from " + table + " where"
					+ " as_at = :asAt and week " + weekOperator + " :week "
					+ "and role_category_id = :role " + "and project_id = :project";

			if (watchedReleaseId != 0) {
				sql += " and watched_release_id = :watchedReleaseId ";
			}

			Query query = getKpiSessionFactory().getCurrentSession().createSQLQuery(sql);

			query.setParameter("asAt", as_at);
			query.setParameter("week", week);
			query.setParameter("role", roleCategoryId);
			query.setParameter("project", projectId);

			System.out.println(query.getQueryString());

			if (watchedReleaseId != 0) {
				query.setParameter("watchedReleaseId", watchedReleaseId);
			}

			for(String t : (List<String>)query.list() ) {
				
				if(t !=  null && !t.equals("")  && !t.equals(" ")){
					tickets.add(t);
				}
			}
		}
		return tickets;
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
