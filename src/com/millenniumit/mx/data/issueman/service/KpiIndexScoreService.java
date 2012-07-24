package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;
import com.millenniumit.mx.data.issueman.domain.KpiLevel;



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
	 * @param index
	 * @param level
	 * @param project
	 * @param release
	 * @return
	 */
	public KpiIndexScore getCurrentKpiIndexScore(KpiIndex index, KpiLevel level, 
			IssuemanProject project, KpiWatchedRelease release);
	
	/**
	 * 
	 * @param index
	 * @param level
	 * @param project
	 * @param release
	 * @return
	 */
	public KpiIndexScore getPreviousKpiIndexScore(KpiIndex index, KpiLevel level, 
			IssuemanProject project, KpiWatchedRelease release);
	
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
	 * @param index
	 * @param level
	 * @param project
	 * @param release
	 * @param asAt
	 * @param weekLimit
	 * @return
	 */
	public List<KpiIndexScore> getKpiIndexScores(KpiIndex index, KpiLevel level, 
			IssuemanProject project, KpiWatchedRelease release, String asAt, int weekLimit);
	
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
