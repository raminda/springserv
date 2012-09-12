package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiKpiScore;

/**
 * 
 * @author kalpag
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
			KpiProject project, KpiWatchedRelease release, int limit);

	/**
	 * 
	 * @param release
	 * @param project
	 * @param instance
	 * @param limit
	 * @return
	 */
	public List<String> getWeeksSorted(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release, int limit);

	/**
	 * @param instance
	 * @param project
	 * @param release
	 * @param currentWeek
	 * @param lastCalculatedWeek
	 * @return
	 */
	public KpiKpiScore getKpiScore(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release, String asAt,
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
			KpiProject project, KpiWatchedRelease release, String asAt,
			List<String> lastCalculatedWeeks);

}
