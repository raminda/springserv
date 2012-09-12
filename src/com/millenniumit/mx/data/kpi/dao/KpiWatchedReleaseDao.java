/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;
/**
 * @author Vimukthi
 *
 */
public interface KpiWatchedReleaseDao {

	/**
	 * @param id
	 * @return
	 */
	public KpiWatchedRelease getWatchedRelease(Long id);

	/**
	 * @param project
	 * @param type
	 * @return
	 */
	public List<KpiWatchedRelease> getWatchedReleases(KpiProject project,
			String status);
}