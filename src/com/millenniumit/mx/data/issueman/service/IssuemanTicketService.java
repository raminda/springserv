/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.Date;
import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * 
 * @author Kalpag
 * 
 */

public interface IssuemanTicketService {
	public List<IssuemanTicket> getTicketsGroupByWeek();
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit);
	public List<IssuemanTicket> getTicketsGroupByWeek(IssuemanProject project,
			int type, int subType, Date from, Date to, boolean clientCopied);
}
