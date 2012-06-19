package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiKpiDefinition;


/**
 * 
 * @author Kalpag
 *
 */
public interface KpiKpiDefinitionDao extends Dao<KpiKpiDefinition> {

	/**
	 * @param name
	 * @return
	 */
	public KpiKpiDefinition get(String name);
	
}
