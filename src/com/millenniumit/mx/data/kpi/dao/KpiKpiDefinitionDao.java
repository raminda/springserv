package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiKpiDefinition;


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
	public List<KpiKpiDefinition> getAll();
	public List<KpiKpiDefinition> getAll(int start, int limit);
	public Long save(KpiKpiDefinition definition);
	public void delete(KpiKpiDefinition definition) ;
	
	
}
