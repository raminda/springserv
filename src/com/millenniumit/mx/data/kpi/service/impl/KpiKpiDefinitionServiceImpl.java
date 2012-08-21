package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.KpiKpiDefinitionDao;
import com.millenniumit.mx.data.kpi.domain.KpiKpiDefinition;
import com.millenniumit.mx.data.kpi.service.KpiKpiDefinitionService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiKpiDefinitionService")
public class KpiKpiDefinitionServiceImpl implements KpiKpiDefinitionService {
	
	@Autowired
	@Qualifier("kpiKpiDefinitionDao")
	private KpiKpiDefinitionDao kpiKpiDefinitionDao;

	/**
	 * @return the kpiKpiDefinitionDao
	 */
	public KpiKpiDefinitionDao getKpiKpiDefinitionDao() {
		return kpiKpiDefinitionDao;
	}

	/**
	 * @param kpiKpiDefinitionDao the kpiKpiDefinitionDao to set
	 */
	public void setKpiKpiDefinitionDao(KpiKpiDefinitionDao kpiKpiDefinitionDao) {
		this.kpiKpiDefinitionDao = kpiKpiDefinitionDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#getKpiKpiDefinition(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiKpiDefinition getKpiKpiDefinition(Long id) {
		return getKpiKpiDefinitionDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#getKpiKpiDefinition(java.lang.String)
	 */
	@Override
	@Transactional
	public KpiKpiDefinition getKpiKpiDefinition(String name) {
		return getKpiKpiDefinitionDao().get(name);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#getKpiKpiDefinitions()
	 */
	@Override
	@Transactional
	public List<KpiKpiDefinition> getKpiKpiDefinitions() {
		return getKpiKpiDefinitionDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#getKpiKpiDefinitions(int, int)
	 */
	@Override
	@Transactional
	public List<KpiKpiDefinition> getKpiKpiDefinitions(int start, int limit) {
		return getKpiKpiDefinitionDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#saveKpiKpiDefinition(com.millenniumit.mx.data.issueman.domain.KpiKpiDefinition)
	 */
	@Override
	@Transactional
	public Long saveKpiKpiDefinition(KpiKpiDefinition definition) {
		return getKpiKpiDefinitionDao().save(definition);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService#deleteKpiKpiDefinition(com.millenniumit.mx.data.issueman.domain.KpiKpiDefinition)
	 */
	@Override
	@Transactional
	public void deleteKpiKpiDefinition(KpiKpiDefinition definition) {
		getKpiKpiDefinitionDao().delete(definition);		
	}

}
