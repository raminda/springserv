/**
 * 
 */
package com.millenniumit.mx.data.issueman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.issueman.dao.IssuemanReleaseFieldCurrentDao;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanReleaseFieldCurrent;
import com.millenniumit.mx.data.issueman.service.IssuemanReleaseFieldCurrentService;

/**
 * @author Kalpag
 * 
 */
@Service("issuemanReleaseFieldCurrentService")
public class IssuemanReleaseFieldCurrentServiceImpl implements
		IssuemanReleaseFieldCurrentService {

	@Autowired
	@Qualifier("issuemanReleaseFieldCurrentDao")
	private IssuemanReleaseFieldCurrentDao issuemanReleaseFieldCurrentDao;

	@Transactional
	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent(
			int offset, int limit) {
		return issuemanReleaseFieldCurrentDao.getIssuemanReleaseFieldCurrent(
				offset, limit);
	}

	@Transactional
	public List<IssuemanReleaseFieldCurrent> getIssuemanReleaseFieldCurrent() {
		return issuemanReleaseFieldCurrentDao.getIssuemanReleaseFieldCurrent();
	}

}
