package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiKpiScore;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;


/**
 * 
 * @author Vimukthi
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
	 * @param instance
	 * @param project
	 * @param release
	 * @return
	 */
	public KpiKpiScore getCurrentKpiScore(KpiKpiInstance instance, 
			KpiProject project, KpiWatchedRelease release);
	
	/**
	 * 
	 * @param instance
	 * @param project
	 * @param release
	 * @return
	 */
	public KpiKpiScore getPreviousKpiScore(KpiKpiInstance instance, 
			KpiProject project, KpiWatchedRelease release);
	
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
	 * @param instance
	 * @param project
	 * @param release
	 * @param weekLimit
	 * @return
	 */
	public List<KpiKpiScore> getKpiScores(KpiKpiInstance instance, 
			KpiProject project, KpiWatchedRelease release, String asAt, int weekLimit);
	
	

	
	/**
	 * 
	 * @return
	 */
	public List<String> getWeeksAvailable(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release, int limit);
	
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
