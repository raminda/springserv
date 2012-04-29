/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * @author kalpag
 *
 */
public class IssuemanDaoImplHQL {
	
	private static String CLONERS = "Cloners";
	private static String PLATFORM = "Platform";
	private static String COPIED_FROM = "Copied From";

	
	@Autowired
	@Qualifier("issuemanSessionFactory")
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

	@SuppressWarnings("unchecked")
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				"from IssuemanTicket");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<IssuemanTicket>) query.list();
	}

		
	/*
	 * 
	 */
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId,
			long type, long subType, Date from, Date to) {

		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " left join ticket.ticketLinks as links"
				+ " join ticket.currentStatus as currentStatus with currentStatus.fieldType = 'status'"
				+ " join ticket.currentType as currentType"
				+ " where ticket.project.id = :projectId  "
				+ " and currentType.ticketType.id = :subType "
				+ " and currentStatus.status.name = :open"
				+ " and links is null"
				+ " and ticket.reportedDate < :to "
				+ " and ticket.reportedDate > :from";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);
		query.setParameter("open", "Open");
		return (List<IssuemanTicket>) query.list();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getCopiedTickets
	 * (com.millenniumit.mx.data.issueman.domain.IssuemanProject, long, long,
	 * java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type,
			long subType, Date from, Date to) {

		String queryString = "select distinct ticket from IssuemanTicket ticket "
				+ " join ticket.ticketLinks as links"
				+ " join ticket.currentType as currentType"
				+ " join links.ticketLinkType as linkType"
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType and "
				+ " ticket.reportedDate < :to "
				+ " and ticket.reportedDate > :from"
				+ " and linkType.name in :linktypes";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<String> params = new ArrayList<String>();
		params.add(COPIED_FROM);
		params.add(PLATFORM);
		params.add(CLONERS);
		query.setParameterList("linktypes", params);
		return (List<IssuemanTicket>) query.list();
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getInvalidTickets
	 * (long, long, long, java.util.Date, java.util.Date)
	 */

	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to) {

		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " left join ticket.ticketLinks as links"
				+ " join ticket.statusHistoy as statusHistoy"
				+ " with statusHistoy.fieldType = 'status' "
				+ " join ticket.currentStatus as currentStatus "
				+ " with currentStatus.fieldType ='status' "
				+ " join ticket.currentType as currentType"
				+ " where (statusHistoy.oldStatus.name = :oldstatus"
				+ " and statusHistoy.newStatus.name = :newstatus)"
				+ " or currentStatus.status.name in :status "
				+ " and ticket.project.id = :projectId "
				+ " and currentType.ticketType.id = :subType "
				+ " and links is null"
				+ " and ticket.reportedDate < :to "
				+ " and ticket.reportedDate > :from";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		List<String> status = new ArrayList<String>();

		status.add("DUPLICATE");
		status.add("CANCELLED");

		query.setParameterList("status", status);
		query.setParameter("oldstatus", "DUPLICATE");
		query.setParameter("newstatus", "CLOSED");
		query.setParameter("from", from);
		query.setParameter("to", to);

		System.out.println("********************************"
				+ query.list().size());
		return null;
	}

}
