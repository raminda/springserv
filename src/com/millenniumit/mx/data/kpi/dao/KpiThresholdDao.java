package com.millenniumit.mx.data.kpi.dao;

import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiThreshold;

/**
 * 
 * @author Kalpag
 *
 */
public interface KpiThresholdDao extends Dao<KpiThreshold> {

	/**
	 * @param instance
	 * @return
	 */
	public KpiThreshold getKpiThreshold(KpiKpiInstance instance);
	
}
