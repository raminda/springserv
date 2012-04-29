/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;
/**
 * @author Kalpag
 *
 */
@Entity(name="IssuemanTypeFieldCurrent" )
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("type")
@Where(clause="ticket_id <> 0")
public class IssuemanTypeFieldCurrent extends IssuemanTicketFieldCurrent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "value_id" ,insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	private IssuemanTicketType ticketType;

	/**
	 * @return the ticketType
	 */
	public IssuemanTicketType getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType the ticketType to set
	 */
	public void setTicketType(IssuemanTicketType ticketType) {
		this.ticketType = ticketType;
	}

	
	
}
