package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiScoringSchemeDao;
import com.millenniumit.mx.data.issueman.domain.KpiScoringScheme;

/**
 * 
 * @author Kalpag
 *
 */
@Repository("kpiScoringSchemeDao")
@SuppressWarnings("unchecked")
public class KpiScoringSchemeDaoImpl implements KpiScoringSchemeDao {
	
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
	public KpiScoringScheme get(Long id) {
		return (KpiScoringScheme) getIssuemanSessionFactory().getCurrentSession()
		.createQuery("from KpiScoringScheme where id=:param")
		.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiScoringScheme> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiScoringScheme").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiScoringScheme> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiScoringScheme")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiScoringScheme score) {
		getIssuemanSessionFactory().getCurrentSession().save(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return score.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiScoringScheme score) {
		getIssuemanSessionFactory().getCurrentSession().delete(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}

	
}
