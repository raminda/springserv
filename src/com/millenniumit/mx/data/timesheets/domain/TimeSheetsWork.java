package com.millenniumit.mx.data.timesheets.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * This class represents a single "current" timesheets entry
 * entered by a given user in a given role in a given project 
 * for a particular day.
 * @author Vimukthi
 *
 */
@Entity(name = "TimeSheetsWork")
@Table(name = "timesheets_work")
public class TimeSheetsWork extends Work implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "update_count")
	private int updateCount;

	/**
	 * @return the updateCount
	 */
	public int getUpdateCount() {
		return updateCount;
	}

	/**
	 * @param updateCount the updateCount to set
	 */
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}		
}
