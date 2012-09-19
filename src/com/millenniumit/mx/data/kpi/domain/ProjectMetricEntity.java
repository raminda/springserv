/**
 * 
 */
package com.millenniumit.mx.data.kpi.domain;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.MappedSuperclass;

/**
 * @author kalpag
 * 
 */
@MappedSuperclass
public class ProjectMetricEntity extends AuditFields {
	
	@Column(name="week")
	private long week;
	
	@Column(name="as_at")
	private long as_at;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private KpiProject project;
	
	@Column(name="role_category_id")
	private long role_category_id;

	@Column(name="total_count")
	private int total_count;
	
	@Column(name="copied_count")
	private int copied_count;
	
	@Column(name="inherited_count")
	private int inherited_count;
	
	@Column(name="open_count")
	private int open_count;
	
	@Column(name="open_total")
	private int open_total;
	
	@Column(name="valid_count")
	private int valid_count;
	
	@Column(name="invalid_count")
	private int invalid_count;
	
	@Column(name="unique_count")
	private int unique_count;
	
	@Column(name="original_count")
	private int original_count;
	
	@Column(name="platform_count")
	private int platform_count;
	
	@Column(name="platform_valid_count")
	private int platform_valid_count;
	
	@Column(name="platform_invalid_count")
	private int platform_invalid_count;
	
	@Column(name="valid_critical_count")
	private int valid_critical_count;
	
	@Column(name="valid_high_count")
	private String valid_high_count;
	
	@Column(name="valid_low_count")
	private String valid_low_count;
	
	@Column(name="valid_medium_count")
	private String valid_medium_count;
	
	@Column(name="open_critical_count")
	private String open_critical_count;
	
	@Column(name="open_high_count")
	private String open_high_count;
	
	@Column(name="open_low_count")
	private String open_low_count;	
	
	@Column(name="open_medium_count")
	private String open_medium_count;
		
	@Column(name="total_tickets")
	private String total_tickets;
	
	@Column(name="copied_tickets")
	private String copied_tickets;
	
	@Column(name="open_tickets")
	private String open_tickets;
	
	@Column(name="inherited_tickets")
	private String inherited_tickets;
	
	@Column(name="valid_tickets")
	private String valid_tickets;
	
	@Column(name="invalid_tickets")
	private String invalid_tickets;
	
	@Column(name="platform_tickets")
	private String platform_tickets;
	
	@Column(name="unique_tickets")
	private String unique_tickets;
	
	@Column(name="original_tickets")
	private String original_tickets;
	
	@Column(name="dsi")
	private float dsi;
	
	@Column(name="open_dsi")
	private float open_dsi;
	
	@Column(name="drr")
	private float drr;
	
	@Column(name="dre")
	private float dre;
	
	@Column(name="idp")
	private float idp;
	
	@Column(name="defects_per_resource")
	private float defects_per_resource;

	/**
	 * @return the week
	 */
	public long getWeek() {
		return week;
	}

	/**
	 * @param week the week to set
	 */
	public void setWeek(long week) {
		this.week = week;
	}

	/**
	 * @return the as_at
	 */
	public long getAs_at() {
		return as_at;
	}

	/**
	 * @param as_at the as_at to set
	 */
	public void setAs_at(long as_at) {
		this.as_at = as_at;
	}

	/**
	 * @return the role_category_id
	 */
	public long getRole_category_id() {
		return role_category_id;
	}

	/**
	 * @param role_category_id the role_category_id to set
	 */
	public void setRole_category_id(long role_category_id) {
		this.role_category_id = role_category_id;
	}

	/**
	 * @return the total_count
	 */
	public int getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the copied_count
	 */
	public int getCopied_count() {
		return copied_count;
	}

	/**
	 * @param copied_count the copied_count to set
	 */
	public void setCopied_count(int copied_count) {
		this.copied_count = copied_count;
	}

	/**
	 * @return the inherited_count
	 */
	public int getInherited_count() {
		return inherited_count;
	}

	/**
	 * @param inherited_count the inherited_count to set
	 */
	public void setInherited_count(int inherited_count) {
		this.inherited_count = inherited_count;
	}

	/**
	 * @return the open_count
	 */
	public int getOpen_count() {
		return open_count;
	}

	/**
	 * @param open_count the open_count to set
	 */
	public void setOpen_count(int open_count) {
		this.open_count = open_count;
	}

	/**
	 * @return the open_total
	 */
	public int getOpen_total() {
		return open_total;
	}

