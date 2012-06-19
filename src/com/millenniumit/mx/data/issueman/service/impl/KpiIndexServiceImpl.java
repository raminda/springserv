package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.KpiIndexDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.service.KpiIndexService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("kpiIndexService")
public class KpiIndexServiceImpl implements KpiIndexService {

	@Autowired
	@Qualifier("kpiIndexDao")
	private KpiIndexDao kpiIndexDao;

	/**
	 * @return the kpiIndexDao
	 */
	public KpiIndexDao getKpiIndexDao() {
		return kpiIndexDao;
	}

	/**
	 * @param kpiIndexDao the kpiIndexDao to set
	 */
	public void setKpiIndexDao(KpiIndexDao kpiIndexDao) {
		this.kpiIndexDao = kpiIndexDao;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#getKpiIndex(java.lang.Long)
	 */
	@Override
	@Transactional
	public KpiIndex getKpiIndex(Long id) {
		return getKpiIndexDao().get(id);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#getKpiIndex(java.lang.String)
	 */
	@Override
	@Transactional
	public KpiIndex getKpiIndex(String name) {
		return getKpiIndexDao().get(name);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#getKpiIndexes()
	 */
	@Override
	@Transactional
	public List<KpiIndex> getKpiIndexes() {
		return getKpiIndexDao().getAll();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#getKpiIndexes(int, int)
	 */
	@Override
	@Transactional
	public List<KpiIndex> getKpiIndexes(int start, int limit) {
		return getKpiIndexDao().getAll(start, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#saveKpiIndex(com.millenniumit.mx.data.issueman.domain.KpiIndex)
	 */
	@Override
	@Transactional
	public Long saveKpiIndex(KpiIndex index) {
		return getKpiIndexDao().save(index);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.KpiIndexService#deleteKpiIndex(com.millenniumit.mx.data.issueman.domain.KpiIndex)
	 */
	@Override
	@Transactional
	public void deleteKpiIndex(KpiIndex index) {
		getKpiIndexDao().delete(index);		
	}
}
