package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldCurrent;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldHistory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketFieldCurrent;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketLink;
import com.millenniumit.mx.data.issueman.domain.IssuemanUserProjectRole;

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

	/**
 *  
 */
	private List<IssuemanTicket> totalTicketsList = null;
	private List<IssuemanTicket> uncopiedTickets = null;
	private List<IssuemanTicket> invalidTickets = null;
	private List<IssuemanTicket> validTickets = null;
	private List<IssuemanTicket> copiedTickets = null;
	private List<IssuemanTicket> currentOpenTickets = null;

	private List<IssuemanUserProjectRole> userProjectRoles = null;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTotalTickets
	 * (long, long, long, java.util.Date, java.util.Date)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to) {
		String queryString = "select distinct ticket from IssuemanTicket ticket"
				+ " join ticket.currentType as currentType with currentType.fieldType = 'type' "
				+ " where ticket.project.id = :projectId and "
				+ " currentType.ticketType.id = :subType "
				+ " and ticket.reportedDate < :to and ticket.reportedDate > :from ";

		Query query = issuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setParameter("projectId", projectId);
		query.setParameter("subType", subType);
		query.setParameter("from", from);
		query.setParameter("to", to);
		return (List<IssuemanTicket>) query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getInvalidTickets
	 * ()
	 */
	@Override
	public List<IssuemanTicket> getInvalidTickets() {

		invalidTickets = new ArrayList<IssuemanTicket>();
		String currentStatus = null;

		if (uncopiedTickets == null) { // if total tickets list is empty
			uncopiedTickets = getUncopiedTickets();
		}

		for (IssuemanTicket ticket : uncopiedTickets) {
			// re attach tickets to the session
			issuemanSessionFactory.getCurrentSession().update(ticket);
			boolean invalidHistory = false;
			currentStatus = ticket.getCurrentStatus().get(0).getStatus()
					.getName();
			List<IssuemanStatusFieldHistory> statusHistory = ticket
					.getStatusHistoy();

			for (IssuemanStatusFieldHistory issuemanStatusFieldHistory : statusHistory) {
				String oldStatus = issuemanStatusFieldHistory.getOldStatus()
						.getName();
				String newStatus = issuemanStatusFieldHistory.getNewStatus()
						.getName();

				if (oldStatus.equals("DUPLICATE") && newStatus.equals("CLOSED")) {
					invalidHistory = true;
				}
			}

			if ((currentStatus.equals("DUPLICATE") || currentStatus
					.equals("CANCELLED")) || invalidHistory) {
				invalidTickets.add(ticket);
			}
		}
		System.out.println("no of invalid tickets = " + invalidTickets.size());
		return invalidTickets;
	}

	/**
     * 
     */
	public List<IssuemanTicket> getValidTickets() {

		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets();
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}
		validTickets = new ArrayList<IssuemanTicket>(); // instantiate
		validTickets = uncopiedTickets;

		System.out
				.println("size of total uncopied = " + uncopiedTickets.size());

		validTickets.removeAll(invalidTickets);
		System.out.println("size of valid tickets = " + validTickets.size());
		return validTickets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#Init(long,
	 * long, long, java.util.Date, java.util.Date)
	 */
	@Override
	public void Init(long projectId, long type, long subType, Date from, Date to) {

		/*
		 * Handle all the configuration stuff here {which database to connect}
		 */
		setUserProjectRoles(projectId); // load user project roles table into
										// memory
		totalTicketsList = getTotalTickets(projectId, type, subType, from, to);
		System.out.println("Total tickets set");
	}

	@Override
	public List<IssuemanTicket> getUncopiedTickets() {

		if (uncopiedTickets == null) {
			uncopiedTickets = totalTicketsList;
			copiedTickets = getCopiedTickets();
			uncopiedTickets.removeAll(copiedTickets);
		}

		System.out.println("Size of uncopied tickets = "
				+ uncopiedTickets.size());
		return uncopiedTickets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getCopiedTickets
	 * ()
	 */
	@Override
	public List<IssuemanTicket> getCopiedTickets() {
		copiedTickets = new ArrayList<IssuemanTicket>();
		System.out
				.println("Size of total tickets = " + totalTicketsList.size());

		if (totalTicketsList == null) {
			totalTicketsList = getTotalTickets();
		}

		for (IssuemanTicket ticket : totalTicketsList) {
			issuemanSessionFactory.getCurrentSession().update(ticket);
			List<IssuemanTicketLink> ticketLinks = ticket.getTicketLinks();

			for (IssuemanTicketLink issuemanTicketLink : ticketLinks) {
				String linkType = issuemanTicketLink.getTicketLinkType()
						.getName();

				if (linkType.equals("Platform")
						|| linkType.equals("Copied from")
						|| linkType.equals("Cloners")) {
					copiedTickets.add(ticket);
				}
			}
		}
		System.out.println("Size of copied issues =" + copiedTickets.size());
		return copiedTickets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTotalTickets()
	 */
	@Override
	public List<IssuemanTicket> getTotalTickets() {
		if (totalTicketsList == null) {

			// throw an exception and ask user to call the
			// init method
		}

		System.out.println("size of total tickets list ="
				+ totalTicketsList.size());

		return totalTicketsList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getCurrentOpenTickets
	 * ()
	 */
	@Override
	public List<IssuemanTicket> getCurrentOpenTickets() {
		currentOpenTickets = new ArrayList<IssuemanTicket>();

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}

		for (IssuemanTicket ticket : uncopiedTickets) {
			String currentStatus = ticket.getCurrentStatus().get(0).getStatus()
					.getName();

			if (currentStatus.equals("OPEN")) {
				currentOpenTickets.add(ticket);
			}

		}

		System.out.println("size of currently open tickets list ="
				+ currentOpenTickets.size());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getCurrentOpenTicketsByRole(java.lang.String)
	 */
	@Override
	public List<IssuemanTicket> getCurrentOpenTicketsByRole(String roleName) {
		List<IssuemanTicket> currentOpenTicketsbyRole = new ArrayList<IssuemanTicket>();

		if (currentOpenTickets == null) {
			currentOpenTickets = getCurrentOpenTickets();
		}

		currentOpenTicketsbyRole = getTicketsFilterByRole(roleName,
				currentOpenTickets);
		return currentOpenTicketsbyRole;
	}

	/**
	 * 
	 * @param roleName
	 * @param ticketList
	 * @return
	 */
	private List<IssuemanTicket> getTicketsFilterByRole(String roleName,
			List<IssuemanTicket> ticketList) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket ticket : ticketList) {

			issuemanSessionFactory.getCurrentSession().update(ticket);
			long reporterId = ticket.getReporter().getId();

			for (IssuemanUserProjectRole userprojectrole : userProjectRoles) {

				issuemanSessionFactory.getCurrentSession().update(userprojectrole);
				if (userprojectrole.getUser().getId() == reporterId) {
					String role = userprojectrole.getRole().getName();

					if (role.equals(roleName)) {
						filteredTickets.add(ticket);
					}
				}
			}
		}
		return filteredTickets;
	}

	/**
	 * 
	 * @param projectId
	 */

	@SuppressWarnings("unchecked")
	private void setUserProjectRoles(long projectId) {

		if (userProjectRoles == null) {
			String queryString = "from IssuemanUserProjectRole where project.id = :projectId";
			Query query = issuemanSessionFactory.getCurrentSession()
					.createQuery(queryString);
			query.setParameter("projectId", projectId);
			userProjectRoles = (List<IssuemanUserProjectRole>) query.list();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getValidTicketsByRole
	 * (java.lang.String)
	 */
	@Override
	public List<IssuemanTicket> getValidTicketsByRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getInvalidTicketsByRole(java.lang.String)
	 */
	@Override
	public List<IssuemanTicket> getInvalidTicketsByRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getUncopiedTicketsByRole(java.lang.String)
	 */
	@Override
	public List<IssuemanTicket> getUncopiedTicketsByRole(String roleName) {

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}

		return getTicketsFilterByRole(roleName, uncopiedTickets);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTotalTicketsByRole
	 * (java.lang.String)
	 */
	@Override
	public List<IssuemanTicket> getTotalTicketsByRole(String roleName) {

		if (totalTicketsList == null) {
			totalTicketsList = getUncopiedTickets();
		}

		return getTicketsFilterByRole(roleName, totalTicketsList);
	}
}
