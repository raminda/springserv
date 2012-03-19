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
	public void saveTimeSheetsUsers(TimeSheetsUser timesheetuser);
	public void deleteTimeSheetsUsers(long userId);
}