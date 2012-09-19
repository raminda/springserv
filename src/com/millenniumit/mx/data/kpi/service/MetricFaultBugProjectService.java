/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.MetricFaultBugProject;

/**
 * @author kalpag
 * 
 */
public interface MetricFaultBugProjectService {

	public List<MetricFaultBugProject> getMetricFaultBugProject(long as_at);

	public MetricFaultBugProject get(Long id);

	/**
	 * 
	 * @param as_at
	 * @param week
	 * @param columnName
	 * @param wekOperator
	 * @param roleCategoryId
	 * @param projectId
	 *            weekOperator Enum(=, <, >, <=, >=) // later make this an enum
	 * 
	 * 
	 @return- comma delimited ticket list
	 * 
	 */
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String columnName, String weekOperator);
}
