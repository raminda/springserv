/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.Date;
import java.util.List;

import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.IssueType;
import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.RoleCategory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * 
 * @author Kalpag
 * 
 */

public interface IssuemanTicketService2 {


	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getValidTickets(long projectId, long type,
			long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type,
			long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getUncopiedTickets(long projectId, long type,
			long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId,
			long type, long subType, Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roleCategory
	 * @param issueType
	 * @return
	 */
	public List<IssuemanTicket> getTicketsByRoleCategory(long projectId,
			long type, long subType, Date from, Date to, RoleCategory roleCategory,
			IssueType issueType);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roleName
	 * @param issueType
	 * @return
	 */
	public List<IssuemanTicket> getTicketsByRole(long projectId, long type,
			long subType, Date from, Date to, String roleName,
			IssueType issueType);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roleCategory
	 * @param issueType
	 * @param severity
	 * @return
	 */
	public List<IssuemanTicket> getTicketsByRoleCategoryPerSeverity(
			long projectId, long type, long subType, Date from, Date to,
			RoleCategory roleCategory, IssueType issueType, String severity);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param severity
	 * @param issueType
	 * @return
	 */
	public List<IssuemanTicket> getTicketsPerSeverity(long projectId,
			long type, long subType, Date from, Date to, String severity,
			IssueType issueType);
}
