package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiKpiScore;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiKpiScoreDao")
@SuppressWarnings("unchecked")
public class KpiKpiScoreDaoImpl implements KpiKpiScoreDao {
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;
	
	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(KpiKpiScoreDaoImpl.class);

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
	public KpiKpiScore get(Long id) {
		return (KpiKpiScore) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiKpiScore where id=:param")
				.setParameter("param", id).uniqueResult();
	}	

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao#getKpiScore(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, java.lang.String, java.lang.String)
	 */
	@Override
	public KpiKpiScore getKpiScore(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, String asAt,
			String week) {
		if (release == null) {
			try {
				return (KpiKpiScore) getIssuemanSessionFactory().getCurrentSession()
						.createQuery("from KpiKpiScore where instance=:instance " +
								"and project=:project and week=:week and asAt=:asAt")
						.setParameter("instance", instance)
						.setParameter("project", project)
						.setParameter("week", week)
						.setParameter("asAt", asAt)
						.uniqueResult();
			} catch (NonUniqueResultException e){
				logger.error(e);
				return null;
			}
		} else {
			return (KpiKpiScore) getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiKpiScore where instance=:instance " +
							"and project=:project and release=:release and week=:week and asAt=:asAt")
					.setParameter("instance", instance)
					.setParameter("project", project)
					.setParameter("release", release)
					.setParameter("week", week)
					.setParameter("asAt", asAt)
					.uniqueResult();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiKpiScore> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiScore").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiKpiScore> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiScore")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao#getKpiScores(com.millenniumit.mx.data.issueman.domain.KpiKpiInstance, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, java.lang.String, java.util.List)
	 */
	@Override
	public List<KpiKpiScore> getKpiScores(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, String asAt,
			List<String> lastCalculatedWeeks) {
		if (release == null) {
			return getIssuemanSessionFactory().getCurrentSession()
						.createQuery("from KpiKpiScore where instance=:instance " +
								"and project=:project and week in (:weeks) " +
								"and asAt=:asAt order by week asc")
						.setParameter("instance", instance)
						.setParameter("project", project)
						.setParameterList("weeks", lastCalculatedWeeks)
						.setParameter("asAt", asAt)
						.list();
		} else {
			return getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiKpiScore where instance=:instance " +
							"and project=:project and release=:release and week in (:weeks) " +
							"and asAt=:asAt order by week asc")
					.setParameter("instance", instance)
					.setParameter("project", project)
					.setParameter("release", release)
					.setParameterList("weeks", lastCalculatedWeeks)
					.setParameter("asAt", asAt)
					.list();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao#getAsAtsSorted(int)
	 */
	@Override
	public List<String> getAsAtsSorted(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, int limit) {
		if (release == null) {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.asAt from KpiKpiScore score where score.instance=:instance " +
								"and score.project=:project " +
							"order by score.asAt desc")
							.setParameter("instance", instance)
						.setParameter("project", project)
					.setMaxResults(limit).list();
		} else {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.asAt from KpiKpiScore score where score.instance=:instance " +
								"and score.project=:project and score.release=:release " +
							"order by score.asAt desc")
							.setParameter("instance", instance)
						.setParameter("project", project)
						.setParameter("release", release)
					.setMaxResults(limit).list();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiScoreDao#getWeeksSorted(int)
	 */
	@Override
	public List<String> getWeeksSorted(KpiKpiInstance instance,
			IssuemanProject project, KpiWatchedRelease release, int limit) {
		if (release == null) {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.week from KpiKpiScore score where score.instance=:instance " +
								"and score.project=:project " +
							"order by score.week desc")
							.setParameter("instance", instance)
						.setParameter("project", project)
					.setMaxResults(limit).list();
		} else {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.week from KpiKpiScore score where score.instance=:instance " +
								"and score.project=:project and score.release=:release " +
							"order by score.week desc")
							.setParameter("instance", instance)
						.setParameter("project", project)
						.setParameter("release", release)
					.setMaxResults(limit).list();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiKpiScore score) {
		getIssuemanSessionFactory().getCurrentSession().save(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return score.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiKpiScore score) {
		getIssuemanSessionFactory().getCurrentSession().delete(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}	
}
