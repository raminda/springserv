/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.PortalDivisionDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.service.PortalDivisionService;

/**
 * @author Vimukthi
 *
 */
@Service("portalDivisionService")
public class PortalDivisionServiceImpl implements PortalDivisionService {
	
	@Autowired
	@Qualifier("portalDivisionDao")
	private PortalDivisionDao divisionDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalDivisionService#getDivision(java.lang.String)
	 */
	@Override
	@Transactional
	public PortalDivision getDivision(String title) {
		return getDivisionDao().getDivision(title);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalDivisionService#getDivisions()
	 */
	@Override
	@Transactional
	public List<PortalDivision> getDivisions() {
		return getDivisionDao().getDivisions();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalDivisionService#saveDivision(com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	@Transactional
	public void saveDivision(PortalDivision division) {
		getDivisionDao().save(division);
	}

	/**
	 * @return the divisionDao
	 */
	public PortalDivisionDao getDivisionDao() {
		return divisionDao;
	}

	/**
	 * @param divisionDao the divisionDao to set
	 */
	public void setDivisionDao(PortalDivisionDao divisionDao) {
		this.divisionDao = divisionDao;
	}

}
