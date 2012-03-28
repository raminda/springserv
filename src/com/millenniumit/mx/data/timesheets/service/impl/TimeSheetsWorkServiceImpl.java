package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkDao;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkService;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

@Service("timesheetsWorkService")
public class TimeSheetsWorkServiceImpl implements TimeSheetsWorkService {

	@Autowired
	@Qualifier("timesheetsWorkDao")
	private TimeSheetsWorkDao timesheetsworkdao;

	@Transactional
	public List<TimeSheetsWork> getTimeSheetsWork() {
		return timesheetsworkdao.getTimeSheetsWork();
	}

	@Transactional
	public List<Object> getTimeSheetsWork(long offset, long limit) {
		return timesheetsworkdao.getTimeSheetsWork(offset, limit);
	}

	@Transactional
	public long getTotalTimeSheetsWorkCount() {
		return timesheetsworkdao.getTotalTimeSheetsWorkCount();
	}

	@Transactional
	public List<Object> getTimeSheetsWork(
			TimeSheetsWorkCriteria timesheetsCriteria, long offset, long limit) {
		return timesheetsworkdao.getTimeSheetsWork(offset, limit,
				timesheetsCriteria);
	}

	@Transactional
	public long getTimeSheetWorkReturnedRowCount() {
	return timesheetsworkdao.getTimeSheetWorkReturnedRowCount();
	}

	@Transactional
	public void saveTimeSheetsWork(TimeSheetsWork timesheetWork) {
		timesheetsworkdao.saveTimeSheetsWork(timesheetWork);
	}

	@Transactional
	public List<TimeSheetsWork> getAllTimeSheetsWork(long offset, long limit) {
		return timesheetsworkdao.getAllTimeSheetsWork(offset, limit);
	}
}
