package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;
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

}
