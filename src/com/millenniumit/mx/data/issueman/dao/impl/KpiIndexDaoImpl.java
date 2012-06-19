package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiIndexDao;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;

/**
 * 
 * @author Kalpag
 *
 */
@Repository("kpiIndexDao")
@SuppressWarnings("unchecked")
public class KpiIndexDaoImpl implements KpiIndexDao {
	
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
	public KpiIndex get(Long id) {
		return (KpiIndex) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndex where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexDao#get(java.lang.String)
	 */
	@Override
	public KpiIndex get(String name) {
		return (KpiIndex) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndex where name=:param")
				.setParameter("param", name).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiIndex> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndex").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiIndex> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndex")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiIndex index) {
		getIssuemanSessionFactory().getCurrentSession().save(index);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return index.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiIndex index) {
		getIssuemanSessionFactory().getCurrentSession().delete(index);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}
}
