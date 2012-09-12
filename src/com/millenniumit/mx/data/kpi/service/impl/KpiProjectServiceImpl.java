package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.KpiProjectDao;
import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.service.KpiProjectService;

/**
 * 
 * @author kalpag
 * 
 */
@Service("kpiProjectService")
public class KpiProjectServiceImpl implements KpiProjectService {

	/**
	 * 
	 */	
	@Autowired
	@Qualifier("kpiProjectDao")
	private KpiProjectDao KpiProjectDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiProjectService#getKpiProject(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiProject getKpiProject(Long id) {
		return KpiProjectDao.getKpiProject(id);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiProjectService#getKpiProjects()
	 */
	@Transactional
	public List<KpiProject> getKpiProjects() {
		return KpiProjectDao.getKpiProjects();
	}

	/**
	 * @return the KpiProjectDao
	 */
	public KpiProjectDao getKpiProjectDao() {
		return KpiProjectDao;
	}

	/**
	 * @param KpiProjectDao the KpiProjectDao to set
	 */
	public void setKpiProjectDao(KpiProjectDao KpiProjectDao) {
		this.KpiProjectDao = KpiProjectDao;
	}
}
