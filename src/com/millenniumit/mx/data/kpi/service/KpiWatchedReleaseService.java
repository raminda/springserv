/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.IssuemanProject;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;

/**
 * @author Vimukthi
 *
 */
public interface KpiWatchedReleaseService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiWatchedRelease getWatchedRelease(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiWatchedRelease> getWatchedReleases();
	
	/**
	 * 
	 * @param project
	 * @param type
	 * @return
	 */
	public List<KpiWatchedRelease> getWatchedReleases(IssuemanProject project, String status);
}
