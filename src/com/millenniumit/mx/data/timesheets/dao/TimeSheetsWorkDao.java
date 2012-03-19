package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

public interface TimeSheetsWorkDao {
	
	public List<TimeSheetsWork> getTimeSheetsWork();
	public List<Object> getTimeSheetsWork(long offset,long limit);
	public List<Object> getTimeSheetsWork(long offset,long limit, Long[] users, Long[] roles);
	public List<Object> getTimeSheetsWork(long offset,long limit, String startDate, String endDate);
	public List<Object> getTimeSheetsWork(long offset,long limit, TimeSheetsWorkCriteria workcriteria );
	
	public long getTotalTimeSheetsWorkCount();

}
