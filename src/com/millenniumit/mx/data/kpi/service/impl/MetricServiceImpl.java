/**
 * 
 */
package com.millenniumit.mx.data.kpi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.MetricDao;
import com.millenniumit.mx.data.kpi.service.MetricService;

/**
 * @author kalpag
 * 
 */
@Service("metricService")
public class MetricServiceImpl implements MetricService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.kpi.service.MetricService#getTickets(long,
	 * long, long, long, java.lang.String, java.lang.String, java.lang.String)
	 */

	@Autowired
	@Qualifier("metricDao")
	private MetricDao metricDao;

	@Transactional
	@Override
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String tableName, String columnName, String weekOperator) {
		return getMetricDao().getTickets(as_at, week, projectId, roleCategoryId, tableName,
				columnName, weekOperator);
	}

	/**
	 * @return the metricDao
	 */
	public MetricDao getMetricDao() {
		return metricDao;
	}

	/**
	 * @param metricDao
	 *            the metricDao to set
	 */
	public void setMetricDao(MetricDao metricDao) {
		this.metricDao = metricDao;
	}
}
