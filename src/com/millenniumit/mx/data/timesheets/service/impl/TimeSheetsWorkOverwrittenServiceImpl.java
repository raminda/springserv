/**
 * 
 */
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
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwritten;
import com.millenniumit.mx.data.timesheets.service.WorkService;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

/**
 * @author Vimukthi
 *
 */
@Service("timeSheetsWorkOverwrittenService")
public class TimeSheetsWorkOverwrittenServiceImpl implements WorkService<TimeSheetsWorkOverwritten> {
	
	@Autowired
	@Qualifier("timeSheetsWorkOverwrittenDao")
	private WorkDao<TimeSheetsWorkOverwritten> overwrittenDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsUserWork(com.millenniumit.mx.data.timesheets.domain.PortalUser, com.millenniumit.mx.data.timesheets.domain.PortalProject, com.millenniumit.mx.data.timesheets.domain.PortalRole, java.sql.Date)
	 */
	@Override
	public TimeSheetsWorkOverwritten getTimeSheetsUserWork(PortalUser user,
			PortalProject project, PortalRole role, Date workDate) {
		// Returns the latest overwritten record
		return getOverwrittenDao().getTimeSheetsUserWork(user, project, role, workDate);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork()
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwritten> getTimeSheetsWork() {
		return getOverwrittenDao().getTimeSheetsWork();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork(long, long)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwritten> getTimeSheetsWork(int offset,
			int limit) {
		return getOverwrittenDao().getTimeSheetsWork(offset, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWorkCount()
	 */
	@Override
	@Transactional
	public Long getTimeSheetsWorkCount() {
		return getOverwrittenDao().getTimeSheetsWorkCount();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork(com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwritten> getTimeSheetsWork(
			TimeSheetsWorkCriteria criteria) {
		return getOverwrittenDao().getTimeSheetsWork(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate());
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWork(com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria, int, int)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwritten> getTimeSheetsWork(
			TimeSheetsWorkCriteria criteria, int offset, int limit) {
		return getOverwrittenDao().getTimeSheetsWork(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate(), offset, limit);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#getTimeSheetsWorkCount(com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria)
	 */
	@Override
	@Transactional
	public Long getTimeSheetsWorkCount(TimeSheetsWorkCriteria criteria) {
		return getOverwrittenDao().getTimeSheetsWorkCount(criteria.getUsers(),
				criteria.getProjects(), criteria.getRoles(),
				criteria.getStartDate(), criteria.getEndDate());
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.WorkService#saveTimeSheetsWork(com.millenniumit.mx.data.timesheets.domain.Work)
	 */
	@Override
	@Transactional
	public void saveTimeSheetsWork(TimeSheetsWorkOverwritten overwritten) {
		// get the last overwrite and set the incremented overwrite no for the current overwrite
		TimeSheetsWorkOverwritten latest = getOverwrittenDao().getTimeSheetsUserWork(overwritten.getUser(), 
				overwritten.getProject(), overwritten.getRole(), overwritten.getWorkDate());
		if (latest != null){
			overwritten.setOverwriteNo(latest.getOverwriteNo() + 1);
		} else {
			overwritten.setOverwriteNo(1);
		}		
		getOverwrittenDao().save(overwritten);
	}

	/**
	 * @return the overwrittenDao
	 */
	public WorkDao<TimeSheetsWorkOverwritten> getOverwrittenDao() {
		return overwrittenDao;
	}

	/**
	 * @param overwrittenDao the overwrittenDao to set
	 */
	public void setOverwrittenDao(WorkDao<TimeSheetsWorkOverwritten> overwrittenDao) {
		this.overwrittenDao = overwrittenDao;
	}
}
