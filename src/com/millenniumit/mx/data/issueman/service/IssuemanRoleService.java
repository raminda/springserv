/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanRole;

/**
 * @author kalpag
 *
 */
public interface IssuemanRoleService {

	/**
	 * 
	 * @return
	 */
	public List<IssuemanRole> getIssuemanRoles();

	/**
	 * 
	 * @return
	 */
	public List<IssuemanRole> getEqaRoles();
	
	/**
	 * 
	 * @return
	 */
	public List<String> getEqaRoleNames();
}
