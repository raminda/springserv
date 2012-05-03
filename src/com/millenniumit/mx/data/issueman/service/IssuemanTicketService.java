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

public interface IssuemanTicketService {

	public void Init(long projectId, long type, long subType, Date from, Date to);

	public List<IssuemanTicket> getInvalidTickets();

	public List<IssuemanTicket> getTotalTickets();

	public List<IssuemanTicket> getValidTickets();

	public List<IssuemanTicket> getCopiedTickets();

	public List<IssuemanTicket> getUncopiedTickets();

	public List<IssuemanTicket> getCurrentOpenTickets();

	public List<IssuemanTicket> getTicketsByRoleCategory(RoleCategory roles,
			IssueType issueType);

	public List<IssuemanTicket> getTicketsByRole(String roleName,
			IssueType issueType);
	
	public List<IssuemanTicket> getTicketsByRoleCategoryPerSeverity(
			RoleCategory roles, IssueType issueType, String severity);
	
	public List<IssuemanTicket> getTicketsPerSeverity(String severity, IssueType issueType);
}
