package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiCategory;



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
