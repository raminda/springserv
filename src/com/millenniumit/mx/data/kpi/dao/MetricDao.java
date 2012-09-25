/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao;

import java.util.List;
import java.util.Map;

/**
 * @author kalpag
 * 
 *         this is a common inteface to all the metric tables
 * 
 */

public interface MetricDao {

	/**
	 * 
	 * @param as_at
	 * @param week
	 * @param projectId
	 * @param watchedReleaseId
	 * @param roleCategoryId
	 * @param tableName
	 * @param columnName
	 * @param weekOperator
	 * @return
	 */
	public List<String> getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, String tableName, String columnName, String weekOperator);
	
	public List<String> getSourceTickets(long as_at, long week, long projectId, long watchedReleaseId,
			long roleCategoryId, Map<String, String> tablecolumns, String weekOperator);
	

}
