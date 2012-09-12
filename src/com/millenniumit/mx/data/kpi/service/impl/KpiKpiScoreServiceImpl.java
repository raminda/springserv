package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.KpiKpiScoreDao;
import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiKpiScore;
import com.millenniumit.mx.data.kpi.service.KpiKpiScoreService;

/**
 * 
 * @author Vimukthi
 * 
 */
@Service("kpiKpiScoreService")
public class KpiKpiScoreServiceImpl implements KpiKpiScoreService {

	/**
	 * 
	 */
	@Autowired
	@Qualifier("kpiKpiScoreDao")
	private KpiKpiScoreDao kpiKpiScoreDao;

	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(KpiKpiScoreServiceImpl.class);

	/**
	 * @return the kpiKpiScoreDao
	 */
	public KpiKpiScoreDao getKpiKpiScoreDao() {
		return kpiKpiScoreDao;
	}

	/**
	 * @param kpiKpiScoreDao
	 *            the kpiKpiScoreDao to set
	 */
	public void setKpiKpiScoreDao(KpiKpiScoreDao kpiKpiScoreDao) {
		this.kpiKpiScoreDao = kpiKpiScoreDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScore
	 * (java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiKpiScore getKpiKpiScore(Long id) {
		return getKpiKpiScoreDao().get(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScores
	 * ()
	 */
	@Override
	@Transactional
	public List<KpiKpiScore> getKpiKpiScores() {
		return getKpiKpiScoreDao().getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScores
	 * (int, int)
	 */
	@Override
	@Transactional
	public List<KpiKpiScore> getKpiKpiScores(int start, int limit) {
		return getKpiKpiScoreDao().getAll(start, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#saveKpiKpiScore
	 * (com.millenniumit.mx.data.issueman.domain.KpiKpiScore)
	 */
	@Override
	@Transactional
	public Long saveKpiKpiScore(KpiKpiScore score) {
		return getKpiKpiScoreDao().save(score);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#
	 * deleteKpiKpiScore(com.millenniumit.mx.data.issueman.domain.KpiKpiScore)
	 */
	@Override
	@Transactional
	public void deleteKpiKpiScore(KpiKpiScore score) {
		getKpiKpiScoreDao().delete(score);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#
	 * getCurrentKpiScore
	 * (com.millenniumit.mx.data.issueman.domain.KpiKpiInstance,
	 * com.millenniumit.mx.data.issueman.domain.KpiProject,
	 * com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease)
	 */
	@Override
	@Transactional
	public KpiKpiScore getCurrentKpiScore(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release) {
		String currentWeek = "";
		String lastCalculatedWeek = "";
		try {
			currentWeek = getKpiKpiScoreDao().getAsAtsSorted(instance, project,
					release, 1).get(0);
			lastCalculatedWeek = getKpiKpiScoreDao().getWeeksSorted(instance,
					project, release, 1).get(0);
			return getKpiKpiScoreDao().getKpiScore(instance, project, release,
					currentWeek, lastCalculatedWeek);
		} catch (IndexOutOfBoundsException e) {
			logger.error(e);
		}
		logger.debug(lastCalculatedWeek);
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#
	 * getPreviousKpiScore
	 * (com.millenniumit.mx.data.issueman.domain.KpiKpiInstance,
	 * com.millenniumit.mx.data.issueman.domain.KpiProject,
	 * com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease)
	 */
	@Override
	@Transactional
	public KpiKpiScore getPreviousKpiScore(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release) {
		logger.debug("Starting transaction");
		String currentWeek = "";
		String lastCalculatedWeek = "";
		try {
			currentWeek = getKpiKpiScoreDao().getAsAtsSorted(instance, project,
					release, 1).get(0);
			lastCalculatedWeek = getKpiKpiScoreDao().getWeeksSorted(instance,
					project, release, 2).get(1);
			return getKpiKpiScoreDao().getKpiScore(instance, project, release,
					currentWeek, lastCalculatedWeek);
		} catch (IndexOutOfBoundsException e) {
			logger.error(e);
		}
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiScores
	 * (com.millenniumit.mx.data.issueman.domain.KpiKpiInstance,
	 * com.millenniumit.mx.data.issueman.domain.KpiProject,
	 * com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, int)
	 */
	@Override
	@Transactional
	public List<KpiKpiScore> getKpiScores(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release, String asAt,
			int weekLimit) {
		List<String> lastCalculatedWeeks = getKpiKpiScoreDao().getWeeksSorted(
				instance, project, release, weekLimit);
		if (lastCalculatedWeeks.isEmpty()) {
			return null;
		} else {
			return getKpiKpiScoreDao().getKpiScores(instance, project, release,
					asAt, lastCalculatedWeeks);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#
	 * getWeeksAvailable()
	 */
	@Override
	public List<String> getWeeksAvailable(KpiKpiInstance instance,
			KpiProject project, KpiWatchedRelease release, int limit) {
		return getKpiKpiScoreDao().getAsAtsSorted(instance, project, release,
				limit);
	}
}
