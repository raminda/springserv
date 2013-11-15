package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;

import javax.persistence.*;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/

@Entity(name="projectItems")
@Table(name="projectItems")
public class ProjectItems extends AuditFields implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="ProjectItemsValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Version_Map")
	private VersionMap VersionID;	

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Packages")
	private Packages PackageID;

	private String SiteID;

	private int Quantity;
	
	private String PackageType;											
										/*  Get Set Methods For Column*/
	/**
	 * @return the ID
	 */
	public Integer getId() {	
		return ID;
	}
	
	/**
	 * @param ID the ID to set
	 */
	public void setId(Integer ID) {
		this.ID = ID;
	}

	/**
	 * @return the Version
	 */
	public VersionMap getVersion() {
		return VersionID;
	}

	/**
	 * @param Version the Version to set
	 */
	public void setVersion(VersionMap Version) {
		this.VersionID = Version;
	}

	/**
	 * @return the packageID
	 */
	public Packages getPackageID() {
		return PackageID;
	}

	/**
	 * @param packageID the packageID to set
	 */
	public void setPackageID(Packages packageID) {
		PackageID = packageID;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return Quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	/**
	 * @return the siteID
	 */
	public String getSiteID() {
		return SiteID;
	}

	/**
	 * @param siteID the siteID to set
	 */
	public void setSiteID(String siteID) {
		SiteID = siteID;
	}

	/**
	 * @return the packageType
	 */
	public String getPackageType() {
		return PackageType;
	}

	/**
	 * @param packageType the packageType to set
	 */
	public void setPackageType(String packageType) {
		PackageType = packageType;
	}
}
