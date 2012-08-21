package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiKpiDefinition;
/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiKpiDefinitionService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiKpiDefinition getKpiKpiDefinition(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public KpiKpiDefinition getKpiKpiDefinition(String name);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiKpiDefinition> getKpiKpiDefinitions();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiKpiDefinition> getKpiKpiDefinitions(int start, int limit);
	
	/**
	 * 
	 * @param definition
	 * @return
	 */
	public Long saveKpiKpiDefinition(KpiKpiDefinition definition);
	
	/**
	 * 
	 * @param definition
	 */
	public void deleteKpiKpiDefinition(KpiKpiDefinition definition);
	
}
