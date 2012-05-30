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

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkOverwriteDao;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService;

/**
 * @author Vimukthi
 *
 */
@Service("timeSheetsWorkOverwriteService")
public class TimeSheetsWorkOverwriteServiceImpl implements TimeSheetsWorkOverwriteService {
	
	@Autowired
	@Qualifier("timeSheetsWorkOverwriteDao")
	private TimeSheetsWorkOverwriteDao overwriteDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#getTimeSheetsWorkOverwrite(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	@Transactional
	public TimeSheetsWorkOverwrite getTimeSheetsWorkOverwrite(PortalUser user,
			Date workDate) {
		return getOverwriteDao().getTimeSheetsWorkOverwrite(user, workDate);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#getTimeSheetsWorkOverwrites()
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites() {
		return getOverwriteDao().getTimeSheetsWorkOverwrites();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#getTimeSheetsWorkOverwrites(com.millenniumit.mx.data.timesheets.domain.PortalUser)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			PortalUser user) {
		return getOverwriteDao().getTimeSheetsWorkOverwrites(user);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#getTimeSheetsWorkOverwrites(java.sql.Date)
	 */
	@Override
	@Transactional
	public List<TimeSheetsWorkOverwrite> getTimeSheetsWorkOverwrites(
			Date workDate) {
		return getOverwriteDao().getTimeSheetsWorkOverwrites(workDate);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#saveTimeSheetsWorkOverwrite(com.millenniumit.mx.data.timesheets.domain.TimeSheetsWorkOverwrite)
	 */
	@Override
	@Transactional
	public void saveTimeSheetsWorkOverwrite(TimeSheetsWorkOverwrite overwrite) {
		getOverwriteDao().save(overwrite);
	}
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkOverwriteService#saveTimeSheetsWorkOverwrite(com.millenniumit.mx.data.timesheets.domain.PortalUser, java.sql.Date)
	 */
	@Override
	@Transactional
	public void saveTimeSheetsWorkOverwrite(PortalUser user, Date workDate) {
		TimeSheetsWorkOverwrite overwrite = getOverwriteDao().getTimeSheetsWorkOverwrite(user, workDate);
		
		// if an overwrite exists increment the number of overwrites
		if (overwrite != null){
			overwrite.setOverwrites(overwrite.getOverwrites() + 1);
		} else {
			overwrite = new TimeSheetsWorkOverwrite(user, workDate, 1);
		}
		getOverwriteDao().save(overwrite);
	}

	/**
	 * @return the overwriteDao
	 */
	public TimeSheetsWorkOverwriteDao getOverwriteDao() {
		return overwriteDao;
	}

	/**
	 * @param overwriteDao the overwriteDao to set
	 */
	public void setOverwriteDao(TimeSheetsWorkOverwriteDao overwriteDao) {
		this.overwriteDao = overwriteDao;
	}
	
}
