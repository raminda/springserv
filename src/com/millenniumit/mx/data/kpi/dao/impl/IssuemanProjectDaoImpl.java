package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.IssuemanProjectDao;
import com.millenniumit.mx.data.kpi.domain.IssuemanProject;

/**
 * 
 * @author kalpag
 * 
 */
@SuppressWarnings("unchecked")
@Repository("kpiProjectDao")
public class IssuemanProjectDaoImpl implements IssuemanProjectDao {

	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory issuemanSessionFactory;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanProjectDao#getIssuemanProject(java.lang.Long)
	 */
	@Override
	public IssuemanProject getIssuemanProject(Long id) {
		return (IssuemanProject) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from IssuemanProject where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanProjectDao#getIssuemanProjects
	 * ()
	 */
	@Override
	public List<IssuemanProject> getIssuemanProjects() {
		String queryString = "from IssuemanProject order by key";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
			return (List<IssuemanProject>)query.list();
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
