package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiIndexThresholdDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexThreshold;
import com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiIndexThresholdService")
public class KpiIndexThresholdServiceImpl implements KpiIndexThresholdService {
	
	@Autowired
	@Qualifier("kpiIndexThresholdDao")
	private KpiIndexThresholdDao kpiIndexThresholdDao;

	/**
	 * @return the kpiIndexThresholdDao
	 */
	public KpiIndexThresholdDao getKpiIndexThresholdDao() {
		return kpiIndexThresholdDao;
	}

	/**
	 * @param kpiIndexThresholdDao the kpiIndexThresholdDao to set
	 */
	public void setKpiIndexThresholdDao(KpiIndexThresholdDao kpiIndexThresholdDao) {
		this.kpiIndexThresholdDao = kpiIndexThresholdDao;
	}	

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiThresholdService#getKpiThreshold(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiIndexThreshold getKpiIndexThreshold(Long id) {
		return getKpiIndexThresholdDao().get(id);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService#getKpiIndexThreshold(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Override
	@Transactional
	public KpiIndexThreshold getKpiIndexThreshold(KpiIndex index) {
		return getKpiIndexThresholdDao().getKpiIndexThreshold(index);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService#getKpiIndexThresholds()
	 */
	@Override
	@Transactional
	public List<KpiIndexThreshold> getKpiIndexThresholds() {
		return getKpiIndexThresholdDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService#getKpiIndexThresholds(int, int)
	 */
	@Override
	@Transactional
	public List<KpiIndexThreshold> getKpiIndexThresholds(int start, int limit) {
		return getKpiIndexThresholdDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService#saveKpiIndexThreshold(com.millenniumit.mx.data.issueman.domain.KpiIndexThreshold)
	 */
	@Override
	@Transactional
	public Long saveKpiIndexThreshold(KpiIndexThreshold threshold) {
		return getKpiIndexThresholdDao().save(threshold);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexThresholdService#deleteKpiIndexThreshold(com.millenniumit.mx.data.issueman.domain.KpiIndexThreshold)
	 */
	@Override
	@Transactional
	public void deleteKpiIndexThreshold(KpiIndexThreshold threshold) {
		getKpiIndexThresholdDao().delete(threshold);
	}

	
}
