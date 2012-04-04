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
	public List<IssuemanTicket> getTicketsGroupByWeek(IssuemanProject project,
			int type, int subType, Date from, Date to, boolean clientCopied) {
		return issuemanTicketDao.getTicketsGroupByWeek(project, type, subType,
				from, to, clientCopied);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#
	 * getTicketsGroupByWeek(int, int)
	 */
	@Transactional
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
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
}
