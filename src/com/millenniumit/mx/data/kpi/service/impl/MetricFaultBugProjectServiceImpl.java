/**
 * 
 */
package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.MetricFaultBugProjectDao;
import com.millenniumit.mx.data.kpi.domain.MetricFaultBugProject;
import com.millenniumit.mx.data.kpi.service.MetricFaultBugProjectService;

/**
 * @author kalpag
 * 
 */
@Service("metricFaultBugProjectService")
public class MetricFaultBugProjectServiceImpl implements MetricFaultBugProjectService {

	@Autowired
	@Qualifier("metricFaultBugProjectDao")
	private MetricFaultBugProjectDao metricFaultBugProjectDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.MetricFaultBugProjectService
	 * #getMetricFaultBugProject(java.lang.String)
	 */
	@Transactional
	@Override
	public List<MetricFaultBugProject> getMetricFaultBugProject(long as_at) {

		return getMetricFaultBugProjectDao().getMetricFaultBugProject(as_at);
	}

	/**
	 * @return the metricFaultBugProjectDao
	 */
	public MetricFaultBugProjectDao getMetricFaultBugProjectDao() {
		return metricFaultBugProjectDao;
	}

	/**
	 * @param metricFaultBugProjectDao
	 *            the metricFaultBugProjectDao to set
	 */
	public void setMetricFaultBugProjectDao(MetricFaultBugProjectDao metricFaultBugProjectDao) {
		this.metricFaultBugProjectDao = metricFaultBugProjectDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.kpi.service.MetricFaultBugProjectService#get
	 * (java.lang.Long)
	 */
	@Transactional
	@Override
	public MetricFaultBugProject get(Long id) {

		return metricFaultBugProjectDao.get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.kpi.service.MetricFaultBugProjectService#getTickets
	 * (long, long, java.lang.String, boolean)
	 */
	@Transactional
	@Override
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String columnName, String weekOperator) {
		return metricFaultBugProjectDao.getTickets(as_at, week, projectId, roleCategoryId, columnName, weekOperator);
	}
}
