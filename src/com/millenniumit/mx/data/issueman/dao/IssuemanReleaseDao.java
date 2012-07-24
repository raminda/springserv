/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanRelease;

/**
 * @author Vimukthi
 *
 */
public interface IssuemanReleaseDao {

	/**
	 * @param project
	 * @param type
	 * @return
	 */
	public List<IssuemanRelease> getIssuemanReleases(IssuemanProject project,
			String type);

	/**
	 * @param id
	 * @return
	 */
	public IssuemanRelease getIssuemanRelease(Long id);

}
