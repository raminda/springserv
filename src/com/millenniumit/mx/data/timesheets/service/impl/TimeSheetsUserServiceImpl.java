package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsUserService;

/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 * 
 */
@Service("timesheetsUserService")
public class TimeSheetsUserServiceImpl implements TimeSheetsUserService {

	@Autowired
	@Qualifier("timesheetsUserDao")
	private TimeSheetsUserDao timesheetsdao;

	@Transactional
	public List<TimeSheetsUser> getTimeSheetsUsers() {
		return timesheetsdao.getTimeSheetsUsers();
	}
	/**
	 * @return the timesheetsdao
	 */
	public TimeSheetsUserDao getTimesheetsdao() {
		return timesheetsdao;
	}

	/**
	 * @param timesheetsdao the timesheetsdao to set
	 */
	public void setTimesheetsdao(TimeSheetsUserDao timesheetsdao) {
		this.timesheetsdao = timesheetsdao;
	}

	@Transactional
	public void saveTimeSheetsUser(TimeSheetsUser timesheetuser) {
		timesheetsdao.saveTimeSheetsUsers(timesheetuser);
	}

	@Transactional
	public void deleteTimeSheetsUsers(long userID) {
		
		timesheetsdao.deleteTimeSheetsUsers(userID);
	}
	
	
	@Transactional
	public void saveTimeSheetsUsers(List<TimeSheetsUser> timesheetuserList) {
		for (TimeSheetsUser timeSheetsUser : timesheetuserList) {
			timesheetsdao.saveTimeSheetsUsers(timeSheetsUser);
		}
	}
}