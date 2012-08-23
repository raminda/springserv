package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.IssuemanProjectDao;
import com.millenniumit.mx.data.kpi.domain.IssuemanProject;
import com.millenniumit.mx.data.kpi.service.IssuemanProjectService;

/**
 * 
 * @author kalpag
 * 
 */
@Service("kpiProjectService")
public class IssuemanProjectServiceImpl implements IssuemanProjectService {

	/**
	 * 
	 */	
	@Autowired
	@Qualifier("kpiProjectDao")
	private IssuemanProjectDao issuemanProjectDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanProjectService#getIssuemanProject(java.lang.Long)
	 */
	@Override
	@Transactional
	public IssuemanProject getIssuemanProject(Long id) {
		return issuemanProjectDao.getIssuemanProject(id);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanProjectService#getIssuemanProjects()
	 */
	@Transactional
	public List<IssuemanProject> getIssuemanProjects() {
		return issuemanProjectDao.getIssuemanProjects();
	}

	/**
	 * @return the issuemanProjectDao
	 */
	public IssuemanProjectDao getIssuemanProjectDao() {
		return issuemanProjectDao;
	}

	/**
	 * @param issuemanProjectDao the issuemanProjectDao to set
	 */
	public void setIssuemanProjectDao(IssuemanProjectDao issuemanProjectDao) {
		this.issuemanProjectDao = issuemanProjectDao;
	}
}
