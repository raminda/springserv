package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanUserProjectRole;

/**
 * 
 * @author Kalpag
 * 
 */
@Repository("issuemanTicketDao")
public class IssuemanTicketDaoImpl implements IssuemanTicketDao {

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return issuemanSessionFactory;
	}

	/**
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.issuemanSessionFactory = sessionfactory;
	}

	// *********************************************************************************************
	/**
	 * 
	 * @param projectId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<IssuemanUserProjectRole> getUserProjectRoles(long projectId) {

		String queryString = "from IssuemanUserProjectRole where project.id = :projectId";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("projectId", projectId);
		List<IssuemanUserProjectRole> userProjectRoles = (List<IssuemanUserProjectRole>) query
				.list();

		return userProjectRoles;
	}

	// *********************************************************************************************
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTotalTickets
	 * (long, long, long, java.util.Date, java.util.Date)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<IssuemanTicket> getTotalTickets(long projectId, long type, long subType, Date from,
			Date to) {
		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " join ticket.currentType as currentType with currentType.fieldType = 'type' "
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType "
				+ " and ticket.reportedDate < :to and ticket.reportedDate > :from ";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);

		return (List<IssuemanTicket>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<IssuemanTicket> getTotalTicketsPerTbdir(long projectId, long type, long subType,
			Date from, Date to, String tbdir) {

		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " join ticket.currentType as currentType with currentType.fieldType = 'type'"
				+ " join ticket.tbdir as tbdir with tbdir.fieldType = 'release'"
				+ " where ticket.project.id = :projectId " + " and tbdir.release.name = :tbdir"
				+ " and currentType.ticketType.id = :subType "
				+ " and ticket.reportedDate < :to and ticket.reportedDate > :from ";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("tbdir", tbdir);
		return (List<IssuemanTicket>) query.list();
	}

	/**
	 * 
	 * @param object
	 */
	public void updateSession(Object object) {
		issuemanSessionFactory.getCurrentSession().update(object);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getNativeTickets
	 * (java.lang.String)
	 */
	@Override
	public String getNativeTickets(String tickets) {

		String queryString = "select native_id from tickets where id in(" + tickets + ")";
		Query query = issuemanSessionFactory.getCurrentSession().createSQLQuery(queryString);
		// query.setParameter("tickets", tickets);
		@SuppressWarnings("unchecked")
		List<Integer> list = query.list();

		String natives = org.springframework.util.StringUtils
				.collectionToCommaDelimitedString(list);
		return natives;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTicketIkeys(java.lang.String)
	 */
	@Override
	public String getTicketIkeys(String ticketIds) {
		
		String queryString = "select group_concat(ikey) from tickets where id in(" + ticketIds + ")";
		Query query = issuemanSessionFactory.getCurrentSession().createSQLQuery(queryString);
		
		return (String)query.uniqueResult();
		
	}

}
