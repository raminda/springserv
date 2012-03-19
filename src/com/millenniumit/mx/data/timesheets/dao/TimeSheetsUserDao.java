package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;

public interface TimeSheetsUserDao {
	List<TimeSheetsUser> getTimeSheetsUsers();
	public void saveTimeSheetsUsers(TimeSheetsUser timesheetsuser);
	public void deleteTimeSheetsUsers(long userId);
	
}