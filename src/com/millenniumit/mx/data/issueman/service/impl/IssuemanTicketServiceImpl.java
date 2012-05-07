/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanStatusFieldHistory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketLink;
import com.millenniumit.mx.data.issueman.domain.IssuemanUserProjectRole;

import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;

/**
 * 
 * @author Kalpag
 * 
 */

@Service("issuemanTicketService")
public class IssuemanTicketServiceImpl implements IssuemanTicketService {
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



	private List<IssuemanTicket> totalTicketsList = null;
	private List<IssuemanTicket> uncopiedTickets = null;
	private List<IssuemanTicket> invalidTickets = null;
	private List<IssuemanTicket> validTickets = null;
	private List<IssuemanTicket> copiedTickets = null;
	private List<IssuemanTicket> currentOpenTickets = null;

	private List<IssuemanUserProjectRole> userProjectRoles = null;

	@Autowired
	@Qualifier("issuemanTicketDao")
	private IssuemanTicketDao issuemanTicketDao;

	/**
	 * @return the issuemanTicketDao
	 */
	public IssuemanTicketDao getIssuemanTicketDao() {
		return issuemanTicketDao;
	}

	/**
	 * @param issuemanTicketDao
	 *            the issuemanTicketDao to set
	 */
	public void setIssuemanTicketDao(IssuemanTicketDao issuemanTicketDao) {
		this.issuemanTicketDao = issuemanTicketDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTotalTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to) {

		if (totalTicketsList == null) {
			totalTicketsList = issuemanTicketDao.getTotalTickets(projectId,
					type, subType, from, to);
		}

		return totalTicketsList;
	}

