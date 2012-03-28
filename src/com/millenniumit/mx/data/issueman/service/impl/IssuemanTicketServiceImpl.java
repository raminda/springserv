/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.Date;
import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;

/**
 * 
 * @author Kalpag
 *
 */

public class IssuemanTicketServiceImpl implements IssuemanTicketService {
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 	
	 */
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(IssuemanProject project,
			int type, int subType, Date from, Date to, boolean clientCopied) {
		
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getTicketsGroupByWeek(int, int)
	 */
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
