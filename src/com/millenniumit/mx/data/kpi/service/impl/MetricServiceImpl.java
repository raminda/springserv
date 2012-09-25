/**
 * 
 */
package com.millenniumit.mx.data.kpi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
	public String getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, String tableName, String columnName, String weekOperator) {

		List<String> ids = getMetricDao().getSourceTickets(as_at, week, projectId,
				watchedReleaseId, roleCategoryId, tableName, columnName, weekOperator);

		String ticketString = StringUtils.collectionToCommaDelimitedString(ids);
		return ticketString;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.kpi.service.MetricService#getSourceTickets(long,
	 * long, long, long, long, java.lang.String[], java.lang.String[],
	 * java.lang.String)
	 */
	@Transactional
	@Override
	public String getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, Map<String, String> tablecolumns, String weekOperator) {

		List<String> ids = metricDao.getSourceTickets(as_at, week, projectId, watchedReleaseId,
				roleCategoryId, tablecolumns, weekOperator);

		if (ids == null) {
			return "";
		}

		String ticketString = StringUtils.collectionToCommaDelimitedString(ids);
		return ticketString;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.kpi.service.MetricService#getSourceTicketsList
	 * (long, long, long, long, long, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Transactional
	@Override
	public List<String> getSourceTicketsList(long as_at, long week, long projectId,
			long watchedReleaseId, long roleCategoryId, String tableName, String columnName,
			String weekOperator) {

		List<String> ticketsStrings = getMetricDao().getSourceTickets(as_at, week, projectId,
				watchedReleaseId, roleCategoryId, tableName, columnName, weekOperator);

		return FormatList(ticketsStrings);
	}

	/**
	 * 
	 * @param ticketsStrings
	 * @return
	 */
	private List<String> FormatList(List<String> ticketsStrings) {

		List<String> ticketids = new ArrayList<String>();
		for (String t : ticketsStrings) {

			if(t == null){
				continue;
			}
			
			String[] arr = t.split(",");
			for (String u : arr) {
				ticketids.add(u);
			}
		}
		return ticketids;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.kpi.service.MetricService#getSourceTicketsList
	 * (long, long, long, long, long, java.util.Map, java.lang.String)
	 */

	@Transactional
	@Override
	public List<String> getSourceTicketsList(long as_at, long week, long projectId,
			long watchedReleaseId, long roleCategoryId, Map<String, String> tablecolumns,
			String weekOperator) {

		List<String> ticketsStrings = getMetricDao().getSourceTickets(as_at, week, projectId,
				watchedReleaseId, roleCategoryId, tablecolumns, weekOperator);

		return FormatList(ticketsStrings);
	}
}
