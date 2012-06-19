package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;



/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiIndexScoreService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiIndexScore getKpiIndexScore(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiIndexScore> getKpiIndexScores();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiIndexScore> getKpiIndexScores(int start, int limit);
	
	/**
	 * 
	 * @param score
	 * @return
	 */
	public Long saveKpiIndexScore(KpiIndexScore score);
	
	/**
	 * 
	 * @param score
	 */
	public void deleteKpiIndexScore(KpiIndexScore score);
	
}
