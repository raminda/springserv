/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;

/**
 * @author Vimukthi
 *
 */
public interface PortalDivisionService {
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public PortalDivision getDivision(String title);
	
	/**
	 * 
	 * @return
	 */
	public List<PortalDivision> getDivisions();
	
	/**
	 * 
	 * @param division
	 */
	public void saveDivision(PortalDivision division);
}
