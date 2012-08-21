package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiIndex;
import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiLevel;

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
