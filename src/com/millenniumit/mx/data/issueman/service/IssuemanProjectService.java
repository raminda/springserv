/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;

/**
 * 
 * @author kalpag
 *
 */
public interface IssuemanProjectService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public IssuemanProject getIssuemanProject(Long id);

	/**
	 * 
	 * @return
	 */
	public List<IssuemanProject> getIssuemanProjects();
}
