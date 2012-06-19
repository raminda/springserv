package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiThresholdDao;
import com.millenniumit.mx.data.issueman.domain.KpiThreshold;

/**
 * 
 * @author Kalpag
 *
 */
@Repository("kpiThresholdDao")
@SuppressWarnings("unchecked")
public class KpiThresholdDaoImpl implements KpiThresholdDao {
	
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
	public KpiThreshold get(Long id) {
		return (KpiThreshold) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiThreshold where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiThreshold> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiThreshold").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiThreshold> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiThreshold")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiThreshold score) {
		getIssuemanSessionFactory().getCurrentSession().save(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return score.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiThreshold score) {
		getIssuemanSessionFactory().getCurrentSession().delete(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}

	
}
