package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiScoringScheme;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiScoringSchemeService {

	
	/**
	 * 
	 * @param kpiInstance
	 * @return
	 */
	public KpiScoringScheme getScoringScheme(long instanceId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiScoringScheme getKpiScoringScheme(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiScoringScheme> getKpiScoringSchemes();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiScoringScheme> getKpiScoringSchemes(int start, int limit);
	
	/**
	 * 
	 * @param scoringScheme
	 * @return
	 */
	public Long saveKpiScoringScheme(KpiScoringScheme scoringScheme);
	
	/**
	 * 
	 * @param scoringScheme
	 */
	public void deleteKpiScoringScheme(KpiScoringScheme scoringScheme);
	
	/**
	 * 
	 * @param kpiInstance
	 * @return
	 */
	public KpiScoringScheme getScoringScheme(KpiKpiInstance kpiInstance);
	
}
