package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;

import javax.persistence.*;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/

@Entity(name="projectItems")
@Table(name="projectItems" ,uniqueConstraints= @UniqueConstraint(columnNames={ "Version_Map","Packages"}))
public class ProjectItems extends AuditFields implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="ProjectItemsValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Version_Map",nullable=false)
	private VersionMap Version_Map;	

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Packages",nullable=false)
	private Packages Packages;

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
		return Version_Map;
	}

	/**
	 * @param Version the Version to set
	 */
	public void setVersion(VersionMap Version) {
		this.Version_Map = Version;
	}

	/**
	 * @return the packageID
	 */
	public Packages getPackageID() {
		return Packages;
	}

	/**
	 * @param packageID the packageID to set
	 */
	public void setPackageID(Packages packageID) {
		Packages = packageID;
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
