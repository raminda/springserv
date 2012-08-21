package com.millenniumit.mx.data.kpi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.kpi.dao.KpiCategoryDao;
import com.millenniumit.mx.data.kpi.domain.KpiCategory;
import com.millenniumit.mx.data.kpi.service.KpiCategoryService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiCategoryService")
public class KpiCategoryServiceImpl implements KpiCategoryService {
	
	@Autowired
	@Qualifier("kpiCategoryDao")
	private KpiCategoryDao kpiCategoryDao;

	/**
	 * @return the kpiCategoryDao
	 */
	public KpiCategoryDao getKpiCategoryDao() {
		return kpiCategoryDao;
	}

	/**
	 * @param kpiCategoryDao the kpiCategoryDao to set
	 */
	public void setKpiCategoryDao(KpiCategoryDao kpiCategoryDao) {
		this.kpiCategoryDao = kpiCategoryDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#getKpiCategory(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiCategory getKpiCategory(Long id) {
		return getKpiCategoryDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#getKpiCategory(java.lang.String)
	 */
	@Override
	@Transactional
	public KpiCategory getKpiCategory(String name) {
		return getKpiCategoryDao().get(name);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#getKpiCategories()
	 */
	@Override
	@Transactional
	public List<KpiCategory> getKpiCategories() {
		return getKpiCategoryDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#getKpiCategories(int, int)
	 */
	@Override
	@Transactional
	public List<KpiCategory> getKpiCategories(int start, int limit) {
		return getKpiCategoryDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#saveKpiCategory(com.millenniumit.mx.data.issueman.domain.KpiCategory)
	 */
	@Override
	@Transactional
	public Long saveKpiCategory(KpiCategory category) {
		return getKpiCategoryDao().save(category);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiCategoryService#deleteKpiCategory(com.millenniumit.mx.data.issueman.domain.KpiCategory)
	 */
	@Override
	@Transactional
	public void deleteKpiCategory(KpiCategory category) {
		getKpiCategoryDao().delete(category);
	}

	
}
