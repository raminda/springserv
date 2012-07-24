package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiThreshold;


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
