package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiThreshold;



/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiThresholdService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiThreshold getKpiThreshold(Long id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiThreshold getKpiThreshold(KpiKpiInstance instance);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiThreshold> getKpiThresholds();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiThreshold> getKpiThresholds(int start, int limit);
	
	/**
	 * 
	 * @param threshold
	 * @return
	 */
	public Long saveKpiThreshold(KpiThreshold threshold);
	
	/**
	 * 
	 * @param threshold
	 */
	public void deleteKpiThreshold(KpiThreshold threshold);
}
