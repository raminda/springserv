package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.KpiWatchedReleaseDao;
import com.millenniumit.mx.data.kpi.domain.KpiProject;
import com.millenniumit.mx.data.kpi.domain.KpiWatchedRelease;

/**
 * 
 * @author Vimukthi
 * 
 */
@SuppressWarnings("unchecked")
@Repository("kpiWatchedReleaseDao")
public class KpiWatchedReleaseDaoImpl implements KpiWatchedReleaseDao {

	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.KpiWatchedReleaseDao#
	 * getKpiWatchedRelease(java.lang.Long)
	 */
	@Override
	public KpiWatchedRelease getWatchedRelease(Long id) {
		return (KpiWatchedRelease) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiWatchedRelease where id=:param").setParameter("param", id)
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.KpiWatchedReleaseDao#
	 * getKpiWatchedReleases
	 * (com.millenniumit.mx.data.issueman.domain.KpiProject, java.lang.String)
	 */
	@Override
	public List<KpiWatchedRelease> getWatchedReleases(KpiProject project, String status) {
		Query query = null;
		if (project == null && status == null) {
			query = getIssuemanSessionFactory().getCurrentSession().createQuery(
					"from KpiWatchedRelease order by prefix");
		} else if (project == null) {
		
			query = getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiWatchedRelease where status=:status order by prefix")
					.setParameter("status", status);
		} else if (status == null) {
			
			query = getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiWatchedRelease where project=:project order by prefix")
					.setParameter("project", project);
		} else {
			query = getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery(
							"from KpiWatchedRelease where project=:project and status=:status order by prefix")
					.setParameter("project", project).setParameter("status", status);
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
	 * @param issuemanSessionFactory
	 *            the issuemanSessionFactory to set
	 */
	public void setIssuemanSessionFactory(SessionFactory issuemanSessionFactory) {
		this.issuemanSessionFactory = issuemanSessionFactory;
	}
}
