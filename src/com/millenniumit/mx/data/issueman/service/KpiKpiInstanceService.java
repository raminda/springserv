package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiLevel;


/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiKpiInstanceService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiKpiInstance getKpiKpiInstance(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiKpiInstance> getKpiKpiInstances();
	
	/**
	 * 
	 * @return
	 */
	public List<KpiKpiInstance> getKpiKpiInstances(KpiIndex index, KpiLevel level);
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiKpiInstance> getKpiKpiInstances(int start, int limit);
	
	/**
	 * 
	 * @param instance
	 * @return
	 */
	public Long saveKpiKpiInstance(KpiKpiInstance instance);
	
	/**
	 * 
	 * @param instance
	 */
	public void deleteKpiKpiInstance(KpiKpiInstance instance);

	
}