/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite;

/**
 * @author Vimukthi
 *
 */
public interface TimeSheetsWorkOverwriteService {
	
	/**
	 * 
	 * @param user
	 * @param workDate
	 * @return
	 */
	public TimeSheetsWorkOverwrite getTimeSheetsWorkOverwrite(PortalUser user, Date workDate);
	
	/**
	 * 
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites();
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(PortalUser user);
	
	/**
	 * 
	 * @param workDate
	 * @return
	 */
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(Date workDate);
	
	/**
	 * 
	 * @param overwrite
	 */
	public void saveTimeSheetsWorkOverwrite(TimeSheetsWorkOverwrite overwrite);

	/**
	 * @param user
	 * @param workDate
	 */
	public void saveTimeSheetsWorkOverwrite(PortalUser user, Date workDate);
}
