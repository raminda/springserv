package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/
@Entity(name="equipmentbulk")
@Table(name="equipmentbulk",uniqueConstraints= @UniqueConstraint(columnNames={"Equipment", "Package"}))
public class EquipmentBulk extends AuditFields implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="EquipmentbulkValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Equipment",nullable=false)
	private Equipments EquipmentID;

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Package",nullable=false)
	private Packages PackageID;
	
	private int Quantity;
										
				/*  Get Set Methods For Column*/

	/**
	 * @return the ID
	 */
	public Integer getId() {
		return ID;
	}

	/**
	 * @param ID the Id to set
	 */
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	/**
	 * @return the Equipments
	 */
	public Equipments getEquipmentsId() {
		return EquipmentID;
	}

	/**
	 * @param EquipID the EquipItemID to set
	 */
	public void setEquipmentsId(Equipments EquipItemID) {
		this.EquipmentID = EquipItemID;
	}


	/**
	 * @return the Packages
	 */
	public Packages getPackageID() {
		return PackageID;
	}

	/**
	 * @param Packages the Packages to set
	 */
	public void setPackageID(Packages PackageID) {
		this.PackageID = PackageID;
	}

	/**
	 * @return the Quantity
	 */
	public int getQuantity() {
		return  Quantity;
	}

	/**
	 * @param  Quantity the  Quantity to set
	 */
	public void setQuantity(int Quantity) {
		this.Quantity =  Quantity;
	}
}
