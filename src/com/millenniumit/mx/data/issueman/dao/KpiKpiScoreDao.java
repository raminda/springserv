package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiKpiScore;

/**
 * 
 * @author Vimukthi
 * 
 */
public interface KpiKpiScoreDao extends Dao<KpiKpiScore> {

	/**
	 * 
	 * @param release
	 * @param project
	 * @param instance
	 * @param limit
	 * @return
	 */
	public List<String> getAsAtsSorted(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, int limit);

	/**
	 * 
	 * @param release
	 * @param project
	 * @param instance
	 * @param limit
	 * @return
	 */
	public List<String> getWeeksSorted(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, int limit);

	/**
	 * @param instance
	 * @param project
	 * @param release
	 * @param currentWeek
	 * @param lastCalculatedWeek
	 * @return
	 */
	public KpiKpiScore getKpiScore(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, String asAt,
			String week);

	/**
	 * @param instance
	 * @param project
	 * @param release
	 * @param asAt
	 * @param lastCalculatedWeeks
	 * @return
	 */
	public List<KpiKpiScore> getKpiScores(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, String asAt,
			List<String> lastCalculatedWeeks);

}
