package com.millenniumit.mx.data.nethdsizing.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/

@Entity(name="equipments")
@Table(name="equipments")
public class Equipments extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id 
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="EquipmentsValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "itemtypes",nullable=false)
	private ItemTypes itemtypes;
	
	private String ItemName;
	
	private String Summary;

	private String ITIC_Descrip;

	private String Comments;

	private Date EOLDate;

	private double Price;
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the itemType
	 */
	public ItemTypes getItemType() {
		return itemtypes;
	}

	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(ItemTypes itemType) {
		itemtypes = itemType;
	}

	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return ItemName;
	}

	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return Summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		Summary = summary;
	}

	/**
	 * @return the iTIC_Descrip
	 */
	public String getITIC_Descrip() {
		return ITIC_Descrip;
	}

	/**
	 * @param iTIC_Descrip the iTIC_Descrip to set
	 */
	public void setITIC_Descrip(String ITIC_Descrip) {
		this.ITIC_Descrip = ITIC_Descrip;
	}

	/**
	 * @return the tec_Descrip
	 */
	public String getTec_Descrip() {
		return Comments;
	}

	/**
	 * @param tec_Descrip the tec_Descrip to set
	 */
	public void setTec_Descrip(String Comments) {
		this.Comments = Comments;
	}

	/**
	 * @return the eOLDate
	 */
	public Date getEOLDate() {
		return EOLDate;
	}

	/**
	 * @param eOLDate the eOLDate to set
	 */
	public void setEOLDate(Date EOLDate) {
		this.EOLDate = EOLDate;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return Price;
	}

	/**
	 * @param d the price to set
	 */
	public void setPrice(double d) {
		Price = d;
	}
}