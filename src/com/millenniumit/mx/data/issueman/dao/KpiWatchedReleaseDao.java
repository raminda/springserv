/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;

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
	public List<KpiWatchedRelease> getWatchedReleases(IssuemanProject project,
			String status);
}
