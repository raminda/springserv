package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.KpiProjectDao;
import com.millenniumit.mx.data.kpi.domain.KpiProject;

/**
 * 
 * @author kalpag
 * 
 */
@SuppressWarnings("unchecked")
@Repository("kpiProjectDao")
public class KpiProjectDaoImpl implements KpiProjectDao {

	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory issuemanSessionFactory;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiProjectDao#getKpiProject(java.lang.Long)
	 */
	@Override
	public KpiProject getKpiProject(Long id) {
		return (KpiProject) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiProject where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.KpiProjectDao#getKpiProjects
	 * ()
	 */
	@Override
	public List<KpiProject> getKpiProjects() {
		String queryString = "from KpiProject order by key";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
			return (List<KpiProject>)query.list();
	}

	/**
	 * @return the issuemanSessionFactory
	 */
	public SessionFactory getIssuemanSessionFactory() {
		return issuemanSessionFactory;
	}

	/**
	 * @param issuemanSessionFactory
	 *            the issuemanSessionFactory to set
	 */
	public void setIssuemanSessionFactory(SessionFactory issuemanSessionFactory) {
		this.issuemanSessionFactory = issuemanSessionFactory;
	}
}