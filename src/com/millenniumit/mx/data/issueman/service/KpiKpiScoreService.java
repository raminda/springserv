package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiKpiScore;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiKpiScoreService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiKpiScore getKpiKpiScore(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiKpiScore> getKpiKpiScores();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiKpiScore> getKpiKpiScores(int start, int limit);
	
	/**
	 * 
	 * @param score
	 * @return
	 */
	public Long saveKpiKpiScore(KpiKpiScore score);
	
	/**
	 * 
	 * @param score
	 */
	public void deleteKpiKpiScore(KpiKpiScore score);
	
}
