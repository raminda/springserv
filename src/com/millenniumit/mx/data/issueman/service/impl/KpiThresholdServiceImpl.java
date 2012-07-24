package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiThresholdDao;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiThreshold;
import com.millenniumit.mx.data.issueman.service.KpiThresholdService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiThresholdService")
public class KpiThresholdServiceImpl implements KpiThresholdService {
	
	@Autowired
	@Qualifier("kpiThresholdDao")
	private KpiThresholdDao kpiThresholdDao;

	/**
	 * @return the kpiThresholdDao
	 */
	public KpiThresholdDao getKpiThresholdDao() {
		return kpiThresholdDao;
	}

	/**
	 * @param kpiThresholdDao the kpiThresholdDao to set
	 */
	public void setKpiThresholdDao(KpiThresholdDao kpiThresholdDao) {
		this.kpiThresholdDao = kpiThresholdDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#getKpiThreshold(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiThreshold getKpiThreshold(Long id) {
		return getKpiThresholdDao().get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#getKpiThreshold(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Override
	@Transactional
	public KpiThreshold getKpiThreshold(KpiKpiInstance instance) {
		return getKpiThresholdDao().getKpiThreshold(instance);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#getKpiThresholds()
	 */
	@Override
	@Transactional
	public List<KpiThreshold> getKpiThresholds() {
		return getKpiThresholdDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#getKpiThresholds(int, int)
	 */
	@Override
	@Transactional
	public List<KpiThreshold> getKpiThresholds(int start, int limit) {
		return getKpiThresholdDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#saveKpiThreshold(com.millenniumit.mx.data.issueman.domain.KpiThreshold)
	 */
	@Override
	@Transactional
	public Long saveKpiThreshold(KpiThreshold threshold) {
		return getKpiThresholdDao().save(threshold);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#deleteKpiThreshold(com.millenniumit.mx.data.issueman.domain.KpiThreshold)
	 */
	@Override
	@Transactional
	public void deleteKpiThreshold(KpiThreshold threshold) {
		getKpiThresholdDao().delete(threshold);
	}	
}
