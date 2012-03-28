package com.millenniumit.mx.data.timesheets.service;

import java.util.List;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

public interface TimeSheetsWorkService {

	public List<TimeSheetsWork> getTimeSheetsWork();
	public List<Object> getTimeSheetsWork(long offset, long limit);
	public List<TimeSheetsWork> getAllTimeSheetsWork(long offset, long limit);
	public List<Object> getTimeSheetsWork(
			TimeSheetsWorkCriteria timesheetsCriteria, long offset, long limit);
	public long getTotalTimeSheetsWorkCount();
	public long getTimeSheetWorkReturnedRowCount();
	public void saveTimeSheetsWork(TimeSheetsWork timesheetWork);
}
