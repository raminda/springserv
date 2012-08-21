package com.millenniumit.mx.data.kpi.dao.impl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.KpiLevelDao;
import com.millenniumit.mx.data.kpi.domain.KpiLevel;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiLevelDao")
@SuppressWarnings("unchecked")
public class KpiLevelDaoImpl implements KpiLevelDao {
	
	@Autowired
	@Qualifier("kpiSessionFactory")
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
	public KpiLevel get(Long id) {
		return (KpiLevel) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiLevel where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiLevelDao#get(java.lang.String)
	 */
	@Override
	public KpiLevel get(String name) {
		return (KpiLevel) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiLevel where name=:param")
				.setParameter("param", name).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiLevel> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiLevel").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiLevel> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiLevel")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiLevel level) {
		getIssuemanSessionFactory().getCurrentSession().save(level);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return level.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiLevel level) {
		getIssuemanSessionFactory().getCurrentSession().delete(level);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}
}
