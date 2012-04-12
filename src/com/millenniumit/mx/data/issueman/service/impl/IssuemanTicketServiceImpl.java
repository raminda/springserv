/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;

/**
 * 
 * @author Kalpag
 * 
 */

@Service("issuemanTicketService")
public class IssuemanTicketServiceImpl implements IssuemanTicketService {

	@Autowired
	@Qualifier("issuemanTicketDao")
	private IssuemanTicketDao issuemanTicketDao;

	@Transactional
	public List<IssuemanTicket> getTicketsGroupByWeek() {
		return issuemanTicketDao.getTicketsGroupByWeek();
	}

	@Transactional
	public List<IssuemanTicket> getTotalTickets(long projectId, long type,
			long subType, Date from, Date to) {
		return issuemanTicketDao.getTotalTickets(projectId, type, subType,
				from, to);
	}

	@Transactional
	public List<IssuemanTicket> getTotalTickets(int offset, int limit) {
		return issuemanTicketDao.getTicketsGroupByWeek(offset, limit);
	}

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

	@Transactional
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type,
			long subType, Date from, Date to) {
		return issuemanTicketDao.getCopiedTickets(projectId, type, subType,
				from, to);
	}

	@Transactional
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId,
			long type, long subType, Date from, Date to) {

		return issuemanTicketDao.getCurrentOpenTickets(projectId, type,
				subType, from, to);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getInvalidTickets(long, long, long, java.util.Date, java.util.Date)
	 */
	@Transactional
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type,
			long subType, Date from, Date to) {
		return issuemanTicketDao.getInvalidTickets(projectId, type, subType, from, to);
	}
}
