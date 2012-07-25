package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiScoringSchemeDao;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiScoringScheme;
import com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiScoringSchemeService")
public class KpiScoringSchemeServiceImpl implements KpiScoringSchemeService {

	@Autowired
	@Qualifier("kpiScoringSchemeDao")
	private KpiScoringSchemeDao kpiScoringSchemeDao;

	/**
	 * @return the kpiScoringSchemeDao
	 */
	public KpiScoringSchemeDao getKpiScoringSchemeDao() {
		return kpiScoringSchemeDao;
	}

	/**
	 * @param kpiScoringSchemeDao the kpiScoringSchemeDao to set
	 */
	public void setKpiScoringSchemeDao(KpiScoringSchemeDao kpiScoringSchemeDao) {
		this.kpiScoringSchemeDao = kpiScoringSchemeDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#getKpiScoringScheme(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiScoringScheme getKpiScoringScheme(Long id) {
		return getKpiScoringSchemeDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#getKpiScoringSchemes()
	 */
	@Override
	@Transactional
	public List<KpiScoringScheme> getKpiScoringSchemes() {
		return getKpiScoringSchemeDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#getKpiScoringSchemes(int, int)
	 */
	@Override
	@Transactional
	public List<KpiScoringScheme> getKpiScoringSchemes(int start, int limit) {
		return getKpiScoringSchemeDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#saveKpiScoringScheme(com.millenniumit.mx.data.issueman.domain.KpiScoringScheme)
	 */
	@Override
	@Transactional
	public Long saveKpiScoringScheme(KpiScoringScheme scoringScheme) {
		return getKpiScoringSchemeDao().save(scoringScheme);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#deleteKpiScoringScheme(com.millenniumit.mx.data.issueman.domain.KpiScoringScheme)
	 */
	@Override
	@Transactional
	public void deleteKpiScoringScheme(KpiScoringScheme scoringScheme) {
		getKpiScoringSchemeDao().delete(scoringScheme);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#getScoringScheme(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Transactional
	public KpiScoringScheme getScoringScheme(long instanceId) {
		 return	getKpiScoringSchemeDao().getScoringScheme(instanceId);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService#getScoringScheme(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Transactional
	public KpiScoringScheme getScoringScheme(KpiKpiInstance kpiInstance) {
		return getKpiScoringSchemeDao().getScoringScheme(kpiInstance);
	}
}
