/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

/**
 * @author kalpag
 *
 */
public interface MetricService {

	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String tableName, String columnName, String weekOperator);
	
}
