/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.Date;
import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * 
 * @author Kalpag
 *
 */
public interface IssuemanTicketDao {
	public List<IssuemanTicket> getTicketsGroupByWeek();
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit);
	public List<IssuemanTicket> getTotalTickets(long projectId,
			long type, long subType, Date from, Date to);
	
	public List<IssuemanTicket> getCopiedTickets(long projectId,
			long type, long subType, Date from, Date to);
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId, long type,
			long subType, Date from, Date to);
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to);
}
