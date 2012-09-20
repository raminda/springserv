/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

/**
 * @author kalpag
 * 
 */
public interface MetricService {

	public String getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, String tableName, String columnName, String weekOperator);

}
