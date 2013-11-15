package com.millenniumit.mx.data.nethdsizing.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/
@Entity(name="packages")
@Table(name="packages")
public class Packages extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="PackagesValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;

	private String PackageName;
	
	private String Summery;

	private long BasePrice;
	
	private String Comment;

	private Date EOLDate;
	
										
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
	 * @return the PackageName
	 */
	public String getPackageName() {
		return PackageName;
	}

	/**
	 * @param PackageName the PackageName to set
	 */
	public void setPackageName(String PackageName) {
		this.PackageName = PackageName;
	}

	/**
	 * @return the Summary
	 */
	public String getSummary() {
		return Summery;
	}

	/**
	 * @param Summary the Summary to set
	 */
	public void setSummary(String Summary) {
		this.Summery = Summary;
	}

	/**
	 * @return the Full description
	 */
	public String getComment() {
		return Comment;
	}

	/**
	 * @param Full description the Full description to set
	 */
	public void setComment(String Comment) {
		this.Comment = Comment;
	}
	
	/**
	 * @return the EOLDate
	 */
	public Date getEOLDate() {
		return EOLDate;
	}

	/**
	 * @param EOLDate the EOLDate to set
	 */
	public void setEOLDate(Date date) {
		this.EOLDate = date;
	}

	/**
	 * @return the basePrice
	 */
	public long getBasePrice() {
		return BasePrice;
	}

	/**
	 * @param basePrice the basePrice to set
	 */
	public void setBasePrice(long basePrice) {
		BasePrice = basePrice;
	}
	
}
