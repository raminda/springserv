package com.millenniumit.mx.data.kpi.dao;

import com.millenniumit.mx.data.kpi.domain.KpiCategory;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiCategoryDao extends Dao<KpiCategory> {

	/**
	 * @param name
	 * @return
	 */
	public KpiCategory get(String name);
	
	
}
