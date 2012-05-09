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

import com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;

/**
 * 
 * @author kalpag
 * 
 */
@Repository("issuemanTicketTypeDao")
public class IssuemanTicketTypeDaoImpl implements IssuemanTicketTypeDao {

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao#
	 * getIssuemanTicketTypes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicketType> getIssuemanTicketTypes() {

		String queryString = "from IssuemanTicketType where parentType.id = 0 ";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		return ((List<IssuemanTicketType>) query.list());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao#
	 * getIssuemanTicketSubTypes
	 * (com.millenniumit.mx.data.issueman.domain.IssuemanTicketType)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			IssuemanTicketType issuemanTicketType) {
		String queryString = "from IssuemanTicketType where parentType = :parentType ";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("parentType", issuemanTicketType);
		return ((List<IssuemanTicketType>) query.list());
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao#
	 * getIssuemanTicketSubTypes()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicketType> getIssuemanTicketSubTypes() {
		String queryString = "from IssuemanTicketType where parentType.id != 0 ";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		return ((List<IssuemanTicketType>) query.list());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao#
	 * getIssuemanTicketSubTypes(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			String issuemanTicketTypeName) {
		String queryString = "from IssuemanTicketType where parentType.name = :parentTypeName ";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("parentTypeName", issuemanTicketTypeName);
		return ((List<IssuemanTicketType>) query.list());
	}
}
