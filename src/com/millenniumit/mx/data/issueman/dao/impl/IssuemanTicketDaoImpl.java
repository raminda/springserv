/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
/**
 * 
 * @author Kalpag
 * 
 */
@Repository("issuemanTicketDao")
public class IssuemanTicketDaoImpl implements IssuemanTicketDao {

	private static String CLONERS = "Cloners";
	private static String PLATFORM = "Platform";
	private static String COPIED_FROM = "Copied From";
	private static String DUPLICATE = "Duplicate";
	private static String CANCELLED = "Cancelled";
	private static String CLOSED = "Closed";
	private static String DELIVERED = "Delivered"; // jira does not have this
													// status

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				"from IssuemanTicket");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<IssuemanTicket>) query.list();
	}

		/**
	 * 
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to) {

		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " join ticket.currentType as currentType "
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType "
				+ "and ticket.reportedDate < :to and ticket.reportedDate > :from ";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);

		System.out.println("from = " + from);
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
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getCurrentOpenTickets
	 * (long, long, long, java.util.Date, java.util.Date)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId,
			long type, long subType, Date from, Date to) {

		System.out.println("from = " + from + " to = " + to);

		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " left join ticket.ticketLinks as links"
				+ " join ticket.currentStatus as currentStatus"
				+ " join ticket.currentType as currentType"
				+ " where ticket.project.id = :projectId  "
				+ " and currentType.ticketType.id = :subType "
				+ " and currentStatus.status.name = :open"
				+ " and links is null" + " and ticket.reportedDate < :to "
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
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getInvalidTickets
	 * (long, long, long, java.util.Date, java.util.Date)
	 */
	@Override
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to) {
		
		String q = "from IssuemanTicket";
		//+ " join ticket.currentStatus as currentStatus "
		//+ " where currentStatus.status.name ='Closed'";
	//	+ " where ticket.project.id = :projectId  "
		//+ " and currentType.ticketType.id = :subType "
		//+ " where links is null"

//		String q = "select distinct ticket from IssuemanTicket ticket"
//				+ " left join ticket.ticketLinks as links"
//				+ " join ticket.statusHistoy as statusHistoy "
//				+ " join statusHistoy.newStatus as newStatus "
//				+ " join statusHistoy.oldStatus as oldStatus "
//				+ " join ticket.currentStatus as currentStatus "
//				+ " join ticket.currentType as currentType"
//			//	+ " where ticket.project.id = :projectId  "
//				//+ " and currentType.ticketType.id = :subType "
//				//+ " where links is null"
//				+ " where currentStatus.status.name in :status";
////				+ " or ( oldStatus.name in :oldstatus"
////				+ " and newStatus.name in :newstatus )";
//		// + " and ticket.reportedDate < :to "
//		// + " and ticket.reportedDate > :from";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(q);
		IssuemanTicket i = (IssuemanTicket)query.list().get(0);
		System.out.println("********************************" + i.getCurrentStatus().get(0).getStatus().getName());
		//query.setParameter("projectId", projectId);
		// query.setParameter("subType", subType);
		List<String> status = new ArrayList<String>();
		List<String> oldstatus = new ArrayList<String>();

		status.add(DUPLICATE);
		status.add(CANCELLED);

		oldstatus.add(DUPLICATE);
		oldstatus.add(DELIVERED);

//		query.setParameterList("status", status);
//		query.setParameterList("oldstatus", oldstatus);
//		query.setParameter("newstatus", CLOSED);
		// query.setParameter("from", from);
		// query.setParameter("to", to);

//		int count = 0;
//		List<IssuemanTicket> tickets = query.list();
//		for (IssuemanTicket issuemanTicket : tickets) {
//			Collection<IssuemanStatusFieldHistory> histories = (Collection<IssuemanStatusFieldHistory>) issuemanTicket
//					.getStatusHistoy();
//			System.out.println("----------------------");
//
//			for (IssuemanStatusFieldHistory issuemanStatusFieldHistory : histories) {
//				long oldval = 0;
//				long newval = 0;
//				if (issuemanStatusFieldHistory.getOldStatus() != null)
//					oldval = issuemanStatusFieldHistory.getOldStatus().getId();
//				if (issuemanStatusFieldHistory.getNewStatus() != null)
//					newval = issuemanStatusFieldHistory.getNewStatus().getId();
//				System.out.println("Count = " + ++count);
//
//				System.out.println(issuemanTicket.getId() + " old value = "
//						+ oldval + " new value = " + "" + newval);
//			}
//		}
		return null;
	}
}
