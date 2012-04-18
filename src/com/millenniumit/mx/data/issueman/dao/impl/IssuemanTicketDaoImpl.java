/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldHistory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;

/**
 * 
 * @author Kalpag
 * 
 */

@Repository("issuemanTicketDao")
public class IssuemanTicketDaoImpl implements IssuemanTicketDao {

	@Autowired
	@Qualifier("IssuemanSessionFactory")
	private SessionFactory IssuemanSessionFactory;

	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
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

		String queryString = "select ticket from IssuemanTicket ticket"
				+ " join ticket.currentType as currentType "
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType "
				+ "and ticket.reportedDate < :to and ticket.reportedDate > :from ";

		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
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

		String queryString = "select ticket from IssuemanTicket ticket "
				+ " join ticket.ticketLinks as links"
				+ " join ticket.currentType as currentType"
				+ " join links.ticketLinkType as linkType"
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType and "
				+ " ticket.reportedDate < :to "
				+ " and ticket.reportedDate > :from"
				+ " and linkType.name in :linktypes";

		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);
		List<String> params = new ArrayList<String>();
		params.add("Copied From");
		params.add("Platform");
		params.add("Cloners");
		query.setParameterList("linktypes", params);
		return (List<IssuemanTicket>) query.list();
	}

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return IssuemanSessionFactory;
	}

	/**
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.IssuemanSessionFactory = sessionfactory;
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

		String queryString = "select ticket from IssuemanTicket ticket"
				+ " left join ticket.ticketLinks as links"
				+ " join ticket.currentStatus as currentStatus"
				+ " join ticket.currentType as currentType"
				+ " where ticket.project.id = :projectId  "
				+ " and currentType.ticketType.id = :subType "
				+ " and currentStatus.status.name = :open"
				+ " and links is null" + " and ticket.reportedDate < :to "
				+ " and ticket.reportedDate > :from";

		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
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

		String q = "select ticket from IssuemanTicket ticket"
		// + " left join ticket.ticketLinks as links"
				+ " join ticket.statusHistoy as statusHistoy "
				// + " join ticket.currentStatus as currentStatus"
				// + " join ticket.currentType as currentType"
			+ " where ticket.project.id = :projectId  ";
				// + " and currentType.ticketType.id = :subType "
				// + " and currentStatus.status.name = :open"
			//	+ " and links is null";
		// + " and ticket.reportedDate < :to "
		// + " and ticket.reportedDate > :from";

		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(q);
		query.setParameter("projectId", projectId);

		List<IssuemanTicket> tickets = query.list();
		for (IssuemanTicket issuemanTicket : tickets) {
			Collection<IssuemanStatusFieldHistory> histories = (Collection<IssuemanStatusFieldHistory>) issuemanTicket
					.getStatusHistoy();
			System.out.println("----------------------");
			for (IssuemanStatusFieldHistory issuemanStatusFieldHistory : histories) {
				System.out.println(issuemanTicket.getId() + " old value = "
					//	+ issuemanStatusFieldHistory.getOldStatus().getId()
						+ " new value = "+"");
					//	+ issuemanStatusFieldHistory.getNewStatus().getId());
			}

		}

		return tickets;
	}

}
