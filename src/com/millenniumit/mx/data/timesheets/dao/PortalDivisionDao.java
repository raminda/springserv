/**
 * 
 */
package com.millenniumit.mx.data.timesheets.dao;

import java.util.List;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;

/**
 * @author Vimukthi
 *
 */
public interface PortalDivisionDao {

	/**
	 * @param title
	 * @return
	 */
	public PortalDivision getDivision(String title);

	/**
	 * @return
	 */
	public List<PortalDivision> getDivisions();

	/**
	 * @param division
	 */
	public void save(PortalDivision division);

}
