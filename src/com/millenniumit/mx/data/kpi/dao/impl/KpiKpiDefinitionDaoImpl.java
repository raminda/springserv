package com.millenniumit.mx.data.kpi.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.kpi.dao.KpiKpiDefinitionDao;
import com.millenniumit.mx.data.kpi.domain.KpiKpiDefinition;


/**
 * 
 * @author Vimukthi
 *
 */
@Repository("kpiKpiDefinitionDao")
@SuppressWarnings("unchecked")
public class KpiKpiDefinitionDaoImpl implements KpiKpiDefinitionDao {
	
	@Autowired
	@Qualifier("kpiSessionFactory")
	private SessionFactory kpiSessionFactory;

	/**
	 * @return the issuemanSessionFactory
	 */
	public SessionFactory getKpiSessionFactory() {
		return kpiSessionFactory;
	}

	/**
	 * @param issuemanSessionFactory the issuemanSessionFactory to set
	 */
	public void setKpiSessionFactory(SessionFactory issuemanSessionFactory) {
		this.kpiSessionFactory = issuemanSessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#get(java.lang.Long)
	 */
	@Override
	public KpiKpiDefinition get(Long id) {
		return (KpiKpiDefinition) getKpiSessionFactory().getCurrentSession()
				.createQuery("from KpiKpiDefinition where id=:param")
				.setParameter("param", id).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.KpiKpiDefinitionDao#get(java.lang.String)
	 */
	@Override
	public KpiKpiDefinition get(String name) {
		return (KpiKpiDefinition) getKpiSessionFactory().getCurrentSession()
				.createQuery("from KpiKpiDefinition where name=:param")
				.setParameter("param", name).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll()
	 */
	@Override
	public List<KpiKpiDefinition> getAll() {
		return getKpiSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiDefinition").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<KpiKpiDefinition> getAll(int start, int limit) {
		return getKpiSessionFactory()
				.getCurrentSession()
				.createQuery("from KpiKpiDefinition")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public Long save(KpiKpiDefinition definition) {
		getKpiSessionFactory().getCurrentSession().save(definition);
		getKpiSessionFactory().getCurrentSession().flush();
		return definition.getId();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(KpiKpiDefinition definition) {
		getKpiSessionFactory().getCurrentSession().delete(definition);
		getKpiSessionFactory().getCurrentSession().flush();
	}	
}
