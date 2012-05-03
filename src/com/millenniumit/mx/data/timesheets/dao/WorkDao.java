package com.millenniumit.mx.data.timesheets.dao;


import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.Work;

public interface WorkDao<T extends Work> {

	/**
	 * @param user
	 * @param project
	 * @param role
	 * @param workDate
	 * @return
	 */
	public T getTimeSheetsUserWork(PortalUser user,
			PortalProject project, PortalRole role, Date workDate);

	/**
	 * @return
	 */
	public List<T> getTimeSheetsWork();

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<T> getTimeSheetsWork(int offset, int limit);

	/**
	 * @return
	 */
	public Long getTimeSheetsWorkCount();

	/**
	 * @param users
	 * @param projects
	 * @param roles
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<T> getTimeSheetsWork(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate);

	/**
	 * @param users
	 * @param projects
	 * @param roles
	 * @param startDate
	 * @param endDate
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<T> getTimeSheetsWork(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate, int offset, int limit);

	/**
	 * @param users
	 * @param projects
	 * @param roles
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public Long getTimeSheetsWorkCount(List<PortalUser> users,
			List<PortalProject> projects, List<PortalRole> roles,
			Date startDate, Date endDate);

	/**
	 * @param timesheetWork
	 */
	public void save(T timesheetWork);
	
}
