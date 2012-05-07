/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.Date;
import java.util.List;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanUserProjectRole;

/**
 * 
 * @author Kalpag
 * 
 */
public interface IssuemanTicketDao {

	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to);

	public List<IssuemanUserProjectRole> getUserProjectRoles(long projectId) ;
	public void updateSession(Object object);
}
