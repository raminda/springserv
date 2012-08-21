package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.KpiLevelDao;
import com.millenniumit.mx.data.kpi.domain.KpiLevel;
import com.millenniumit.mx.data.kpi.service.KpiLevelService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiLevelService")
public class KpiLevelServiceImpl implements KpiLevelService {
	
	@Autowired
	@Qualifier("kpiLevelDao")
	private KpiLevelDao kpiLevelDao;

	/**
	 * @return the kpiLevelDao
	 */
	public KpiLevelDao getKpiLevelDao() {
		return kpiLevelDao;
	}

	/**
	 * @param kpiLevelDao the kpiLevelDao to set
	 */
	public void setKpiLevelDao(KpiLevelDao kpiLevelDao) {
		this.kpiLevelDao = kpiLevelDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#getKpiLevel(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiLevel getKpiLevel(Long id) {
		return getKpiLevelDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#getKpiLevel(java.lang.String)
	 */
	@Override
	@Transactional
	public KpiLevel getKpiLevel(String name) {
		return getKpiLevelDao().get(name);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#getKpiLevels()
	 */
	@Override
	@Transactional
	public List<KpiLevel> getKpiLevels() {
		return getKpiLevelDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#getKpiLevels(int, int)
	 */
	@Override
	@Transactional
	public List<KpiLevel> getKpiLevels(int start, int limit) {
		return getKpiLevelDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#saveKpiLevel(com.millenniumit.mx.data.issueman.domain.KpiLevel)
	 */
	@Override
	@Transactional
	public Long saveKpiLevel(KpiLevel level) {
		return getKpiLevelDao().save(level);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiLevelService#deleteKpiLevel(com.millenniumit.mx.data.issueman.domain.KpiLevel)
	 */
	@Override
	@Transactional
	public void deleteKpiLevel(KpiLevel level) {
		getKpiLevelDao().delete(level);
	}
}
