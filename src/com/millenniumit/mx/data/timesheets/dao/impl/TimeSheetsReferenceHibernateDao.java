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
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;

/**
 * @author Kalpag
 * 
 */
@Repository("timesheetsReferenceDao")
public class TimeSheetsReferenceHibernateDao implements TimeSheetsReferenceDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeSheetsReference> getTimeSheetsReferences() {
		String queryString = "from TimeSheetsReference";
		List<TimeSheetsReference> timesheetsRefList = (List<TimeSheetsReference>) getSessionfactory()
				.getCurrentSession().createQuery(queryString).list();
		return timesheetsRefList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeSheetsReference> getTimeSheetsReferences(long divisionId) {
	
		String queryString = "from TimeSheetsReference where divisionId = '"+divisionId+"' ";
		List<TimeSheetsReference> timesheetsRefList = (List<TimeSheetsReference>) getSessionfactory()
				.getCurrentSession().createQuery(queryString).list();

		return timesheetsRefList;
	}

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

}
