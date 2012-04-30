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
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldHistory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
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

	public enum RoleCategory {
		CLIENT, MIT, EXTQA, THINKSOFT, VIRTUSA, ALLIED
	}

	public enum IssueType {

		VALID, INVALID, CURRENTOPEN, OPEN, TOTAL, UNCOPIED, COPIED
	}

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
	// *********************************************************************************************

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
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getInvalidTickets() {

		if (invalidTickets != null) {
			return invalidTickets;
		}

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
	// *********************************************************************************************

	public List<IssuemanTicket> getValidTickets() {

		if (validTickets != null) {
			return validTickets;
		}

		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets();
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}
		validTickets = new ArrayList<IssuemanTicket>(); // instantiate
		validTickets = uncopiedTickets;

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
	// *********************************************************************************************

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

	/**
 * 
 */
	// *********************************************************************************************

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
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getCopiedTickets() {
		copiedTickets = new ArrayList<IssuemanTicket>();
		System.out
				.println("Size of total tickets = " + totalTicketsList.size());
		if (copiedTickets != null) {
			return copiedTickets;
		}

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
	// *********************************************************************************************

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
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getCurrentOpenTickets() {

		if (currentOpenTickets != null) {
			return currentOpenTickets;
		}

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
	// *********************************************************************************************

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
	// *********************************************************************************************

	private List<IssuemanTicket> getTicketsFilterByRole(String roleName,
			List<IssuemanTicket> ticketList) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket ticket : ticketList) {
			issuemanSessionFactory.getCurrentSession().update(ticket);
			long reporterId = ticket.getReporter().getId();

			for (IssuemanUserProjectRole userprojectrole : userProjectRoles) {
				issuemanSessionFactory.getCurrentSession().update(
						userprojectrole);

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
	// *********************************************************************************************

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
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getValidTicketsByRole(String roleName) {

		if (validTickets == null) {
			validTickets = getValidTickets();
		}

		return getTicketsFilterByRole(roleName, validTickets);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getInvalidTicketsByRole(java.lang.String)
	 */
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getInvalidTicketsByRole(String roleName) {

		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets();
		}

		return getTicketsFilterByRole(roleName, invalidTickets);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getUncopiedTicketsByRole(java.lang.String)
	 */
	// *********************************************************************************************

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
	// *********************************************************************************************

	@Override
	public List<IssuemanTicket> getTotalTicketsByRole(String roleName) {

		if (totalTicketsList == null) {
			totalTicketsList = getTotalTickets();
		}

		return getTicketsFilterByRole(roleName, totalTicketsList);
	}

	/**
	 * 
	*/
	// *********************************************************************************************
	public List<IssuemanTicket> getTicketsByRoleCategory(
			RoleCategory roleCategory, IssueType issueType) {

		// CLIENT, MIT, EXTQA, THINKSOFT, VIRTUSA
		switch (roleCategory) {
		case ALLIED:
			return getAlliedReportedTickets(issueType);

		case CLIENT:
			return getClientReportedTickets(issueType);

		case MIT:
			return getMitReportedTickets(issueType);
		
		case EXTQA:
			return getExtQaReportedTickets(issueType);
		default:
			break;
		}
		return null;
	}


	/**
	 * 
	 * @param issueType
	 * @returns all the tickets reported by external QAs 
	 */
	// *********************************************************************************************

	private  List<IssuemanTicket> getExtQaReportedTickets(IssueType issueType){
		List<String> roles = new ArrayList<String>();
		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		
		roles.add("Ext QA Virtusa");
		roles.add("Ext QA Allied");
		roles.add("Ext QA ThinkSoft");
		roles.add("Ext QA");
		
		return getTicketsFilterByRole(roles, ticketList, false);
	}
	
	/**
	 * @param issueType
	 * @returns Allied reported tickets 
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getAlliedReportedTickets(IssueType issueType){
	
		String roleName = "Ext QA Allied";
		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterByRole(roleName, ticketList);
	}
	
	/**
	 * 
	 * @param issueType
	 * @returns MIT reported Tickets 
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getMitReportedTickets(IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		List<String> roles = new ArrayList<String>();

		//MIT reported tickets are the tickets
		//that are returned where reported by role name
		//is not in this list
		
		roles.add("Client");
		roles.add("Client (Admin)");
		roles.add("Ext QA");
		roles.add("Ext QA Virtusa");
		roles.add("Ext QA Allied");
		roles.add("Ext QA ThinkSoft");

		
		return getTicketsFilterByRole(roles, ticketList, false);
	}

	/**
	 * 
	 * @param issueType
	 * @return
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getClientReportedTickets(IssueType issueType) {
		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		List<String> roles = new ArrayList<String>();
		roles.add("Client");
		roles.add("Client (Admin)");

		return getTicketsFilterByRole(roles, ticketList, false);
	}

	/**
	 * 
	 * @param issueType
	 * @return
	 */
	// *********************************************************************************************
	/**
	 * 
	 * @param issueType
	 * @return get the releavant issue list from the class variable according to
	 *         the requested type
	 */
	private List<IssuemanTicket> getTicketListForIssueType(IssueType issueType) {
		List<IssuemanTicket> ticketList = null;

		switch (issueType) {
		case VALID:
			ticketList = getValidTickets();
			break;
		case INVALID:
			ticketList = getInvalidTickets();
			break;
		case CURRENTOPEN:
			ticketList = getCurrentOpenTickets();
			break;
		case OPEN:
			ticketList = getUncopiedTickets(); // implement a function for this
			break;
		case TOTAL:
			ticketList = getTotalTickets();
			break;
		case UNCOPIED:
			ticketList = getUncopiedTickets();
			break;
		case COPIED:
			ticketList = getCopiedTickets();
			break;
		default:
			break;
		}
		return ticketList;
	}

	/**
	 * 
	 * @param roleNames
	 *            : criteria to filter(role names )
	 * @param ticketList
	 *            : list to filter
	 * @param invert
	 *            : determines whether to return the inverse of filtered tickets
	 *            when set to true, returned result set equals select ticket
	 *            where ticket.role not in(roleNames)
	 * 
	 * @return returns the tickets which belong to given reported by roles
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getTicketsFilterByRole(List<String> roleNames,
			List<IssuemanTicket> ticketList, boolean invert) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket ticket : ticketList) {
			issuemanSessionFactory.getCurrentSession().update(ticket);
			long reporterId = ticket.getReporter().getId();

			for (IssuemanUserProjectRole userprojectrole : userProjectRoles) {
				issuemanSessionFactory.getCurrentSession().update(
						userprojectrole);

				if (userprojectrole.getUser().getId() == reporterId) {
					String role = userprojectrole.getRole().getName();

					if (invert) {
						if (!roleNames.contains(role)) {
							filteredTickets.add(ticket);
						}
					} else {
						if (roleNames.contains(role)) {
							filteredTickets.add(ticket);
						}
					}

				}
			}
		}
		return filteredTickets;
	}
}
