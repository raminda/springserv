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

		// if (timesheetsCriteria.getDivisionIds() == null
		// && timesheetsCriteria.getProjectIds() == null
		// && timesheetsCriteria.getRoleIds() != null
		// && timesheetsCriteria.getUserIds() != null) {
		// return timesheetsworkdao.getTimeSheetsWork(offset, limit,
		// timesheetsCriteria.getUserIds(),
		// timesheetsCriteria.getRoleIds());
		// }
		// if (timesheetsCriteria.getDivisionIds() == null
		// && timesheetsCriteria.getProjectIds() == null
		// && timesheetsCriteria.getRoleIds() == null
		// && timesheetsCriteria.getUserIds() == null) {
		// return timesheetsworkdao.getTimeSheetsWork(offset, limit,
		// timesheetsCriteria.getStartDate(),
		// timesheetsCriteria.getEndDate());
		// }
		// if (timesheetsCriteria.getDivisionIds() != null
		// && timesheetsCriteria.getProjectIds() == null
		// && timesheetsCriteria.getRoleIds() == null
		// && timesheetsCriteria.getUserIds() == null) {
		// return null;
		// }
		// if (timesheetsCriteria.getDivisionIds() != null
		// && timesheetsCriteria.getProjectIds() == null
		// && timesheetsCriteria.getRoleIds() == null
		// && timesheetsCriteria.getUserIds() == null) {
		// return null;
		// }
		// return null;

		if (timesheetsCriteria.getDivisionIds() == null
				&& timesheetsCriteria.getProjectIds() == null
				&& timesheetsCriteria.getRoleIds() == null
				&& timesheetsCriteria.getUserIds() == null
				&& timesheetsCriteria.getStartDate() == null
				&& timesheetsCriteria.getEndDate() == null) {
			return timesheetsworkdao.getTimeSheetsWork(offset, limit);
		}

		return timesheetsworkdao.getTimeSheetsWork(offset, limit,
				timesheetsCriteria);
	}
}
