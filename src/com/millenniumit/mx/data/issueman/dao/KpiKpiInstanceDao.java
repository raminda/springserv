package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiLevel;


/**
 * 
 * @author Kalpag
 *
 */
public interface KpiKpiInstanceDao extends Dao<KpiKpiInstance> {

	/**
	 * @param index
	 * @param level
	 * @return
	 */
	public List<KpiKpiInstance> getKpiKpiInstances(KpiIndex index, KpiLevel level);
	
}
