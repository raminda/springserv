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
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService;

/**
 * @author Kalpag
 * 
 */
@Service("timesheetsReferenceService")
public class TimeSheetsReferenceServiceImpl implements
		TimeSheetsReferenceService {

	@Autowired
	@Qualifier("timesheetsReferenceDao")
	private TimeSheetsReferenceDao timesheetsReferenceDao;

	@Transactional
	public List<TimeSheetsReference> getTimeSheetsReferences() {
		return timesheetsReferenceDao.getTimeSheetsReferences();
	}

	@Transactional
	public List<TimeSheetsReference> getTimeSheetsReferences(long divisionId) {
		return timesheetsReferenceDao.getTimeSheetsReferences(divisionId);
	}
}
