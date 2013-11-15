package com.millenniumit.mx.data.nethdsizing.domain;



import java.io.Serializable;

import javax.persistence.*;



/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/
@Entity(name="versionMap")
@Table(name="versionMap")
public class VersionMap extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="VersionValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private int ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Project")
	private Project ProjectID;
	
	private String OptionID;
	
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
		return ProjectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Project projectID) {
		ProjectID = projectID;
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
	

	/*  Get Set Methods For Column*/
	
}