package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;
import com.millenniumit.mx.data.issueman.domain.KpiIndexScore;
import com.millenniumit.mx.data.issueman.domain.KpiLevel;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiIndexScoreDao")
@SuppressWarnings("unchecked")
public class KpiIndexScoreDaoImpl implements KpiIndexScoreDao {
	
	/**
	 * 
	 */
	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;
	
	/**
	 * 
	 */
	private Logger logger = Logger.getLogger(KpiIndexScoreDaoImpl.class);

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
	public KpiIndexScore get(Long id) {
		return (KpiIndexScore) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiIndexScore where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao#getKpiScore(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, java.lang.String, java.lang.String)
	 */
	@Override
	public KpiIndexScore getKpiScore(KpiIndex index, KpiLevel level, IssuemanProject project,
			KpiWatchedRelease release, String asAt,
			String week) {
		if (release == null) {
			try {
				return (KpiIndexScore) getIssuemanSessionFactory().getCurrentSession()
						.createQuery("from KpiIndexScore where index=:index and level=:level " +
								"and project=:project and week=:week and asAt=:asAt")
						.setParameter("index", index)
						.setParameter("level", level)
						.setParameter("project", project)
						.setParameter("week", week)
						.setParameter("asAt", asAt)
						.uniqueResult();
			} catch (NonUniqueResultException e){
				logger.error(e);
				return null;
			}
		} else {
			return (KpiIndexScore) getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiIndexScore where index=:index and level=:level " +
							"and project=:project and release=:release and week=:week and asAt=:asAt")
					.setParameter("index", index)
					.setParameter("level", level)
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
	public List<KpiIndexScore> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexScore").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiIndexScore> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiIndexScore")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao#getKpiScores(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.IssuemanProject, com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease, java.lang.String, java.util.List)
	 */
	@Override
	public List<KpiIndexScore> getKpiScores(KpiIndex index, KpiLevel level, 
			IssuemanProject project, KpiWatchedRelease release, String asAt,
			List<String> weeks) {
		if (release == null) {			
			return getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiIndexScore where index=:index and level=:level " +
							"and project=:project and week in (:weeks) and asAt=:asAt " +
							"order by week asc")
					.setParameter("index", index)
					.setParameter("level", level)
					.setParameter("project", project)
					.setParameterList("weeks", weeks)
					.setParameter("asAt", asAt)
					.list();
			
		} else {
			return getIssuemanSessionFactory().getCurrentSession()
					.createQuery("from KpiIndexScore where index=:index and level=:level " +
							"and project=:project and release=:release and week in (:weeks) " +
							"and asAt=:asAt order by week asc")
					.setParameter("index", index)
					.setParameter("level", level)
					.setParameter("project", project)
					.setParameter("release", release)
					.setParameterList("weeks", weeks)
					.setParameter("asAt", asAt)
					.list();
		}
	}	

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiIndexScore score) {
		getIssuemanSessionFactory().getCurrentSession().save(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return score.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiIndexScore score) {
		getIssuemanSessionFactory().getCurrentSession().delete(score);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao#getAsAtsSorted(int)
	 */
	@Override
	public List<String> getAsAtsSorted(KpiIndex index, KpiLevel level,
			IssuemanProject project, KpiWatchedRelease release, int limit) {
		if (release == null) {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.asAt from KpiIndexScore score " +
							"where score.index=:index and score.level=:level " +
								"and score.project=:project " +
							"order by score.asAt desc")
							.setParameter("index", index)
						.setParameter("level", level)
						.setParameter("project", project)
					.setMaxResults(limit).list();
		} else {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.asAt from KpiIndexScore score " +
							"where score.index=:index and score.level=:level " +
								"and score.project=:project and score.release=:release " +
							"order by score.asAt desc")
							.setParameter("index", index)
						.setParameter("level", level)
						.setParameter("project", project)
						.setParameter("release", release)
					.setMaxResults(limit).list();
		}
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiIndexScoreDao#getWeeksSorted(int)
	 */
	@Override
	public List<String> getWeeksSorted(KpiIndex index, KpiLevel level,
			IssuemanProject project, KpiWatchedRelease release, int limit) {
		if (release == null) {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.week from KpiIndexScore score " +
							"where score.index=:index and score.level=:level " +
								"and score.project=:project " +
							"order by score.week desc")
							.setParameter("index", index)
						.setParameter("level", level)
						.setParameter("project", project)
					.setMaxResults(limit).list();
		} else {
			return getIssuemanSessionFactory()
					.getCurrentSession()
					.createQuery("select distinct score.week from KpiIndexScore score " +
							"where score.index=:index and score.level=:level " +
								"and score.project=:project and score.release=:release " +
							"order by score.week desc")
							.setParameter("index", index)
						.setParameter("level", level)
						.setParameter("project", project)
						.setParameter("release", release)
					.setMaxResults(limit).list();
		}
	}
}
