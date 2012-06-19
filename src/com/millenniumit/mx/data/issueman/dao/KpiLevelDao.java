package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiLevel;



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
