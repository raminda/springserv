package com.millenniumit.mx.data.kpi.dao;

import com.millenniumit.mx.data.kpi.domain.KpiIndex;
import com.millenniumit.mx.data.kpi.domain.KpiIndexThreshold;
/**
 * 
 * @author Kalpag
 *
 */
public interface KpiIndexThresholdDao extends Dao<KpiIndexThreshold> {

	/**
	 * @param instance
	 * @return
	 */
	public KpiIndexThreshold getKpiIndexThreshold(KpiIndex index);
	
}
