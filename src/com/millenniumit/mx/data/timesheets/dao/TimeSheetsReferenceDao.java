/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.TimeSheetsReference;

/**
 * @author Kalpag
 *
 */
public interface TimeSheetsReferenceDao {
	public List<TimeSheetsReference> getTimeSheetsReferences();
	public List<TimeSheetsReference> getTimeSheetsReferences(long divisionId);
}
