/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;

/**
 * 
 * @author Kalpag
 *
 */
public interface IssuemanProjectDao {
	
	/**
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
