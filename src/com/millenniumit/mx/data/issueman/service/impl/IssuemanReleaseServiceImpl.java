package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanReleaseDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanRelease;
import com.millenniumit.mx.data.issueman.service.IssuemanReleaseService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("issuemanReleaseService")
public class IssuemanReleaseServiceImpl implements IssuemanReleaseService {
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("issuemanReleaseDao")
	private IssuemanReleaseDao releaseDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanReleaseService#getIssuemanRelease(java.lang.Long)
	 */
	@Override
	@Transactional
	public IssuemanRelease getIssuemanRelease(Long id) {
		return releaseDao.getIssuemanRelease(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanReleaseService#getIssuemanReleases()
	 */
	@Override
	@Transactional
	public List<IssuemanRelease> getIssuemanReleases() {
		return releaseDao.getIssuemanReleases(null, null);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanReleaseService#getIssuemanReleases(com.millenniumit.mx.data.issueman.domain.IssuemanProject, java.lang.String)
	 */
	@Override
	@Transactional
	public List<IssuemanRelease> getIssuemanReleases(IssuemanProject project,
			String type) {
		return releaseDao.getIssuemanReleases(project, type);
	}

	/**
	 * @return the releaseDao
	 */
	public IssuemanReleaseDao getReleaseDao() {
		return releaseDao;
	}

	/**
	 * @param releaseDao the releaseDao to set
	 */
	public void setReleaseDao(IssuemanReleaseDao releaseDao) {
		this.releaseDao = releaseDao;
	}
}
