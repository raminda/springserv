package com.millenniumit.mx.data.timesheets.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.WorkDao;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwritten;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService;
import com.millenniumit.mx.data.timesheets.service.WorkService;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

@Service("timeSheetsWorkService")
public class TimeSheetsWorkServiceImpl implements WorkService<TimeSheetsWork> {

	@Autowired
	@Qualifier("timeSheetsWorkDao")
	private WorkDao<TimeSheetsWork> workDao;

	@Autowired
	@Qualifier("timeSheetsWorkOverwriteService")
	private TimeSheetsWorkOverwriteService WorkOverwriteService;

	@Autowired
	@Qualifier("timeSheetsWorkOverwrittenService")
	private WorkService<TimeSheetsWorkOverwritten> WorkOverwrittenService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsUserWork
	 * ()
	 */
	@Override
	public TimeSheetsWork getTimeSheetsUserWork(PortalUser user,
			PortalProject project, PortalRole role, Date workDate) {
		return getWorkDao()
				.getTimeSheetsUserWork(user, project, role, workDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork
	 * ()
	 */
	@Override
	@Transactional
	public List<TimeSheetsWork> getTimeSheetsWork() {
		return getWorkDao().getTimeSheetsWork();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork
	 * (long, long)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWork> getTimeSheetsWork(int offset, int limit) {
		return getWorkDao().getTimeSheetsWork(offset, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#
	 * getTimeSheetsWorkCount()
	 */
	@Override
	@Transactional
	public Long getTimeSheetsWorkCount() {
		return getWorkDao().getTimeSheetsWorkCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork
	 * (com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWork> getTimeSheetsWork(
			TimeSheetsWorkCriteria criteria) {
		return getWorkDao().getTimeSheetsWork(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork
	 * (com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria, int,
	 * int)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWork> getTimeSheetsWork(
			TimeSheetsWorkCriteria criteria, int offset, int limit) {
		return getWorkDao().getTimeSheetsWork(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate(), offset, limit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#
	 * getTimeSheetsWorkCount
	 * (com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria)
	 */
	@Override
	@Transactional
	public Long getTimeSheetsWorkCount(TimeSheetsWorkCriteria criteria) {
		return getWorkDao().getTimeSheetsWorkCount(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.timesheets.service.WorkService#saveTimeSheetsWork
	 * (com.millenniumit.mx.data.timesheets.domain.Work)
	 */
	@Override
	@Transactional
	public void saveTimeSheetsWork(TimeSheetsWork timesheetWork) {
		// first get the timesheets entry if it already exists in the db
		TimeSheetsWork work = getWorkDao().getTimeSheetsUserWork(timesheetWork.getUser(), 
				timesheetWork.getProject(), timesheetWork.getRole(), timesheetWork.getWorkDate());		
		
		if (work != null){
			// if the an entry exists,
			//	 * update this entry with new values.
			work.setReference(timesheetWork.getReference());
			work.setHoursPlanned(timesheetWork.getHoursPlanned());
			work.setHoursUnplanned(timesheetWork.getHoursUnplanned());
			work.setNote(timesheetWork.getNote());
			work.setUpdateCount(work.getUpdateCount() + 1);
			getWorkDao().save(work);
			//	* add the non updated record to the overwritten record set.
			TimeSheetsWorkOverwritten workOverwritten = new TimeSheetsWorkOverwritten(
					work.getUser(), work.getProject(),
					work.getRole(), work.getWorkDate(),
					work.getReference(), work.getHoursPlanned(),
					work.getHoursUnplanned(), work.getNote());
			getWorkOverwrittenService().saveTimeSheetsWork(workOverwritten);
			//	* update the number of overwrites.
			getWorkOverwriteService().saveTimeSheetsWorkOverwrite(work.getUser(), work.getWorkDate());
		} else {
			getWorkDao().save(timesheetWork);
		}
	}

	/**
	 * @return the workDao
	 */
	public WorkDao<TimeSheetsWork> getWorkDao() {
		return workDao;
	}

	/**
	 * @param workDao
	 *            the workDao to set
	 */
	public void setWorkDao(WorkDao<TimeSheetsWork> workDao) {
		this.workDao = workDao;
	}

	/**
	 * @return the workOverwriteService
	 */
	public TimeSheetsWorkOverwriteService getWorkOverwriteService() {
		return WorkOverwriteService;
	}

	/**
	 * @param workOverwriteService
	 *            the workOverwriteService to set
	 */
	public void setWorkOverwriteService(
			TimeSheetsWorkOverwriteService workOverwriteService) {
		WorkOverwriteService = workOverwriteService;
	}

	/**
	 * @return the workOverwrittenService
	 */
	public WorkService<TimeSheetsWorkOverwritten> getWorkOverwrittenService() {
		return WorkOverwrittenService;
	}

	/**
	 * @param workOverwrittenService
	 *            the workOverwrittenService to set
	 */
	public void setWorkOverwrittenService(
			WorkService<TimeSheetsWorkOverwritten> workOverwrittenService) {
		WorkOverwrittenService = workOverwrittenService;
	}
}
