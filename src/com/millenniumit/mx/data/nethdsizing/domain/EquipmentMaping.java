package com.millenniumit.mx.data.nethdsizing.domain;

import java.io.Serializable;


import javax.persistence.*;


/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/

@Entity(name="equipmentmaping")
@Table(name="equipmentmaping", uniqueConstraints= @UniqueConstraint(columnNames={"CEquipment", "PEquipment"}))
public class EquipmentMaping extends AuditFields implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="EquipmentmapingValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "PEquipment",nullable=false)
	private Equipments PEquipment;

	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "CEquipment",nullable=false)
	private Equipments CEquipment;
	
	
				/*  Get Set Methods For Column*/

	
	/**
	 * @return the ID
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param name the ID to set
	 */
	public void setID(Integer ID) {
		this.ID = ID;
	}	
	
	/**
	 * @return the PEquipment
	 */
	public Equipments getPEquipment() {
		return PEquipment;
	}

	/**
	 * @param PEquipment 
	 */
	public void setPEquipment(Equipments PEquipment) {
		this.PEquipment = PEquipment;
	}
	
	/**
	 * @return the CEquipment
	 */
	public Equipments getCEquipment() {
		return CEquipment;
	}

	/**
	 * @param CEquipment
	 */
	public void setCEquipment(Equipments CEquipment) {
		this.CEquipment = CEquipment;
	}	
}

