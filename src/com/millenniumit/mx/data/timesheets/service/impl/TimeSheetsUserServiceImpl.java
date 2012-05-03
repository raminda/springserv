package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService;

/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 * 
 */
@Service("timeSheetsUserService")
public class TimeSheetsUserServiceImpl implements TimeSheetsUserService {
	
	@Autowired
	@Qualifier("timeSheetsUserDao")
	private TimeSheetsUserDao timeSheetsUserDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#getTimeSheetsUser(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public TimeSheetsUser getTimeSheetsUser(PortalUser user) {
		return getTimeSheetsUserDao().getTimeSheetsUser(user);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#getTimeSheetsUsers()
	 */
	@Override
	@Transactional
	public List<TimeSheetsUser> getTimeSheetsUsers() {
		return getTimeSheetsUserDao().getTimeSheetsUsers();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#getTimeSheetsUsers(int, int)
	 */
	@Override
	@Transactional
	public List<TimeSheetsUser> getTimeSheetsUsers(int offset, int limit) {
		return getTimeSheetsUserDao().getTimeSheetsUsers(offset, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#getTimeSheetsUsersCount()
	 */
	@Override
	@Transactional
	public Long getTimeSheetsUsersCount() {
		return getTimeSheetsUserDao().getTimeSheetsUsersCount();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#saveTimeSheetsUser(com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser)
	 */
	@Override
	@Transactional
	public void saveTimeSheetsUser(TimeSheetsUser timeSheetsUser) {
		getTimeSheetsUserDao().save(timeSheetsUser);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService#deleteTimeSheetsUser(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public void deleteTimeSheetsUser(PortalUser user) {
		getTimeSheetsUserDao().delete(user);		
	}

	/**
	 * @return the timeSheetsUserDao
	 */
	public TimeSheetsUserDao getTimeSheetsUserDao() {
		return timeSheetsUserDao;
	}

	/**
	 * @param timeSheetsUserDao the timeSheetsUserDao to set
	 */
	public void setTimeSheetsUserDao(TimeSheetsUserDao timeSheetsUserDao) {
		this.timeSheetsUserDao = timeSheetsUserDao;
	}
}