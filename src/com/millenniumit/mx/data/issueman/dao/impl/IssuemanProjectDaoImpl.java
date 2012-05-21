package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.IssuemanProjectDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;

/**
 * 
 * @author kalpag
 * 
 */
@Repository("issuemanProjectDao")
public class IssuemanProjectDaoImpl implements IssuemanProjectDao {

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanProjectDao#getIssuemanProjects
	 * ()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanProject> getIssuemanProjects() {
		String queryString = "from IssuemanProject";
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
