/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsReferenceDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("timeSheetsReferenceService")
public class TimeSheetsReferenceServiceImpl implements
		TimeSheetsReferenceService {
	
	@Autowired
	@Qualifier("timeSheetsReferenceDao")
	private TimeSheetsReferenceDao referenceDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService#getTimeSheetsReference(java.lang.String, com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	@Transactional
	public TimeSheetsReference getTimeSheetsReference(String name,
			PortalDivision division) {
		return getReferenceDao().getTimeSheetsReference(name, division);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService#getTimeSheetsReferences()
	 */
	@Override
	@Transactional
	public List<TimeSheetsReference> getTimeSheetsReferences() {
		return getReferenceDao().getTimeSheetsReferences();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService#getTimeSheetsReferences(com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	@Transactional
	public List<TimeSheetsReference> getTimeSheetsReferences(
			PortalDivision division) {
		return getReferenceDao().getTimeSheetsReferences(division);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService#saveReference(com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference)
	 */
	@Override
	@Transactional
	public void saveReference(TimeSheetsReference reference) {
		getReferenceDao().save(reference);
	}

	/**
	 * @return the referenceDao
	 */
	public TimeSheetsReferenceDao getReferenceDao() {
		return referenceDao;
	}

	/**
	 * @param referenceDao the referenceDao to set
	 */
	public void setReferenceDao(TimeSheetsReferenceDao referenceDao) {
		this.referenceDao = referenceDao;
	}
}
