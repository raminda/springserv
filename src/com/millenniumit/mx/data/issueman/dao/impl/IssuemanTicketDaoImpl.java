package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldCurrent;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldHistory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketLink;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketStatus;
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
	private static String DUPLICATE = "DUPLICATE";
	private static String CANCELLED = "CANCELLED";
	private static String CLOSED = "CLOSED";
	private static String OPEN = "OPEN";

	private static String EXTQA_VIRTUSA = "Ext QA Virtusa";
	private static String EXTQA_ALLIED = "Ext QA Allied";
	private static String EXTQA_THINKSOFT = "Ext QA ThinkSoft";
	private static String EXTQA = "Ext QA";
	private static String CLIENT = "Client";
	private static String CLIENT_ADMIN = "Client (Admin)";

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

		invalidTickets = new ArrayList<IssuemanTicket>();
		String currentStatus = null;

		if (uncopiedTickets == null) { // if total tickets list is empty
			uncopiedTickets = getUncopiedTickets();
		}
		//
		// String currenthql =
		// "   select new map( t.ticket as ticket, t.status as status, history as history)"
		// + " from IssuemanStatusFieldCurrent t"
		// + " join t.ticket.statusHistory as history"
		// + " where t.ticket in (:tickets) ";

		String currenthql = "select distinct t.ticket as ticket,currentStatus as status, t.oldStatus as history"
				+ " from IssuemanStatusFieldHistory t"
				+ " join t.ticket.currentStatus as currentStatus"
				+ " where (t.oldStatus.name = :oldStatus and t.newStatus.name = :newStatus)"
				+ " or currentStatus.status.name in :statusNames "
				+ " and t.ticket in (:tickets)";

		// String currenthql = "from IssuemanTicket t"
		// + " join fetch t.statusHistoy as history"
		// //+ " join fetch t.currentStatus as status"
		// + " where t in (:tickets) ";
		// //+ " and status.status.name in (:statusNames)";

		List<String> statusNames = new ArrayList<String>();
		statusNames.add(CANCELLED);
		statusNames.add(DUPLICATE);

		// Query historyQuery = issuemanSessionFactory.getCurrentSession()
		// .createQuery(historyhql);
		// historyQuery.setParameter("oldstatus", DUPLICATE);
		// historyQuery.setParameter("newstatus", CLOSED);
		// historyQuery.setParameterList("statusNames", statusNames);
		// List<IssuemanTicket> htickets = historyQuery.list();

		Query currentquery = issuemanSessionFactory.getCurrentSession()
				.createQuery(currenthql);
		currentquery.setParameterList("tickets", uncopiedTickets);
		currentquery.setParameterList("statusNames", statusNames);

		 currentquery.setParameter("oldStatus", DUPLICATE);
		 currentquery.setParameter("newStatus", CLOSED);

		// List<IssuemanTicket> params = currentquery.list();

		List<Map<String, Object>> params = currentquery.list();
		System.out.println("Size = " + params.size());

		for (int i = 0; i < params.size(); i++) {
			// Map<String, Object> map = (Map<String, Object>) params.get(i);
			// System.out.println(new Gson().toJson(map));
			Map<String, Object> map = params.get(i);

			List<IssuemanStatusFieldHistory> status = (List<IssuemanStatusFieldHistory>) map
					.get("history");

			System.out.println(status.size());
			// List<IssuemanStatusFieldHistory> _statusHistory =
			// (List<IssuemanStatusFieldHistory>) map
			// .get("history");

			// List<IssuemanStatusFieldHistory> history =
			// (List<IssuemanStatusFieldHistory>) arr.get(2);

			// for (IssuemanStatusFieldHistory issuemanStatusFieldHistory :
			// history) {
			// System.out.println("History = " +
			// issuemanStatusFieldHistory.getOldStatus().getName());
			// }

			// String oldStatus = statusHistory.getOldStatus().getName();
			// String newStatus = statusHistory.getNewStatus().getName();
			//
			// if ((statusName.equals(DUPLICATE) ||
			// statusName.equals(CANCELLED))
			// || (oldStatus.equals(DUPLICATE) && newStatus.equals(CLOSED))) {
			//
			// tickets.add((IssuemanTicket) map.get("ticket"));
			//
			// System.out.println(" status =   " + statusName);
			// System.out.println(" OldStatus =   " + oldStatus);
			// System.out.println(" NewStatus =   " + newStatus);
			// System.out.println("\n");
			// }
			//
			// System.out.println("Size of the ticket list is = "
			// +tickets.size());
			// return tickets;
		}

		System.out.println("Loaded");

		// for (IssuemanTicket ticket : uncopiedTickets) {
		// // re attach tickets to the session
		// issuemanSessionFactory.getCurrentSession().update(ticket);
		//
		// currentStatus = ticket.getCurrentStatus().get(0).getStatus()
		// .getName();
		// List<IssuemanStatusFieldHistory> statusHistory = ticket
		// .getStatusHistory();
		//
		// boolean invalidHistory = false;
		// for (IssuemanStatusFieldHistory issuemanStatusFieldHistory :
		// statusHistory) {
		// String oldStatus = issuemanStatusFieldHistory.getOldStatus()
		// .getName();
		// String newStatus = issuemanStatusFieldHistory.getNewStatus()
		// .getName();
		//
		// if (oldStatus.equals(DUPLICATE) && newStatus.equals(CLOSED)) {
		// invalidHistory = true;
		// }
		// }
		//
		// if ((currentStatus.equals(DUPLICATE) || currentStatus
		// .equals(CANCELLED)) || invalidHistory) {
		// invalidTickets.add(ticket);
		// }
		// }
		// System.out.println("no of invalid tickets = " +
		// invalidTickets.size());
		return invalidTickets;
	}

	/**
     * 
     */
	// *********************************************************************************************

	public List<IssuemanTicket> getValidTickets() {

		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets();
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}
		// validTickets = new ArrayList<IssuemanTicket>(); // instantiate
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

		/**
		 * if(databaseConfiguration.getDatabase().getName().equals("jira")){
		 * 
		 * DUPLICATE = "Duplicate"; CLOSED = "Closed"; OPEN = "Open";
		 * 
		 * }
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

		if (totalTicketsList == null) {
			totalTicketsList = getTotalTickets();
		}

		for (IssuemanTicket ticket : totalTicketsList) {
			issuemanSessionFactory.getCurrentSession().update(ticket);
			List<IssuemanTicketLink> ticketLinks = ticket.getTicketLinks();

			for (IssuemanTicketLink issuemanTicketLink : ticketLinks) {
				String linkType = issuemanTicketLink.getTicketLinkType()
						.getName();

				if (linkType.equals(PLATFORM) || linkType.equals(COPIED_FROM)
						|| linkType.equals(CLONERS)) {
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

		currentOpenTickets = new ArrayList<IssuemanTicket>();

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets();
		}

		for (IssuemanTicket ticket : uncopiedTickets) {
			String currentStatus = ticket.getCurrentStatus().get(0).getStatus()
					.getName();

			if (currentStatus.equals(OPEN)) {
				currentOpenTickets.add(ticket);
			}
		}

		System.out.println("size of currently open tickets list ="
				+ currentOpenTickets.size());
		return currentOpenTickets;
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
	 * loads the project_user_role table into memory filtered by project
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

	/**
	 * 
	 */
	// *********************************************************************************************
	public List<IssuemanTicket> getTicketsByRoleCategory(
			RoleCategory roleCategory, IssueType issueType) {

		switch (roleCategory) {
		case ALLIED:
			return getAlliedReportedTickets(issueType);

		case CLIENT:
			return getClientReportedTickets(issueType);

		case MIT:
			return getMitReportedTickets(issueType);

		case EXTQA:
			return getExtQaReportedTickets(issueType);

		case VIRTUSA:
			return getVirtusaReportedTickets(issueType);

		case THINKSOFT:
			return getThinkSoftReportedTickets(issueType);
		default:
			break;
		}
		return null;
	}

	/**
	 * 
	 * @param issueType
	 *            enumeration
	 * @return the tickets reported by role Think soft
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getThinkSoftReportedTickets(IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterByRole(EXTQA_THINKSOFT, ticketList);
	}

	/**
	 * 
	 * @param issueType
	 * @return the tickets reported by role virtusa
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getVirtusaReportedTickets(IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterByRole(EXTQA_VIRTUSA, ticketList);
	}

	/**
	 * 
	 * @param issueType
	 * @returns all the tickets reported by external QAs
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getExtQaReportedTickets(IssueType issueType) {
		List<String> roles = new ArrayList<String>();
		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);

		roles.add(EXTQA_ALLIED);
		roles.add(EXTQA_VIRTUSA);
		roles.add(EXTQA_THINKSOFT);
		roles.add(EXTQA);

		return getTicketsFilterByRole(roles, ticketList, false);
	}

	/**
	 * @param issueType
	 * @returns Allied reported tickets
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getAlliedReportedTickets(IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterByRole(EXTQA_ALLIED, ticketList);
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

		// MIT reported tickets = inverse of the following reported by role list

		roles.add(CLIENT);
		roles.add(CLIENT_ADMIN);
		roles.add(EXTQA);
		roles.add(EXTQA_VIRTUSA);
		roles.add(EXTQA_ALLIED);
		roles.add(EXTQA_THINKSOFT);

		return getTicketsFilterByRole(roles, ticketList, true);
	}

	/**
	 * 
	 * @param issueType
	 * @returns the client reported tickets
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getClientReportedTickets(IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		List<String> roles = new ArrayList<String>();
		roles.add(CLIENT);
		roles.add(CLIENT_ADMIN);

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
	 * @return get the relevant issue list from the class variable according to
	 *         the requested issue type
	 */
	private List<IssuemanTicket> getTicketListForIssueType(IssueType issueType) {

		switch (issueType) {
		case VALID: {
			if (validTickets == null) {
				return getValidTickets();
			}
			return validTickets;
		}

		case INVALID:
			if (invalidTickets == null) {
				return getInvalidTickets();
			}
			return invalidTickets;

		case CURRENTOPEN:
			if (currentOpenTickets == null) {
				return getCurrentOpenTickets();
			}
			return currentOpenTickets;

		case OPEN:
			if (uncopiedTickets == null) {
				return getUncopiedTickets(); // implement a function for this
			}
			return uncopiedTickets;

		case TOTAL:
			if (totalTicketsList == null) {
				return getTotalTickets();
			}
			return totalTicketsList;

		case UNCOPIED:
			if (uncopiedTickets == null) {
				return getUncopiedTickets();
			}
			return uncopiedTickets;

		case COPIED:
			if (copiedTickets == null) {
				return getCopiedTickets();
			}
			return copiedTickets;

		default:
			return totalTicketsList;
		}
	}

	/**
	 * 
	 * @param roleNames
	 *            : criteria to filter(role names )
	 * @param ticketList
	 *            : list to filter
	 * @param invert
	 *            : determines whether to return the inverse of filtered
	 *            tickets. when set to true, returned result set equals to {
	 *            select ticket where ticket.role not in(roleNames)}
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
						userprojectrole); // re-attach to the session

				if (userprojectrole.getUser().getId() == reporterId) {
					String role = userprojectrole.getRole().getName();

					if (invert) {// if complement is needed
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTicketsByRole
	 * (java.lang.String,
	 * com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl
	 * .IssueType)
	 * 
	 * returns the tickets reported by given role and given issueType
	 */
	// *********************************************************************************************
	@Override
	public List<IssuemanTicket> getTicketsByRole(String roleName,
			IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterByRole(roleName, ticketList);
	}

	/**
	 * 
	 * @param ticketList
	 * @param severity
	 * @return returns the the tickets filtered by given severity
	 */
	// *********************************************************************************************
	private List<IssuemanTicket> getTicketsFilterBySeverity(
			List<IssuemanTicket> ticketList, String severity) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket issuemanTicket : ticketList) {
			// ticket is re attached to the session
			issuemanSessionFactory.getCurrentSession().update(issuemanTicket);
			String currentSeverity = issuemanTicket.getCurrentSeverity().get(0)
					.getSeverity().getDescription();

			if (currentSeverity.equals(severity)) {
				filteredTickets.add(issuemanTicket);
			}
		}
		return filteredTickets;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#
	 * getTicketsByRoleCategoryPerSeverity
	 * (com.millenniumit.mx.data.issueman.dao.
	 * impl.IssuemanTicketDaoImpl.RoleCategory,
	 * com.millenniumit.mx.data.issueman
	 * .dao.impl.IssuemanTicketDaoImpl.IssueType, java.lang.String)
	 * 
	 * @returns the tickets filtered by given Role category, issue type and
	 * severity
	 */
	// ********************************************************************************************
	@Override
	public List<IssuemanTicket> getTicketsByRoleCategoryPerSeverity(
			RoleCategory roles, IssueType issueType, String severity) {

		List<IssuemanTicket> ticketList = getTicketsByRoleCategory(roles,
				issueType);

		return getTicketsFilterBySeverity(ticketList, severity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao#getTicketsPerSeverity
	 * (java.lang.String,
	 * com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl
	 * .IssueType)
	 */
	// ********************************************************************************************

	@Override
	public List<IssuemanTicket> getTicketsPerSeverity(String severity,
			IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(issueType);
		return getTicketsFilterBySeverity(ticketList, severity);
	}

	/**
	 * issue lists are refreshed
	 */
	// *********************************************************************************************
	public void refresh() {
		totalTicketsList = null;
		uncopiedTickets = null;
		invalidTickets = null;
		validTickets = null;
		copiedTickets = null;
		currentOpenTickets = null;
	}
}
