package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiIndexThresholdDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexThreshold;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiIndexThresholdDao")
@SuppressWarnings("unchecked")
public class KpiIndexThresholdDaoImpl implements KpiIndexThresholdDao {
	
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
	public KpiIndexThreshold get(Long id) {
		return (KpiIndexThreshold) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndexThreshold where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexThresholdDao#getKpiIndexThreshold(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance)
	 */
	@Override
	public KpiIndexThreshold getKpiIndexThreshold(KpiIndex index) {
		return (KpiIndexThreshold) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndexThreshold where index=:index")
				.setParameter("index", index).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiIndexThreshold> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexThreshold").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiIndexThreshold> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexThreshold")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiIndexThreshold threshold) {
		getIssuemanSessionFactory().getCurrentSession().save(threshold);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return threshold.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiIndexThreshold threshold) {
		getIssuemanSessionFactory().getCurrentSession().delete(threshold);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}	
}
