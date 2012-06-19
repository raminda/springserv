package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiKpiInstanceDao;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;

/**
 * 
 * @author Kalpag
 *
 */
@Repository("kpiKpiInstanceDao")
@SuppressWarnings("unchecked")
public class KpiKpiInstanceDaoImpl implements KpiKpiInstanceDao {
	
	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/**
	 * @return the issuemanSessionFactory
	 */
	public SessionFactory getIssuemanSessionFactory() {
		return issuemanSessionFactory;
	}

	/**
	 * @param issuemanSessionFactory the issuemanSessionFactory to set
	 */
	public void setIssuemanSessionFactory(SessionFactory issuemanSessionFactory) {
		this.issuemanSessionFactory = issuemanSessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#get(java.lang.Long)
	 */
	@Override
	public KpiKpiInstance get(Long id) {
		return (KpiKpiInstance) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiKpiInstance where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiKpiInstance> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiInstance").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiKpiInstance> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiInstance")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiKpiInstance instance) {
		getIssuemanSessionFactory().getCurrentSession().save(instance);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return instance.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiKpiInstance instance) {
		getIssuemanSessionFactory().getCurrentSession().delete(instance);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}


}
