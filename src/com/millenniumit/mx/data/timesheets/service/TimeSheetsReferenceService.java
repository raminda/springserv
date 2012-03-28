/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;

/**
 * @author Kalpag
 *
 */
public interface TimeSheetsReferenceService {
	
	public List<TimeSheetsReference> getTimeSheetsReferences();
	public List<TimeSheetsReference> getTimeSheetsReferences(long divisionId);
	
}
