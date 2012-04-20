/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Kalpag
 * 
 */
@Entity(name = "IssuemanTicketFieldCurrent")
@Table(name = "ticket_field_current")
@DiscriminatorColumn(
	    name="field_type",
	    discriminatorType=DiscriminatorType.STRING
)
public abstract class IssuemanTicketFieldCurrent extends AuditFields implements
		Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	@Column(name = "native_id")
	private Long nativeId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ticket_id")
	private IssuemanTicket ticket;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "field_id")
	private IssuemanTicketField field;


	@Column(name = "value_int")
	private int valueInt;

	@Column(name = "value_string")
	private String valueString;

	@Column(name = "value_date")
	private Date valueDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nativeId
	 */
	public Long getNativeId() {
		return nativeId;
	}

	/**
	 * @param nativeId
	 *            the nativeId to set
	 */
	public void setNativeId(Long nativeId) {
		this.nativeId = nativeId;
	}

	

	/**
	 * @return the field
	 */
	public IssuemanTicketField getField() {
		return field;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setField(IssuemanTicketField field) {
		this.field = field;
	}

	/**
	 * @return the valueInt
	 */
	public int getValueInt() {
		return valueInt;
	}

	/**
	 * @param valueInt
	 *            the valueInt to set
	 */
	public void setValueInt(int valueInt) {
		this.valueInt = valueInt;
	}

	/**
	 * @return the valueString
	 */
	public String getValueString() {
		return valueString;
	}

	/**
	 * @param valueString
	 *            the valueString to set
	 */
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}

	/**
	 * @return the valueDate
	 */
	public Date getValueDate() {
		return valueDate;
	}

	/**
	 * @param valueDate
	 *            the valueDate to set
	 */
	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}
}
