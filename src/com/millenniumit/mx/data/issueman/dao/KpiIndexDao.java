package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiIndex;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiIndexDao extends Dao<KpiIndex> {

	/**
	 * @param name
	 * @return
	 */
	public KpiIndex get(String name);

	
}
