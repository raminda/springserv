package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao;
import com.millenniumit.mx.data.issueman.domain.KpiKpiScore;
import com.millenniumit.mx.data.issueman.service.KpiKpiScoreService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiKpiScoreService")
public class KpiKpiScoreServiceImpl implements KpiKpiScoreService {

	@Autowired
	@Qualifier("kpiKpiScoreDao")
	private KpiKpiScoreDao kpiKpiScoreDao;

	/**
	 * @return the kpiKpiScoreDao
	 */
	public KpiKpiScoreDao getKpiKpiScoreDao() {
		return kpiKpiScoreDao;
	}

	/**
	 * @param kpiKpiScoreDao the kpiKpiScoreDao to set
	 */
	public void setKpiKpiScoreDao(KpiKpiScoreDao kpiKpiScoreDao) {
		this.kpiKpiScoreDao = kpiKpiScoreDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScore(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiKpiScore getKpiKpiScore(Long id) {
		return getKpiKpiScoreDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScores()
	 */
	@Override
	@Transactional
	public List<KpiKpiScore> getKpiKpiScores() {
		return getKpiKpiScoreDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#getKpiKpiScores(int, int)
	 */
	@Override
	@Transactional
	public List<KpiKpiScore> getKpiKpiScores(int start, int limit) {
		return getKpiKpiScoreDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#saveKpiKpiScore(com.millenniumit.mx.data.issueman.domain.KpiKpiScore)
	 */
	@Override
	@Transactional
	public Long saveKpiKpiScore(KpiKpiScore score) {
		return getKpiKpiScoreDao().save(score);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiScoreService#deleteKpiKpiScore(com.millenniumit.mx.data.issueman.domain.KpiKpiScore)
	 */
	@Override
	@Transactional
	public void deleteKpiKpiScore(KpiKpiScore score) {
		getKpiKpiScoreDao().delete(score);
	}
}