	/**
	 * @param open_total the open_total to set
	 */
	public void setOpen_total(int open_total) {
		this.open_total = open_total;
	}

	/**
	 * @return the valid_count
	 */
	public int getValid_count() {
		return valid_count;
	}

	/**
	 * @param valid_count the valid_count to set
	 */
	public void setValid_count(int valid_count) {
		this.valid_count = valid_count;
	}

	/**
	 * @return the invalid_count
	 */
	public int getInvalid_count() {
		return invalid_count;
	}

	/**
	 * @param invalid_count the invalid_count to set
	 */
	public void setInvalid_count(int invalid_count) {
		this.invalid_count = invalid_count;
	}

	/**
	 * @return the unique_count
	 */
	public int getUnique_count() {
		return unique_count;
	}

	/**
	 * @param unique_count the unique_count to set
	 */
	public void setUnique_count(int unique_count) {
		this.unique_count = unique_count;
	}

	/**
	 * @return the original_count
	 */
	public int getOriginal_count() {
		return original_count;
	}

	/**
	 * @param original_count the original_count to set
	 */
	public void setOriginal_count(int original_count) {
		this.original_count = original_count;
	}

	/**
	 * @return the platform_count
	 */
	public int getPlatform_count() {
		return platform_count;
	}

	/**
	 * @param platform_count the platform_count to set
	 */
	public void setPlatform_count(int platform_count) {
		this.platform_count = platform_count;
	}

	/**
	 * @return the platform_valid_count
	 */
	public int getPlatform_valid_count() {
		return platform_valid_count;
	}

	/**
	 * @param platform_valid_count the platform_valid_count to set
	 */
	public void setPlatform_valid_count(int platform_valid_count) {
		this.platform_valid_count = platform_valid_count;
	}

	/**
	 * @return the platform_invalid_count
	 */
	public int getPlatform_invalid_count() {
		return platform_invalid_count;
	}

	/**
	 * @param platform_invalid_count the platform_invalid_count to set
	 */
	public void setPlatform_invalid_count(int platform_invalid_count) {
		this.platform_invalid_count = platform_invalid_count;
	}

	/**
	 * @return the valid_critical_count
	 */
	public int getValid_critical_count() {
		return valid_critical_count;
	}

	/**
	 * @param valid_critical_count the valid_critical_count to set
	 */
	public void setValid_critical_count(int valid_critical_count) {
		this.valid_critical_count = valid_critical_count;
	}

	/**
	 * @return the valid_high_count
	 */
	public String getValid_high_count() {
		return valid_high_count;
	}

	/**
	 * @param valid_high_count the valid_high_count to set
	 */
	public void setValid_high_count(String valid_high_count) {
		this.valid_high_count = valid_high_count;
	}

	/**
	 * @return the valid_low_count
	 */
	public String getValid_low_count() {
		return valid_low_count;
	}

	/**
	 * @param valid_low_count the valid_low_count to set
	 */
	public void setValid_low_count(String valid_low_count) {
		this.valid_low_count = valid_low_count;
	}

	/**
	 * @return the valid_medium_count
	 */
	public String getValid_medium_count() {
		return valid_medium_count;
	}

	/**
	 * @param valid_medium_count the valid_medium_count to set
	 */
	public void setValid_medium_count(String valid_medium_count) {
		this.valid_medium_count = valid_medium_count;
	}

	/**
	 * @return the open_critical_count
	 */
	public String getOpen_critical_count() {
		return open_critical_count;
	}

	/**
	 * @param open_critical_count the open_critical_count to set
	 */
	public void setOpen_critical_count(String open_critical_count) {
		this.open_critical_count = open_critical_count;
	}

	/**
	 * @return the open_high_count
	 */
	public String getOpen_high_count() {
		return open_high_count;
	}

	/**
	 * @param open_high_count the open_high_count to set
	 */
	public void setOpen_high_count(String open_high_count) {
		this.open_high_count = open_high_count;
	}

	/**
	 * @return the open_low_count
	 */
	public String getOpen_low_count() {
		return open_low_count;
	}

	/**
	 * @param open_low_count the open_low_count to set
	 */
	public void setOpen_low_count(String open_low_count) {
		this.open_low_count = open_low_count;
	}

	/**
	 * @return the open_medium_count
	 */
	public String getOpen_medium_count() {
		return open_medium_count;
	}

