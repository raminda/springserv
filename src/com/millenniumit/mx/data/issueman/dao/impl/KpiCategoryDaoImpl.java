package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiCategoryDao;
import com.millenniumit.mx.data.issueman.domain.KpiCategory;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiCategoryDao")
@SuppressWarnings("unchecked")
public class KpiCategoryDaoImpl implements KpiCategoryDao {
	
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
	public KpiCategory get(Long id) {
		return (KpiCategory) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiCategory where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiCategoryDao#get(java.lang.String)
	 */
	@Override
	public KpiCategory get(String name) {
		return (KpiCategory) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiCategory where name=:param")
				.setParameter("param", name).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiCategory> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiCategory").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiCategory> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiCategory").setFirstResult(start)
				.setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiCategory category) {
		getIssuemanSessionFactory().getCurrentSession().save(category);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return category.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiCategory category) {
		getIssuemanSessionFactory().getCurrentSession().delete(category);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}
}
