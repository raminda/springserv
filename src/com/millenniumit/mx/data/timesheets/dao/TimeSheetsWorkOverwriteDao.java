/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite;

/**
 * @author Vimukthi
 *
 */
public interface TimeSheetsWorkOverwriteDao {

	/**
	 * @param user
	 * @param workDate
	 * @return
	 */
	public TimeSheetsWorkOverwrite getTimeSheetsWorkOverwrite(PortalUser user,
			Date workDate);

	/**
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites();

	/**
	 * @param user
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			PortalUser user);

	/**
	 * @param workDate
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			Date workDate);

	/**
	 * @param overwrite
	 */
	public void save(TimeSheetsWorkOverwrite overwrite);

}
