/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanRoleDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanRole;
import com.millenniumit.mx.data.issueman.service.IssuemanRoleService;

/**
 * @author kalpag
 * 
 */
@Service("issuemanRoleService")
public class IssuemanRoleServiceImpl implements IssuemanRoleService {

	@Autowired
	@Qualifier("issuemanRoleDao")
	private IssuemanRoleDao issuemanRoleDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanRoleService#
	 * getIssuemanRoles()
	 */
	@Transactional
	public List<IssuemanRole> getIssuemanRoles() {
		return issuemanRoleDao.getIssuemanRoles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.IssuemanRoleService#getEqaRoles
	 * ()
	 */
	@Transactional
	public List<IssuemanRole> getEqaRoles() {
		return issuemanRoleDao.getEqaRoles();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanRoleService#getEqaRoleNames()
	 */
	@Transactional
	public List<String> getEqaRoleNames() {
		return issuemanRoleDao.getEqaRoleNames();
	}
}
