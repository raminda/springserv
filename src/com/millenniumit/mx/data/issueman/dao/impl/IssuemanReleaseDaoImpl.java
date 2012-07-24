package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.IssuemanReleaseDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanRelease;

/**
 * 
 * @author Vimukthi
 *
 */
@SuppressWarnings("unchecked")
@Repository("issuemanReleaseDao")
public class IssuemanReleaseDaoImpl implements IssuemanReleaseDao {
	
	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;	

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanReleaseDao#getIssuemanRelease(java.lang.Long)
	 */
	@Override
	public IssuemanRelease getIssuemanRelease(Long id) {
		return (IssuemanRelease) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from IssuemanRelease where id=:param")
				.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanReleaseDao#getIssuemanReleases(com.millenniumit.mx.data.issueman.domain.IssuemanProject, java.lang.String)
	 */
	@Override
	public List<IssuemanRelease> getIssuemanReleases(IssuemanProject project,
			String type) {
		Query query = null;
		if (project == null && type == null) {
			query = getIssuemanSessionFactory().getCurrentSession().createQuery("from IssuemanRelease order by name");
		} else if (project == null){
			query = getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from IssuemanRelease where type=:type order by name").setParameter("type", type);
		} else if (type == null){
			query = getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from IssuemanRelease where project=:project order by name").setParameter("project", project);
		} else {
			query = getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from IssuemanRelease where project=:project and type=:type order by name")
					.setParameter("project", project)
					.setParameter("type", type);
		}
		return query.list();
	}

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

}
