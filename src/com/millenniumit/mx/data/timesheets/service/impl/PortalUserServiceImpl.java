/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.PortalUserDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.service.PortalUserService;

/**
 * @author Vimukthi
 *
 */
@Service("portalUserService")
public class PortalUserServiceImpl implements PortalUserService {
	
	@Autowired
	@Qualifier("portalUserDao")
	private PortalUserDao userDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#getUser(java.lang.String)
	 */
	@Override
	@Transactional
	public PortalUser getUser(String email) {
		return getUserDao().getUser(email);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#getUsers()
	 */
	@Override
	@Transactional
	public List<PortalUser> getUsers() {
		return getUserDao().getUsers();
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#getNonTimeSheetsUsers()
	 */
	@Override
	@Transactional
	public List<PortalUser> getNonTimeSheetsUsers() {
		return getUserDao().getNonTimeSheetsUsers();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#getUsers(int, int)
	 */
	@Override
	@Transactional
	public List<PortalUser> getUsers(int offset, int limit) {
		return getUserDao().getUsers(offset, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#getUsersCount()
	 */
	@Override
	@Transactional
	public Long getUsersCount() {
		return getUserDao().getUsersCount();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#saveUser(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public void saveUser(PortalUser user) {
		getUserDao().save(user);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserService#saveUser(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public void deleteUser(PortalUser user) {
		getUserDao().delete(user);
	}

	/**
	 * @return the userDao
	 */
	public PortalUserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao the userDao to set
	 */
	public void setUserDao(PortalUserDao userDao) {
		this.userDao = userDao;
	}
}
