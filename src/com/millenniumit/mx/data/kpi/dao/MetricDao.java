/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao;

/**
 * @author kalpag
 * 
 * this is a common inteface to all the metric tables
 *  
 */


public interface MetricDao {

	/**
	 * 
	 * @param as_at
	 * @param week
	 * @param projectId
	 * @param roleCategoryId
	 * @param tableName
	 * @param columnName
	 * @param weekOperator
	 * @return
	 */
	public String getTickets(long as_at, long week, long projectId, long roleCategoryId,
			String tableName, String columnName, String weekOperator);

}
