package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiWatchedReleaseDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.service.KpiWatchedReleaseService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiWatchedReleaseService")
public class KpiWatchedReleaseServiceImpl implements KpiWatchedReleaseService {
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("kpiWatchedReleaseDao")
	private KpiWatchedReleaseDao releaseDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiWatchedReleaseService#getKpiWatchedRelease(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiWatchedRelease getWatchedRelease(Long id) {
		return releaseDao.getWatchedRelease(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiWatchedReleaseService#getKpiWatchedReleases()
	 */
	@Override
	@Transactional
	public List<KpiWatchedRelease> getWatchedReleases() {
		return releaseDao.getWatchedReleases(null, null);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiWatchedReleaseService#getKpiWatchedReleases(com.millenniumit.mx.data.issueman.domain.IssuemanProject, java.lang.String)
	 */
	@Override
	@Transactional
	public List<KpiWatchedRelease> getWatchedReleases(IssuemanProject project,
			String status) {
		return releaseDao.getWatchedReleases(project, status);
	}

	/**
	 * @return the releaseDao
	 */
	public KpiWatchedReleaseDao getReleaseDao() {
		return releaseDao;
	}

	/**
	 * @param releaseDao the releaseDao to set
	 */
	public void setReleaseDao(KpiWatchedReleaseDao releaseDao) {
		this.releaseDao = releaseDao;
	}
}