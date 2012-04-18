package com.millenniumit.mx.data.timesheets.util;
/**
 * 
 * @author kalpag
 *
 */
public class TimeSheetsWorkCriteria {

	private Long[] divisionIds = null;
	private Long[] projectIds = null;
	private Long[] roleIds = null;
	private Long[] userIds = null;
	private String startDate = null;
	private String endDate = null;
		
	/**
	 * @param divisionIds
	 * @param projectIds
	 * @param roleIds
	 * @param userIds
	 * @param startDate
	 * @param endDate
	 */
	public TimeSheetsWorkCriteria(Long[] divisionIds, Long[] projectIds,
			Long[] roleIds, Long[] userIds, String startDate, String endDate) {
		this.divisionIds = divisionIds;
		this.projectIds = projectIds;
		this.roleIds = roleIds;
		this.userIds = userIds;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public TimeSheetsWorkCriteria(){
		
	}

	/**
	 * @return the divisionIds
	 */
	public Long[] getDivisionIds() {
		return divisionIds;
	}

	/**
	 * @param divisionIds the divisionIds to set
	 */
	public void setDivisionIds(Long[] divisionIds) {
		this.divisionIds = divisionIds;
	}

	/**
	 * @return the projectIds
	 */
	public Long[] getProjectIds() {
		return projectIds;
	}

	/**
	 * @param projectIds the projectIds to set
	 */
	public void setProjectIds(Long[] projectIds) {
		this.projectIds = projectIds;
	}

	/**
	 * @return the roleIds
	 */
	public Long[] getRoleIds() {
		return roleIds;
	}

	/**
	 * @param roleIds the roleIds to set
	 */
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return the userIds
	 */
	public Long[] getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds the userIds to set
	 */
	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
