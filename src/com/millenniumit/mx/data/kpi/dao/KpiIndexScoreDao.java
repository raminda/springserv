package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiIndex;
import com.millenniumit.mx.data.kpi.domain.KpiIndexScore;
import com.millenniumit.mx.data.kpi.domain.KpiLevel;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;
/**
 * 
 * @author Vimukthi
 * 
 */
public interface KpiIndexScoreDao extends Dao<KpiIndexScore> {

	/**
	 * 
	 * @param release
	 * @param project
	 * @param level
	 * @param index
	 * @param limit
	 * @return
	 */
	public List<String> getAsAtsSorted(KpiIndex index, KpiLevel level,
			KpiProject project, KpiWatchedRelease release, int limit);

	/**
	 * 
	 * @param release
	 * @param project
	 * @param level
	 * @param index
	 * @param limit
	 * @return
	 */
	public List<String> getWeeksSorted(KpiIndex index, KpiLevel level,
			KpiProject project, KpiWatchedRelease release, int limit);

	/**
	 * @param index
	 * @param project
	 * @param release
	 * @param currentWeek
	 * @param lastCalculatedWeek
	 * @return
	 */
	public KpiIndexScore getKpiScore(KpiIndex index, KpiLevel level,
			KpiProject project, KpiWatchedRelease release, String asAt,
			String week);

	/**
	 * @param index
	 * @param project
	 * @param release
	 * @param asAt
	 * @param lastCalculatedWeeks
	 * @return
	 */
	public List<KpiIndexScore> getKpiScores(KpiIndex index, KpiLevel level,
			KpiProject project, KpiWatchedRelease release, String asAt,
			List<String> weeks);

}
