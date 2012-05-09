/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketTypeDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService;

/**
 * 
 * @author kalpag
 *
 */
@Service("issuemanTicketTypeService")
public class IssuemanTicketTypeServiceImpl implements IssuemanTicketTypeService {

	
	@Autowired
	@Qualifier("issuemanTicketTypeDao")
	private IssuemanTicketTypeDao issuemanTicketTypeDao;
	
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService#getIssuemanTicketTypeServices()
	 */
	@Transactional
	public List<IssuemanTicketType> getIssuemanTicketTypes() {
		return issuemanTicketTypeDao.getIssuemanTicketTypes() ;
	}


	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService#getIssuemanTicketSubTypes(com.millenniumit.mx.data.issueman.domain.IssuemanTicketType)
	 */
	@Transactional
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			IssuemanTicketType issuemanTicketType) {
		return issuemanTicketTypeDao
				.getIssuemanTicketSubTypes(issuemanTicketType);
	}


	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService#getIssuemanTicketSubTypes()
	 */
	@Transactional
	public List<IssuemanTicketType> getIssuemanTicketSubTypes() {
		return issuemanTicketTypeDao.getIssuemanTicketSubTypes();
	}


	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService#getIssuemanTicketSubTypes(java.lang.String)
	 */
	@Transactional
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			String issuemanTicketTypeName) {
		return issuemanTicketTypeDao.getIssuemanTicketSubTypes(issuemanTicketTypeName);
	}




}
