/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;


import java.sql.Date;

import javax.persistence.*;

/**
 * This class represents a single "overwritten" timesheets entry
 * entered by a given user in a given role in a given project 
 * for a particular day.
 * @author Vimukthi
 *
 */
@Entity(name = "TimeSheetsWorkOverwritten")
@Table(name = "timesheets_work_overwritten")
public class TimeSheetsWorkOverwritten extends Work {
	
	@Column(name = "overwrite_no")
	private int overwriteNo;
	
	/**
	 * @param user
	 * @param project
	 * @param role
	 * @param workDate
	 * @param reference
	 * @param hoursPlanned
	 * @param hoursUnplanned
	 * @param note
	 */
	public TimeSheetsWorkOverwritten(PortalUser user, PortalProject project, PortalRole role,
			Date workDate, String reference, float hoursPlanned,
			float hoursUnplanned, String note) {
		this.setUser(user);
		this.setProject(project);
		this.setRole(role);
		this.setWorkDate(workDate);
		this.setReference(reference);
		this.setHoursPlanned(hoursPlanned);
		this.setHoursUnplanned(hoursUnplanned);
		this.setNote(note);
	}

	/**
	 * @return the overwriteNo
	 */
	public int getOverwriteNo() {
		return overwriteNo;
	}

	/**
	 * @param overwriteNo the overwriteNo to set
	 */
	public void setOverwriteNo(int overwriteNo) {
		this.overwriteNo = overwriteNo;
	}
}
