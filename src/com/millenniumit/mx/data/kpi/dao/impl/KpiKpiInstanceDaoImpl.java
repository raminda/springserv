package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.KpiKpiInstanceDao;
import com.millenniumit.mx.data.kpi.domain.KpiIndex;
import com.millenniumit.mx.data.kpi.domain.KpiKpiInstance;
import com.millenniumit.mx.data.kpi.domain.KpiLevel;

/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiKpiInstanceDao")
@SuppressWarnings("unchecked")
public class KpiKpiInstanceDaoImpl implements KpiKpiInstanceDao {
	
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
	public KpiKpiInstance get(Long id) {
		return (KpiKpiInstance) getIssuemanSessionFactory().getCurrentSession()
				.createQuery("from KpiKpiInstance instance where instance.id=:param order by instance.definition.name")
				.setParameter("param", id).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiKpiInstance> getAll() {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiInstance instance order by instance.definition.name").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiKpiInstance> getAll(int start, int limit) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiInstance instance order by instance.definition.name")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiInstanceDao#getKpiKpiInstances(com.millenniumit.mx.data.issueman.domain.KpiIndex, com.millenniumit.mx.data.issueman.domain.KpiLevel)
	 */
	@Override
	public List<KpiKpiInstance> getKpiKpiInstances(KpiIndex index,
			KpiLevel level) {
		return getIssuemanSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiInstance instance where instance.level=:level " +
						"and instance.definition.index=:index order by instance.definition.name")
				.setParameter("level", level)
				.setParameter("index", index)
				.list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiKpiInstance instance) {
		getIssuemanSessionFactory().getCurrentSession().save(instance);
		getIssuemanSessionFactory().getCurrentSession().flush();
		return instance.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiKpiInstance instance) {
		getIssuemanSessionFactory().getCurrentSession().delete(instance);
		getIssuemanSessionFactory().getCurrentSession().flush();
	}
}
