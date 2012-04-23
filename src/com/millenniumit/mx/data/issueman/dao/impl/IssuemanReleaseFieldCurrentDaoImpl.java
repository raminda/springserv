/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.IssuemanReleaseFieldCurrentDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanReleaseFieldCurrent;

/**
 * @author Kalpag
 *
 */
@Repository("issuemanReleaseFieldCurrentDao")
public class IssuemanReleaseFieldCurrentDaoImpl implements
		IssuemanReleaseFieldCurrentDao {

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent(
			int offset, int limit) {
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				"from IssuemanReleaseFieldCurrent");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<IssuemanReleaseFieldCurrent>) query.list();
	}

	/**
	 * 
	 */
	@Override
	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent() {
		
		return null;
	}

	/**
	 * @return the issuemanSessionFactory
	 */
	public SessionFactory getissuemanSessionFactory() {
		return issuemanSessionFactory;
	}

	/**
	 * @param issuemanSessionFactory the issuemanSessionFactory to set
	 */
	public void setissuemanSessionFactory(SessionFactory sessionFactory) {
		issuemanSessionFactory = sessionFactory;
	}

}
