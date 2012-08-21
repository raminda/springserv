package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiIndex;
import com.millenniumit.mx.data.kpi.domain.KpiIndexThreshold;
/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiIndexThresholdService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiIndexThreshold getKpiIndexThreshold(Long id);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiIndexThreshold getKpiIndexThreshold(KpiIndex index);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiIndexThreshold> getKpiIndexThresholds();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiIndexThreshold> getKpiIndexThresholds(int start, int limit);
	
	/**
	 * 
	 * @param threshold
	 * @return
	 */
	public Long saveKpiIndexThreshold(KpiIndexThreshold threshold);
	
	/**
	 * 
	 * @param threshold
	 */
	public void deleteKpiIndexThreshold(KpiIndexThreshold threshold);
}
