/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.Date;
import java.util.List;

import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.IssueType;
import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.RoleCategory;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * 
 * @author Kalpag
 * 
 */
public interface IssuemanTicketDao {

	public List<IssuemanTicket> getInvalidTickets();

	public List<IssuemanTicket> getValidTickets();

	public void Init(long projectId, long type, long subType, Date from, Date to);

	public List<IssuemanTicket> getCopiedTickets();

	public List<IssuemanTicket> getTotalTickets();

	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to);

	public List<IssuemanTicket> getUncopiedTickets();

	public List<IssuemanTicket> getCurrentOpenTickets();

	public List<IssuemanTicket> getCurrentOpenTicketsByRole(String roleName);

	public List<IssuemanTicket> getValidTicketsByRole(String roleName);

	public List<IssuemanTicket> getInvalidTicketsByRole(String roleName);

	public List<IssuemanTicket> getUncopiedTicketsByRole(String roleName);

	public List<IssuemanTicket> getTotalTicketsByRole(String roleName);
	
	public List<IssuemanTicket> getTicketsByRoleCategory(RoleCategory roles,
			IssueType issueType);

}