	// *********************************************************************************************
	/**
	 * 
	 */
	@Transactional
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to) {

		invalidTickets = new ArrayList<IssuemanTicket>();
		setTotalTickets(projectId, type, subType, from, to);
		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType,
					from, to);
		}

		String currentStatus = null;
		for (IssuemanTicket ticket : uncopiedTickets) {
			// re attach tickets to the session
			issuemanTicketDao.updateSession(ticket);
			currentStatus = ticket.getCurrentStatus().get(0).getStatus()
					.getName();
			List<IssuemanStatusFieldHistory> statusHistory = ticket
					.getStatusHistory();

			boolean invalidHistory = false;
			for (IssuemanStatusFieldHistory issuemanStatusFieldHistory : statusHistory) {
				String oldStatus = issuemanStatusFieldHistory.getOldStatus()
						.getName();
				String newStatus = issuemanStatusFieldHistory.getNewStatus()
						.getName();

				if (oldStatus.equals(DUPLICATE) && newStatus.equals(CLOSED)) {
					invalidHistory = true;
				}
			}

			if ((currentStatus.equals(DUPLICATE) || currentStatus
					.equals(CANCELLED)) || invalidHistory) {
				invalidTickets.add(ticket);
			}
		}
		System.out.println("no of invalid tickets = " + invalidTickets.size());
		return invalidTickets;
	}

	// *********************************************************************************************
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getValidTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getValidTickets(long projectId, long type,
			long subType, Date from, Date to) {
		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets(projectId, type, subType, from,
					to);
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType,
					from, to);
		}

		validTickets = uncopiedTickets;
		validTickets.removeAll(invalidTickets);
		System.out.println("size of valid tickets = " + validTickets.size());
		return validTickets;
	}

	// *********************************************************************************************
	/**
 * 
 */
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type,
			long subType, Date from, Date to) {

		copiedTickets = new ArrayList<IssuemanTicket>();
		System.out
				.println("Size of total tickets = " + totalTicketsList.size());

		if (totalTicketsList == null) {
			totalTicketsList = issuemanTicketDao.getTotalTickets(projectId,
					type, subType, from, to);
		}

		for (IssuemanTicket ticket : totalTicketsList) {
			issuemanTicketDao.updateSession(ticket); // consider changing this
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

	/**
	 * 
	 * @return
	 */
	public List<IssuemanTicket> getUncopiedTickets(long projectId, long type,
			long subType, Date from, Date to) {

		setTotalTickets(projectId, type, subType, from, to);
		if (copiedTickets == null) {
			copiedTickets = getCopiedTickets(projectId, type, subType, from, to);
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = totalTicketsList;
			uncopiedTickets.removeAll(copiedTickets);
		}

		System.out.println("Size of uncopied tickets = "
				+ uncopiedTickets.size());
		return uncopiedTickets;
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getCurrentOpenTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId,
			long type, long subType, Date from, Date to) {
		currentOpenTickets = new ArrayList<IssuemanTicket>();

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType,
					from, to);
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

	// *********************************************************************************************

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 */
	private void setTotalTickets(long projectId, long type, long subType,
			Date from, Date to) {

		if (totalTicketsList == null) {
			totalTicketsList = issuemanTicketDao.getTotalTickets(projectId,
					type, subType, from, to);
		}

		if (userProjectRoles == null) {
			userProjectRoles = issuemanTicketDao.getUserProjectRoles(projectId);
		}
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsByRoleCategory
	 * (com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl
	 * .RoleCategory)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsByRoleCategory(long projectId,
			long type, long subType, Date from, Date to,
			RoleCategory roleCategory, IssueType issueType) {

		if (userProjectRoles == null) {
			userProjectRoles = issuemanTicketDao.getUserProjectRoles(projectId);
		}

		switch (roleCategory) {
		case ALLIED:
			return getAlliedReportedTickets(projectId, type, subType, from, to,
					issueType);

		case CLIENT:
			return getClientReportedTickets(projectId, type, subType, from, to,
					issueType);

		case MIT:
			return getMitReportedTickets(projectId, type, subType, from, to,
					issueType);

		case EXTQA:
			return getExtQaReportedTickets(projectId, type, subType, from, to,
					issueType);

		case VIRTUSA:
			return getVirtusaReportedTickets(projectId, type, subType, from,
					to, issueType);

		case THINKSOFT:
			return getThinkSoftReportedTickets(projectId, type, subType, from,
					to, issueType);
		default:
			break;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsByRole(java.lang.String,
	 * com.millenniumit.mx.data.issueman.dao.impl
	 * .IssuemanTicketDaoImpl.IssueType)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsByRole(long projectId, long type,
			long subType, Date from, Date to, String roleName,
			IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(subType,
				subType, subType, to, to, issueType);
		return getTicketsFilterByRole(roleName, ticketList);
	}
    //*********************************************************************************************
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsByRoleCategoryPerSeverity
	 * (com.millenniumit.mx.data.issueman.dao.
	 * impl.IssuemanTicketDaoImpl.RoleCategory,
	 * com.millenniumit.mx.data.issueman
	 * .dao.impl.IssuemanTicketDaoImpl.IssueType, java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsByRoleCategoryPerSeverity(
			long projectId, long type, long subType, Date from, Date to,
			RoleCategory roles, IssueType issueType, String severity) {

		List<IssuemanTicket> ticketList = getTicketsByRoleCategory(subType,
				subType, subType, to, to, roles, issueType);
		return getTicketsFilterBySeverity(ticketList, severity);
	}
    //*********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsPerSeverity(java.lang.String,
	 * com.millenniumit.mx.data.issueman.
	 * dao.impl.IssuemanTicketDaoImpl.IssueType)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsPerSeverity(long projectId,
			long type, long subType, Date from, Date to, String severity,
			IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(subType, subType, subType, to, to, issueType);
		return getTicketsFilterBySeverity(ticketList, severity);

	}

	// *********************************************************************************************

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param issueType
	 * @return
	 */
	private List<IssuemanTicket> getAlliedReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId,
				type, subType, from, to, issueType);
		return getTicketsFilterByRole(EXTQA_ALLIED, ticketList);
	}

	// *********************************************************************************************
	/**
	 * 
	 * @param issueType
	 * @return the tickets reported by role virtusa
	 */
	private List<IssuemanTicket> getVirtusaReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(subType,
				subType, subType, to, to, issueType);
		return getTicketsFilterByRole(EXTQA_VIRTUSA, ticketList);
	}

	// *********************************************************************************************

	/**
	 * 
	 * @param issueType
	 * @returns all the tickets reported by external QAs
	 */

	private List<IssuemanTicket> getExtQaReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<String> roles = new ArrayList<String>();
		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId,
				type, subType, from, to, issueType);

		roles.add(EXTQA_ALLIED);
		roles.add(EXTQA_VIRTUSA);
		roles.add(EXTQA_THINKSOFT);
		roles.add(EXTQA);

		return getTicketsFilterByRole(roles, ticketList, false);
	}

	// *********************************************************************************************

	/**
	 * 
	 * @param issueType
	 * @returns MIT reported Tickets
	 */
	private List<IssuemanTicket> getMitReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId,
				type, subType, from, to, issueType);
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

	// *********************************************************************************************

	/**
	 * @param issueType
	 * @returns the client reported tickets
	 */

	private List<IssuemanTicket> getClientReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId,
				type, subType, from, to, issueType);
		List<String> roles = new ArrayList<String>();
		roles.add(CLIENT);
		roles.add(CLIENT_ADMIN);

		return getTicketsFilterByRole(roles, ticketList, false);
	}

	// *********************************************************************************************

	/**
	 * 
	 * @param issueType
	 *            enumeration
	 * @return the tickets reported by role Think soft
	 */

	private List<IssuemanTicket> getThinkSoftReportedTickets(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(subType,
				subType, subType, to, to, issueType);
		return getTicketsFilterByRole(EXTQA_THINKSOFT, ticketList);
	}

	// *********************************************************************************************

	/**
	 * 
	 * @param issueType
	 * @return
	 */
	private List<IssuemanTicket> getTicketListForIssueType(long projectId,
			long type, long subType, Date from, Date to, IssueType issueType) {

		switch (issueType) {
		case VALID: {
			if (validTickets == null) {
				return getValidTickets(projectId, type, subType, from, to);
			}
			return validTickets;
		}

		case INVALID:
			if (invalidTickets == null) {
				return getInvalidTickets(projectId, type, subType, from, to);
			}
			return invalidTickets;

		case CURRENTOPEN:
			if (currentOpenTickets == null) {
				return getCurrentOpenTickets(projectId, type, subType, from, to);
			}
			return currentOpenTickets;

		case OPEN:
			if (uncopiedTickets == null) {
				return getUncopiedTickets(projectId, type, subType, from, to); // **********
			}
			return uncopiedTickets;

		case TOTAL:
			if (totalTicketsList == null) {
				return getTotalTickets(projectId, type, subType, from, to);
			}
			return totalTicketsList;

		case UNCOPIED:
			if (uncopiedTickets == null) {
				return getUncopiedTickets(projectId, type, subType, from, to);
			}
			return uncopiedTickets;

		case COPIED:
			if (copiedTickets == null) {
				return getCopiedTickets(projectId, type, subType, from, to);
			}
			return copiedTickets;

		default:
			return totalTicketsList;
		}
	}

	/**
	 * @param roleName
	 * @param ticketList
	 * @return
	 */
	// *********************************************************************************************

	private List<IssuemanTicket> getTicketsFilterByRole(String roleName,
			List<IssuemanTicket> ticketList) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket ticket : ticketList) {
			issuemanTicketDao.updateSession(ticket);
			long reporterId = ticket.getReporter().getId();

			for (IssuemanUserProjectRole userprojectrole : userProjectRoles) {
				issuemanTicketDao.updateSession(userprojectrole);

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

	// *********************************************************************************************
	/**
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

	/**
	 * 
	 * @param ticketList
	 * @param severity
	 * @return returns the the tickets filtered by given severity
	 */
	private List<IssuemanTicket> getTicketsFilterBySeverity(
			List<IssuemanTicket> ticketList, String severity) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket issuemanTicket : ticketList) {
			// ticket is re attached to the session
			issuemanTicketDao.updateSession(issuemanTicket);
			String currentSeverity = issuemanTicket.getCurrentSeverity().get(0)
					.getSeverity().getDescription();

			if (currentSeverity.equals(severity)) {
				filteredTickets.add(issuemanTicket);
			}
		}
		return filteredTickets;
	}

	// *********************************************************************************************

	/**
	 * 
	 * @param roleNames
	 * @param ticketList
	 * @param invert
	 * @return
	 */
	private List<IssuemanTicket> getTicketsFilterByRole(List<String> roleNames,
			List<IssuemanTicket> ticketList, boolean invert) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket ticket : ticketList) {
			issuemanTicketDao.updateSession(ticket);
			long reporterId = ticket.getReporter().getId();

			for (IssuemanUserProjectRole userprojectrole : userProjectRoles) {
				issuemanTicketDao.updateSession(userprojectrole); // re-attach
																	// to the
																	// session

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
}
