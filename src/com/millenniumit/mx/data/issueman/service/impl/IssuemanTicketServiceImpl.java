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
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;

/**
 * 
 * @author Kalpag
 * 
 */

@Service("issuemanTicketService")
public class IssuemanTicketServiceImpl implements IssuemanTicketService {


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.service.IssuemanTicketService#Init()
	 */
	@Transactional
	public void Init(long projectId, long type, long subType, Date from, Date to) {
		issuemanTicketDao.Init(projectId, type, subType, from, to);
	}

	@Autowired
	@Qualifier("issuemanTicketDao")
	private IssuemanTicketDao issuemanTicketDao;


	@Transactional
	public List<IssuemanTicket> getInvalidTickets() {
		return issuemanTicketDao.getInvalidTickets();
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

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getTotalTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getTotalTickets() {
		// TODO Auto-generated method stub
		return issuemanTicketDao.getTotalTickets();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getValidTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getValidTickets() {
		return issuemanTicketDao.getValidTickets();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getCopiedTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getCopiedTickets() {
		return issuemanTicketDao.getCopiedTickets();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getUncopiedTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getUncopiedTickets() {
		return issuemanTicketDao.getUncopiedTickets();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getCurrentOpenTickets()
	 */
	@Transactional
	public List<IssuemanTicket> getCurrentOpenTickets() {
		return issuemanTicketDao.getCurrentOpenTickets();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getCurrentOpenTicketsByRole(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getCurrentOpenTicketsByRole(String roleName) {
		return issuemanTicketDao.getCurrentOpenTicketsByRole(roleName);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getValidTicketsByRole(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getValidTicketsByRole(String roleName) {
		return issuemanTicketDao.getValidTicketsByRole(roleName);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getInvalidTicketsByRole(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getInvalidTicketsByRole(String roleName) {
		return issuemanTicketDao.getInvalidTicketsByRole(roleName);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getUncopiedTicketsByRole(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getUncopiedTicketsByRole(String roleName) {
		return issuemanTicketDao.getUncopiedTicketsByRole(roleName);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketService#getTotalTicketsByRole(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicket> getTotalTicketsByRole(String roleName) {
		return issuemanTicketDao.getTotalTicketsByRole(roleName);
	}
}
