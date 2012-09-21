/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

import java.util.Map;

/**
 * @author kalpag
 * 
 */
public interface MetricService {

	public String getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, String tableName, String columnName, String weekOperator);
	
	public String getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, Map<String, String> tablecolumns, String weekOperator);
	

}
