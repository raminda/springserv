package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiKpiInstanceDao;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiKpiInstanceService")
public class KpiKpiInstanceServiceImpl implements KpiKpiInstanceService {

	@Autowired
	@Qualifier("kpiKpiInstanceDao")
	private KpiKpiInstanceDao kpiKpiInstanceDao;

	/**
	 * @return the kpiKpiInstanceDao
	 */
	public KpiKpiInstanceDao getKpiKpiInstanceDao() {
		return kpiKpiInstanceDao;
	}

	/**
	 * @param kpiKpiInstanceDao the kpiKpiInstanceDao to set
	 */
	public void setKpiKpiInstanceDao(KpiKpiInstanceDao kpiKpiInstanceDao) {
		this.kpiKpiInstanceDao = kpiKpiInstanceDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService#getKpiKpiInstance(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiKpiInstance getKpiKpiInstance(Long id) {
		return getKpiKpiInstanceDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService#getKpiKpiInstances()
	 */
	@Override
	@Transactional
	public List<KpiKpiInstance> getKpiKpiInstances() {
		return getKpiKpiInstanceDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService#getKpiKpiInstances(int, int)
	 */
	@Override
	@Transactional
	public List<KpiKpiInstance> getKpiKpiInstances(int start, int limit) {
		return getKpiKpiInstanceDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService#saveKpiKpiInstance(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Override
	@Transactional
	public Long saveKpiKpiInstance(KpiKpiInstance instance) {
		return getKpiKpiInstanceDao().save(instance);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService#deleteKpiKpiInstance(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Override
	@Transactional
	public void deleteKpiKpiInstance(KpiKpiInstance instance) {
		getKpiKpiInstanceDao().delete(instance);
	}
}
