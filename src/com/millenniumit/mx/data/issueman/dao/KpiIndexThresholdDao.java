package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexThreshold;


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
