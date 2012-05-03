package com.millenniumit.mx.data.timesheets.service;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.Work;
import com.millenniumit.mx.data.timesheets.exceptions.InvalidTimeSheetUserException;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

/**
 * 
 * @author Vimukthi
 * 
 */
public interface WorkService<T extends Work> {

	/**
	 * 
	 * @return
	 */
	public T getTimeSheetsUserWork(PortalUser user, PortalProject project,
			PortalRole role, Date workDate, String reference);

	/**
	 * 
	 * @return
	 */
	public List<T> getTimeSheetsWork();

	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<T> getTimeSheetsWork(int offset, int limit);

	/**
	 * 
	 * @return
	 */
	public Long getTimeSheetsWorkCount();

	/**
	 * 
	 * @param timesheetsCriteria
	 * @return
	 */
	public List<T> getTimeSheetsWork(TimeSheetsWorkCriteria criteria);

	/**
	 * 
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<T> getTimeSheetsWork(TimeSheetsWorkCriteria criteria,
			int offset, int limit);

	/**
	 * 
	 * @param criteria
	 * @return
	 */
	public Long getTimeSheetsWorkCount(TimeSheetsWorkCriteria criteria);

	/**
	 * 
	 * @param timesheetWork
	 * @throws InvalidTimeSheetUserException 
	 */
	public void saveTimeSheetsWork(T timesheetWork) throws InvalidTimeSheetUserException;
}
