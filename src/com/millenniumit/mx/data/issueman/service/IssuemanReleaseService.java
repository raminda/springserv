/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanRelease;

/**
 * @author Vimukthi
 *
 */
public interface IssuemanReleaseService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public IssuemanRelease getIssuemanRelease(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<IssuemanRelease> getIssuemanReleases();
	
	/**
	 * 
	 * @param project
	 * @param type
	 * @return
	 */
	public List<IssuemanRelease> getIssuemanReleases(IssuemanProject project, String type);
}
