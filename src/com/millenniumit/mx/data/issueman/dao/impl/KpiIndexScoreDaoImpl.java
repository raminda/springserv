package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;

/**
 * 
 * @author Kalpag
 *
 */
@Repository("kpiIndexScoreDao")
@SuppressWarnings("unchecked")
public class KpiIndexScoreDaoImpl implements KpiIndexScoreDao {
	
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
	public KpiIndexScore get(Long id) {
		return (KpiIndexScore) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndexScore where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiIndexScore> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexScore").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiIndexScore> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexScore")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiIndexScore score) {
		getIssuemanSessionFactory().getCurrentSession().save(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return score.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiIndexScore score) {
		getIssuemanSessionFactory().getCurrentSession().delete(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}

	
}
