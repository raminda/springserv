/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
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
	private static String REJECTED = "REJECTED";
	private static String CLOSED = "CLOSED";
	private static String OPEN = "OPEN";

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

	// *********************************************************************************************

	/**
	 * @param issuemanTicketDao
	 *            the issuemanTicketDao to set
	 */
	public void setIssuemanTicketDao(IssuemanTicketDao issuemanTicketDao) {
		this.issuemanTicketDao = issuemanTicketDao;
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTotalTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getTotalTickets(long projectId, long type, long subType, Date from,
			Date to) {

		if (totalTicketsList == null) {
			totalTicketsList = issuemanTicketDao
					.getTotalTickets(projectId, type, subType, from, to);
		}
		System.out.println("Total Tickets = " + totalTicketsList.size());
		return totalTicketsList;
	}

	// *********************************************************************************************

	/**
	 * 
	 */
	@Transactional
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type, long subType,
			Date from, Date to) {

		invalidTickets = new ArrayList<IssuemanTicket>();
		setTotalTickets(projectId, type, subType, from, to);
		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType, from, to);
		}

		String currentStatus = null;
		for (IssuemanTicket ticket : uncopiedTickets) {
			// re attach tickets to the session
			issuemanTicketDao.updateSession(ticket);
			currentStatus = ticket.getCurrentStatus().get(0).getStatus().getName();
			List<IssuemanStatusFieldHistory> statusHistory = ticket.getStatusHistory();

			boolean invalidHistory = false;
			for (IssuemanStatusFieldHistory issuemanStatusFieldHistory : statusHistory) {
				String oldStatus = issuemanStatusFieldHistory.getOldStatus().getName();
				String newStatus = issuemanStatusFieldHistory.getNewStatus().getName();

				if ((oldStatus.equals(DUPLICATE) && newStatus.equals(CLOSED))
						|| (oldStatus.equals(REJECTED) && newStatus.equals(CLOSED))) {
					// if last transition state is rejected to closed or
					// duplicate to closed
					invalidHistory = true;
				}
			}

			// if current status is duplicate cancelled or rejected
			if ((currentStatus.equals(DUPLICATE) || currentStatus.equals(CANCELLED))
					|| currentStatus.equals(REJECTED) || invalidHistory) {
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
	public List<IssuemanTicket> getValidTickets(long projectId, long type, long subType, Date from,
			Date to) {
		if (invalidTickets == null) {
			invalidTickets = getInvalidTickets(projectId, type, subType, from, to);
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType, from, to);
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
	@Transactional
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type, long subType,
			Date from, Date to) {

		copiedTickets = new ArrayList<IssuemanTicket>();

		if (totalTicketsList == null) {
			totalTicketsList = getTotalTickets(projectId, type, subType, from, to);
		}

		System.out.println("Size of total tickets = " + totalTicketsList.size());

		for (IssuemanTicket ticket : totalTicketsList) {
			issuemanTicketDao.updateSession(ticket); // consider changing this
			List<IssuemanTicketLink> ticketLinks = ticket.getTicketLinks();

			for (IssuemanTicketLink issuemanTicketLink : ticketLinks) {
				String linkType = issuemanTicketLink.getTicketLinkType().getName();

				if (linkType.equals(PLATFORM) || linkType.equals(COPIED_FROM)
						|| linkType.equals(CLONERS)) {
					copiedTickets.add(ticket);
				}
			}
		}
		System.out.println("Size of copied issues =" + copiedTickets.size());
		return copiedTickets;
	}

	// *********************************************************************************************

	/**
	 * 
	 * @return
	 */
	public List<IssuemanTicket> getUncopiedTickets(long projectId, long type, long subType,
			Date from, Date to) {

		setTotalTickets(projectId, type, subType, from, to);
		if (copiedTickets == null) {
			copiedTickets = getCopiedTickets(projectId, type, subType, from, to);
		}

		if (uncopiedTickets == null) {
			uncopiedTickets = totalTicketsList;
			uncopiedTickets.removeAll(copiedTickets);
		}

		System.out.println("Size of uncopied tickets = " + uncopiedTickets.size());
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
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId, long type, long subType,
			Date from, Date to) {
		currentOpenTickets = new ArrayList<IssuemanTicket>();

		if (uncopiedTickets == null) {
			uncopiedTickets = getUncopiedTickets(projectId, type, subType, from, to);
		}

		for (IssuemanTicket ticket : uncopiedTickets) {
			issuemanTicketDao.updateSession(ticket);
			String currentStatus = ticket.getCurrentStatus().get(0).getStatus().getName();

			if (currentStatus.equals(OPEN)) {
				currentOpenTickets.add(ticket);
			}
		}

		System.out.println("size of currently open tickets list =" + currentOpenTickets.size());
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
	private void setTotalTickets(long projectId, long type, long subType, Date from, Date to) {

		if (totalTicketsList == null) {
			totalTicketsList = issuemanTicketDao
					.getTotalTickets(projectId, type, subType, from, to);
		}

		if (userProjectRoles == null) {
			userProjectRoles = issuemanTicketDao.getUserProjectRoles(projectId);
		}
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
	 * @param roles
	 * @param invert
	 * @return
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsByRoles(long projectId, long type, long subType,
			Date from, Date to, IssueType issueType, List<String> roles, boolean invert) {

		if (userProjectRoles == null) {
			userProjectRoles = issuemanTicketDao.getUserProjectRoles(projectId);
		}

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId, type, subType, from,
				to, issueType);
		return getTicketsFilterByRole(roles, ticketList, invert);
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsByRole(java.lang.String,
	 * com.millenniumit.mx.data.issueman.dao.impl
	 * .IssuemanTicketDaoImpl.IssueType)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsByRole(long projectId, long type, long subType,
			Date from, Date to, String roleName, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId, type, subType, from,
				to, issueType);

		if (roleName.toUpperCase().equals("ALL")) {
			return ticketList;
		}

		return getTicketsFilterByRole(roleName, ticketList);
	}

	// *********************************************************************************************
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
	public List<IssuemanTicket> getTicketsByRolesPerSeverity(long projectId, long type,
			long subType, Date from, Date to, IssueType issueType, List<String> roles,
			boolean invertRoles, String severity) {

		List<IssuemanTicket> ticketList = getTicketsByRoles(projectId, type, subType, from, to,
				issueType, roles, invertRoles);
		return getTicketsFilterBySeverity(ticketList, severity);
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsPerSeverity(java.lang.String,
	 * com.millenniumit.mx.data.issueman.
	 * dao.impl.IssuemanTicketDaoImpl.IssueType)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsPerSeverity(long projectId, long type, long subType,
			Date from, Date to, String severity, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketListForIssueType(projectId, type, subType, from,
				to, issueType);
		return getTicketsFilterBySeverity(ticketList, severity);
	}

	// *********************************************************************************************

	// if tickets reported by all is needed pass "all" for role parameter
	@Transactional
	public Map<String, Integer> getTicketsCountByRole(long projectId, long type, long subType,
			Date from, Date to, String role, IssueType issueType) {

		List<IssuemanTicket> ticketList = getTicketsByRole(projectId, type, subType, from, to,
				role, issueType);
		return getTicketCountGroupByWeek(ticketList);
	}

	// *********************************************************************************************

	/**
	 * 
	 */
	@Transactional
	public Map<String, Integer> getTicketsCountByRoles(long projectId, long type, long subType,
			Date from, Date to, List<String> roles, IssueType issueType, boolean invert) {

		List<IssuemanTicket> ticketList = getTicketsByRoles(projectId, type, subType, from, to,
				issueType, roles, invert);

		return getTicketCountGroupByWeek(ticketList);
	}

	// *********************************************************************************************
	// if tickets reported by all is needed pass "all" for role parameter
	@Transactional
	public Map<String, Integer> getTicketsCountByRolePerSeverity(long projectId, long type,
			long subType, Date from, Date to, String role, IssueType issueType, String severity) {

		List<IssuemanTicket> ticketList = getTicketsByRole(projectId, type, subType, from, to,
				role, issueType);
		List<IssuemanTicket> tickets = getTicketsFilterBySeverity(ticketList, severity);

		return getTicketCountGroupByWeek(tickets);
	}

	// *********************************************************************************************

	/**
	 * 
	 */
	@Transactional
	public Map<String, Integer> getTicketsCountByRolesPerSeverity(long projectId, long type,
			long subType, Date from, Date to, List<String> roles, IssueType issueType,
			String severity, boolean invertRoles) {

		List<IssuemanTicket> ticketList = getTicketsByRoles(projectId, type, subType, from, to,
				issueType, roles, invertRoles);
		List<IssuemanTicket> tickets = getTicketsFilterBySeverity(ticketList, severity);

		return getTicketCountGroupByWeek(tickets);
	}

	// *********************************************************************************************
	/**
	 * 
	 * @param ticketList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Integer> getTicketCountGroupByWeek(List<IssuemanTicket> ticketList) {
		MultiMap multiMap = new MultiHashMap();

		// iterates the ticket list ordered by week and year
		for (IssuemanTicket issuemanTicket : ticketList) {
			Timestamp reportedDate = issuemanTicket.getReportedDate();
			Calendar c = Calendar.getInstance();
			c.setTime(reportedDate);
			int weekofYear = c.get(Calendar.WEEK_OF_YEAR);
			int year = c.get(Calendar.YEAR);
			String yearweek = year + "-" + weekofYear;
			multiMap.put(yearweek, issuemanTicket);
		}

		// System.out.println("Multimap ===     *************************");
		// PrintMap(multiMap);

		// multi map is iterated and no of issues are set as values
		// key-> (week+year) , value->(no of tickets)
		Map<String, Integer> ticketsMap = new HashMap<String, Integer>();
		Set<String> keySet = multiMap.keySet();
		Iterator<String> keyIterator = keySet.iterator();

		while (keyIterator.hasNext()) {
			String key = (String) keyIterator.next(); // year + weekno
			List<IssuemanTicket> values = (List<IssuemanTicket>) multiMap.get(key);
			ticketsMap.put(key, values.size()); // no of issues per week
		}
		return ticketsMap;
	}

	// *********************************************************************************************

	/* Tentative */// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "unused" })
	private void PrintMap(Map<String, Integer> map) {
		Iterator<String> iterator = map.keySet().iterator();

		int count = 0;
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			// int value = map.get(key);
			// count += value;
			System.out.println("key = " + key /* + "  " + " value = " + value */);
		}
		// System.out.println("Total Value = " + count);
	}

	/* Tentative */// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	private List<IssuemanTicket> getTicketListForIssueType(long projectId, long type, long subType,
			Date from, Date to, IssueType issueType) {

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
	 * 
	 * @param ticketList
	 * @param severity
	 * @return returns the the tickets filtered by given severity
	 */
	private List<IssuemanTicket> getTicketsFilterBySeverity(List<IssuemanTicket> ticketList,
			String severity) {

		List<IssuemanTicket> filteredTickets = new ArrayList<IssuemanTicket>();

		for (IssuemanTicket issuemanTicket : ticketList) {
			// ticket is re attached to the session
			issuemanTicketDao.updateSession(issuemanTicket);
			String currentSeverity = issuemanTicket.getCurrentSeverity().get(0).getSeverity()
					.getDescription();

			if (currentSeverity.equals(severity)) {
				filteredTickets.add(issuemanTicket);
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

	// *********************************************************************************************

	/**
	 * 
	 */
	@Transactional
	public void resetSession() {

		totalTicketsList = null;
		uncopiedTickets = null;
		invalidTickets = null;
		validTickets = null;
		copiedTickets = null;
		currentOpenTickets = null;
	}

	// *********************************************************************************************

	/**
 * 
 */
	@Transactional
	public Float getDSI(int critical, int high, int medium, int low, int total) {

		if (total < 1)
			return (float) 0.0;

		float dsi = ((5 * critical) + (3 * high) + (2 * medium) + low) / total;
		return dsi;
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getDRE
	 * (int, int, int)
	 */
	@Transactional
	public Float getDRE(int mitValid, int extQaValid, int total) {

		if (total < 1) {
			return (float) 0.0;
		}

		float dre = ((mitValid + extQaValid) / total) * 100;
		return dre;
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getDRR
	 * (int, int)
	 */
	@Transactional
	public Float getDRR(int valid, int invalid) {
		int total = valid + invalid;

		if (total < 1)
			return (float) 0.0;

		float drr = valid / total;
		return drr;
	}

	// *********************************************************************************************

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTotalTicketsPerTbdir(long, long, long, java.util.Date, java.util.Date,
	 * java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getTotalTicketsPerTbdir(long projectId, long type, long subType,
			Date from, Date to, String tbdir) {
		return issuemanTicketDao.getTotalTicketsPerTbdir(projectId, type, subType, from, to, tbdir);
	}

}
