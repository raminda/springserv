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
 * @author kalpag
 *
 */

@Entity(name="IssuemanSeverityFieldCurrent")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("severity")
@Where(clause="ticket_id <> 0")
public class IssuemanSeverityFieldCurrent extends IssuemanTicketFieldCurrent{

	private static final long serialVersionUID = 1L;
	
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "value_id")
	private IssuemanSeverity severity;

	/**
	 * @return the severity
	 */
	public IssuemanSeverity getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(IssuemanSeverity severity) {
		this.severity = severity;
	}
}
