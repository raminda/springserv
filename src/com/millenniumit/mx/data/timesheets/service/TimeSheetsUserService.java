package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;


/**
 * 
 * @author KalpaG <kalpag@millenniumit.com>
 * 
 */
public interface TimeSheetsUserService {
	public List<TimeSheetsUser> getTimeSheetsUsers();
	public void saveTimeSheetsUser(TimeSheetsUser timesheetuser);
	public void saveTimeSheetsUsers( List<TimeSheetsUser> timesheetuserList);
	public void deleteTimeSheetsUsers(long userId);
}