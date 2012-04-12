/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "IssuemanTicketFieldHistory")
@Table(name = "ticket_field_history")
@DiscriminatorColumn(name = "field_type")
public abstract class IssuemanTicketFieldHistory extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id 
    private Long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	private IssuemanTicket ticket;
	
	@ManyToOne
	@JoinColumn(name = "field_id")
	private IssuemanTicketField field;
	
	@Column(name = "is_current")
	private int isCurrent;
	
	@Column(name = "modified_by")
	private Long modifiedBy;
	
	@Column(name = "modified_date")
	private Timestamp modifiedDate;
	
	@Column(name = "old_id")
	private Long oldId;
	
	@Column(name = "new_id")
	private Long newId;
	
	@Column(name = "old_int_val")
	private int oldIntVal;
	
	@Column(name = "int_val")
	private int intVal;
	
	@Column(name = "old_string_val")
	private String oldStringVal;
	
	@Column(name = "string_val")
	private String stringVal;
	
	@Column(name = "old_date_val")
	private Timestamp oldDateVal;
	
	@Column(name = "date_val")
	private Timestamp dateVal;

	/**
	 * @return the oldId
	 */
	public Long getOldId() {
		return oldId;
	}

	/**
	 * @param oldId the oldId to set
	 */
	public void setOldId(Long oldId) {
		this.oldId = oldId;
	}

	/**
	 * @return the newId
	 */
	public Long getNewId() {
		return newId;
	}

	/**
	 * @param newId the newId to set
	 */
	public void setNewId(Long newId) {
		this.newId = newId;
	}

	/**
	 * @return the oldIntVal
	 */
	public int getOldIntVal() {
		return oldIntVal;
	}

	/**
	 * @param oldIntVal the oldIntVal to set
	 */
	public void setOldIntVal(int oldIntVal) {
		this.oldIntVal = oldIntVal;
	}

	/**
	 * @return the intVal
	 */
	public int getIntVal() {
		return intVal;
	}

	/**
	 * @param intVal the intVal to set
	 */
	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}

	/**
	 * @return the oldStringVal
	 */
	public String getOldStringVal() {
		return oldStringVal;
	}

	/**
	 * @param oldStringVal the oldStringVal to set
	 */
	public void setOldStringVal(String oldStringVal) {
		this.oldStringVal = oldStringVal;
	}

	/**
	 * @return the stringVal
	 */
	public String getStringVal() {
		return stringVal;
	}

	/**
	 * @param stringVal the stringVal to set
	 */
	public void setStringVal(String stringVal) {
		this.stringVal = stringVal;
	}

	/**
	 * @return the oldDateVal
	 */
	public Timestamp getOldDateVal() {
		return oldDateVal;
	}

	/**
	 * @param oldDateVal the oldDateVal to set
	 */
	public void setOldDateVal(Timestamp oldDateVal) {
		this.oldDateVal = oldDateVal;
	}

	/**
	 * @return the dateVal
	 */
	public Timestamp getDateVal() {
		return dateVal;
	}

	/**
	 * @param dateVal the dateVal to set
	 */
	public void setDateVal(Timestamp dateVal) {
		this.dateVal = dateVal;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the isCurrent
	 */
	public int getIsCurrent() {
		return isCurrent;
	}

	/**
	 * @param isCurrent the isCurrent to set
	 */
	public void setIsCurrent(int isCurrent) {
		this.isCurrent = isCurrent;
	}

	/**
	 * @return the modifiedBy
	 */
	public Long getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedDate
	 */
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the nativeId
	 */
	public Long getNativeId() {
		return nativeId;
	}

	/**
	 * @param nativeId the nativeId to set
	 */
	public void setNativeId(Long nativeId) {
		this.nativeId = nativeId;
	}

	/**
	 * @return the ticket
	 */
	public IssuemanTicket getTicket() {
		return ticket;
	}

	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(IssuemanTicket ticket) {
		this.ticket = ticket;
	}

	/**
	 * @return the field
	 */
	public IssuemanTicketField getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(IssuemanTicketField field) {
		this.field = field;
	}
}
