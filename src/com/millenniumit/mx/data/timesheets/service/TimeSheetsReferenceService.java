/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;

/**
 * @author Kalpag
 *
 */
public interface TimeSheetsReferenceService {
	
	/**
	 * 
	 * @param name
	 * @param division
	 * @return
	 */
	public TimeSheetsReference getTimeSheetsReference(String name, PortalDivision division);
	
	/**
	 * 
	 * @return
	 */
	public List<TimeSheetsReference> getTimeSheetsReferences();
	
	/**
	 * 
	 * @param division
	 * @return
	 */
	public List<TimeSheetsReference> getTimeSheetsReferences(PortalDivision division);
	
	/**
	 * 
	 * @param reference
	 */
	public void saveReference(TimeSheetsReference reference);
	
}
