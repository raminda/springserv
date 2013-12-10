package com.millenniumit.mx.data.nethdsizing.domain;



import java.io.Serializable;

import javax.persistence.*;



/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/
@Entity(name="versionMap")
@Table(name="versionMap", uniqueConstraints= @UniqueConstraint(columnNames={"Version","OptionID","Project","SiteID"}))
public class VersionMap extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="VersionValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private int ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Project",nullable=false)
	private Project Project;
	@Column(nullable=false)
	private String OptionID;
	@Column(nullable=false)
	private String SiteID;
	@Column(nullable=false)
	private String Version;

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @return the projectID
	 */
	public Project getProjectID() {
		return Project;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Project projectID) {
		Project = projectID;
	}

	/**
	 * @return the optionID
	 */
	public String getOptionID() {
		return OptionID;
	}

	/**
	 * @param optionID the optionID to set
	 */
	public void setOptionID(String optionID) {
		OptionID = optionID;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return Version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		Version = version;
	}

	public String getSiteID() {
		return SiteID;
	}

	public void setSiteID(String siteID) {
		SiteID = siteID;
	}						
	

	/*  Get Set Methods For Column*/
	
}