package com.millenniumit.mx.data.kpi.dao;

import com.millenniumit.mx.data.kpi.domain.KpiLevel;


/**
 * 
 * @author Kalpag
 *
 */
public interface KpiLevelDao extends Dao<KpiLevel> {

	/**
	 * @param name
	 * @return
	 */
	public KpiLevel get(String name);
	
}