	/**
	 * @param open_medium_count the open_medium_count to set
	 */
	public void setOpen_medium_count(String open_medium_count) {
		this.open_medium_count = open_medium_count;
	}

	/**
	 * @return the total_tickets
	 */
	public String getTotal_tickets() {
		return total_tickets;
	}

	/**
	 * @param total_tickets the total_tickets to set
	 */
	public void setTotal_tickets(String total_tickets) {
		this.total_tickets = total_tickets;
	}

	/**
	 * @return the copied_tickets
	 */
	public String getCopied_tickets() {
		return copied_tickets;
	}

	/**
	 * @param copied_tickets the copied_tickets to set
	 */
	public void setCopied_tickets(String copied_tickets) {
		this.copied_tickets = copied_tickets;
	}

	/**
	 * @return the open_tickets
	 */
	public String getOpen_tickets() {
		return open_tickets;
	}

	/**
	 * @param open_tickets the open_tickets to set
	 */
	public void setOpen_tickets(String open_tickets) {
		this.open_tickets = open_tickets;
	}

	/**
	 * @return the inherited_tickets
	 */
	public String getInherited_tickets() {
		return inherited_tickets;
	}

	/**
	 * @param inherited_tickets the inherited_tickets to set
	 */
	public void setInherited_tickets(String inherited_tickets) {
		this.inherited_tickets = inherited_tickets;
	}

	/**
	 * @return the valid_tickets
	 */
	public String getValid_tickets() {
		return valid_tickets;
	}

	/**
	 * @param valid_tickets the valid_tickets to set
	 */
	public void setValid_tickets(String valid_tickets) {
		this.valid_tickets = valid_tickets;
	}

	/**
	 * @return the invalid_tickets
	 */
	public String getInvalid_tickets() {
		return invalid_tickets;
	}

	/**
	 * @param invalid_tickets the invalid_tickets to set
	 */
	public void setInvalid_tickets(String invalid_tickets) {
		this.invalid_tickets = invalid_tickets;
	}

	/**
	 * @return the platform_tickets
	 */
	public String getPlatform_tickets() {
		return platform_tickets;
	}

	/**
	 * @param platform_tickets the platform_tickets to set
	 */
	public void setPlatform_tickets(String platform_tickets) {
		this.platform_tickets = platform_tickets;
	}

	/**
	 * @return the unique_tickets
	 */
	public String getUnique_tickets() {
		return unique_tickets;
	}

	/**
	 * @param unique_tickets the unique_tickets to set
	 */
	public void setUnique_tickets(String unique_tickets) {
		this.unique_tickets = unique_tickets;
	}

	/**
	 * @return the original_tickets
	 */
	public String getOriginal_tickets() {
		return original_tickets;
	}

	/**
	 * @param original_tickets the original_tickets to set
	 */
	public void setOriginal_tickets(String original_tickets) {
		this.original_tickets = original_tickets;
	}

	/**
	 * @return the dsi
	 */
	public float getDsi() {
		return dsi;
	}

	/**
	 * @param dsi the dsi to set
	 */
	public void setDsi(float dsi) {
		this.dsi = dsi;
	}

	/**
	 * @return the open_dsi
	 */
	public float getOpen_dsi() {
		return open_dsi;
	}

	/**
	 * @param open_dsi the open_dsi to set
	 */
	public void setOpen_dsi(float open_dsi) {
		this.open_dsi = open_dsi;
	}

	/**
	 * @return the drr
	 */
	public float getDrr() {
		return drr;
	}

	/**
	 * @param drr the drr to set
	 */
	public void setDrr(float drr) {
		this.drr = drr;
	}

	/**
	 * @return the dre
	 */
	public float getDre() {
		return dre;
	}

	/**
	 * @param dre the dre to set
	 */
	public void setDre(float dre) {
		this.dre = dre;
	}

	/**
	 * @return the idp
	 */
	public float getIdp() {
		return idp;
	}

	/**
	 * @param idp the idp to set
	 */
	public void setIdp(float idp) {
		this.idp = idp;
	}

	/**
	 * @return the defects_per_resource
	 */
	public float getDefects_per_resource() {
		return defects_per_resource;
	}

	/**
	 * @param defects_per_resource the defects_per_resource to set
	 */
	public void setDefects_per_resource(float defects_per_resource) {
		this.defects_per_resource = defects_per_resource;
	}

	/**
	 * @return the project
	 */
	public KpiProject getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(KpiProject project) {
		this.project = project;
	}
	
	
	
}
