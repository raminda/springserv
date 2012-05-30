/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;

/**
 * @author Kalpag
 * 
 */
@SuppressWarnings("unchecked")
@Repository("timeSheetsReferenceDao")
public class TimeSheetsReferenceHibernateDao implements TimeSheetsReferenceDao {

	@Autowired
	@Qualifier("timeSheetsSessionFactory")
	private SessionFactory sessionfactory;

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	/**
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao#getTimeSheetsReference(java.lang.String, com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	public TimeSheetsReference getTimeSheetsReference(String name,
			PortalDivision division) {
		return (TimeSheetsReference) getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReference where name=:name and division=:division")
				.setParameter("name", name)
				.setParameter("division", division).uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao#getTimeSheetsReferences()
	 */
	@Override
	public List<TimeSheetsReference> getTimeSheetsReferences() {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReference").list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao#getTimeSheetsReferences(com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	public List<TimeSheetsReference> getTimeSheetsReferences(
			PortalDivision division) {
		return getSessionfactory().getCurrentSession()
				.createQuery("from TimeSheetsReference where division=:division")
				.setParameter("division", division).list();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao#save(com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference)
	 */
	@Override
	public void save(TimeSheetsReference reference) {
		getSessionfactory().getCurrentSession().saveOrUpdate(reference);
		getSessionfactory().getCurrentSession().flush();
	}
}
