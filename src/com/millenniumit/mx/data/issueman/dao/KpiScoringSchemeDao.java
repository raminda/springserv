package com.millenniumit.mx.data.issueman.dao;

import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiScoringScheme;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiScoringSchemeDao extends Dao<KpiScoringScheme> {
	
	public KpiScoringScheme getKpiScoringScheme(Long id);
	public KpiScoringScheme getScoringScheme(long instanceId);
	public Long save(KpiScoringScheme score);
	public void delete(KpiScoringScheme score);
	public KpiScoringScheme getScoringScheme(KpiKpiInstance kpiInstance);
	
}
