package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;
import com.millenniumit.mx.data.issueman.domain.KpiLevel;
import com.millenniumit.mx.data.issueman.service.KpiIndexScoreService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiIndexScoreService")
public class KpiIndexScoreServiceImpl implements KpiIndexScoreService {
	
	@Autowired
	@Qualifier("kpiIndexScoreDao")
	private KpiIndexScoreDao kpiIndexScoreDao;
	
	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(KpiIndexScoreServiceImpl.class);

	/**
	 * @return the kpiIndexScoreDao
	 */
	public KpiIndexScoreDao getKpiIndexScoreDao() {
		return kpiIndexScoreDao;
	}

	/**
	 * @param kpiIndexScoreDao the kpiIndexScoreDao to set
	 */
	public void setKpiIndexScoreDao(KpiIndexScoreDao kpiIndexScoreDao) {
		this.kpiIndexScoreDao = kpiIndexScoreDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getKpiIndexScore(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiIndexScore getKpiIndexScore(Long id) {
		return getKpiIndexScoreDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getKpiIndexScores()
	 */
	@Override
	@Transactional
	public List<KpiIndexScore> getKpiIndexScores() {
		return getKpiIndexScoreDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getKpiIndexScores(int, int)
	 */
	@Override
	@Transactional
	public List<KpiIndexScore> getKpiIndexScores(int start, int limit) {
		return getKpiIndexScoreDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#saveKpiIndexScore(com.millenniumit.mx.data.issueman.domain.KpiIndexScore)
	 */
	@Override
	@Transactional
	public Long saveKpiIndexScore(KpiIndexScore score) {
		return getKpiIndexScoreDao().save(score);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#deleteKpiIndexScore(com.millenniumit.mx.data.issueman.domain.KpiIndexScore)
	 */
	@Override
	@Transactional
	public void deleteKpiIndexScore(KpiIndexScore score) {
		getKpiIndexScoreDao().delete(score);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getCurrentKpiIndexScore(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.KpiLevel, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease)
	 */
	@Override
	@Transactional
	public KpiIndexScore getCurrentKpiIndexScore(KpiIndex index,
			KpiLevel level, IssuemanProject project, KpiWatchedRelease release) {
		String currentWeek = "";
		String lastCalculatedWeek = "";
		try {
			currentWeek = getKpiIndexScoreDao().getAsAtsSorted(index, level, 
				project, release, 1).get(0);
			lastCalculatedWeek = getKpiIndexScoreDao().getWeeksSorted(index, level, 
				project, release, 1).get(0);
			return getKpiIndexScoreDao().getKpiScore(index, level, project, 
					release, currentWeek, lastCalculatedWeek);
		} catch (IndexOutOfBoundsException e) {
			logger.error(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getPreviousKpiIndexScore(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.KpiLevel, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease)
	 */
	@Override
	@Transactional
	public KpiIndexScore getPreviousKpiIndexScore(KpiIndex index, 
			KpiLevel level, IssuemanProject project, KpiWatchedRelease release) {
		String currentWeek = "";
		String weekBeforeLastCalculatedWeek = "";
		try {
			currentWeek = getKpiIndexScoreDao().getAsAtsSorted(index, level, 
				project, release, 1).get(0);
			weekBeforeLastCalculatedWeek = getKpiIndexScoreDao().getWeeksSorted(index, level, 
				project, release, 2).get(1);
			return getKpiIndexScoreDao().getKpiScore(index, level, project, 
				release, currentWeek, weekBeforeLastCalculatedWeek);
		} catch (IndexOutOfBoundsException e) {
			logger.error(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexScoreService#getKpiIndexScores(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.KpiLevel, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, java.lang.String, int)
	 */
	@Override
	@Transactional
	public List<KpiIndexScore> getKpiIndexScores(KpiIndex index,
			KpiLevel level, IssuemanProject project, KpiWatchedRelease release,
			String asAt, int weekLimit) {
		List<String> lastCalculatedWeeks = getKpiIndexScoreDao().getWeeksSorted(index, level, 
				project, release, weekLimit);
		if (lastCalculatedWeeks.isEmpty()){
			return null;
		} else {
			return getKpiIndexScoreDao().getKpiScores(index, level, 
					project, release, asAt, lastCalculatedWeeks);
		}
	}

}
