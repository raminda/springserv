/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * @author Vimukthi
 *
 */
@Entity(name = "IssuemanTicketLink")
@Table(name = "ticket_links")
public class IssuemanTicketLink extends AuditFields implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    private Long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@ManyToOne
	@JoinColumn(name = "ticket_link_type_id")
	private IssuemanTicketLinkType ticketLinkType;


	@ManyToOne
	@JoinColumn(name = "source_ticket_id")
	private IssuemanTicket sourceTicket;
	
	@ManyToOne
	@JoinColumn(name = "destination_ticket_id")
	private IssuemanTicket destinationTicket;

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
	 * @return the ticketLinkType
	 */
	public IssuemanTicketLinkType getTicketLinkType() {
		return ticketLinkType;
	}

	/**
	 * @param ticketLinkType the ticketLinkType to set
	 */
	public void setTicketLinkType(IssuemanTicketLinkType ticketLinkType) {
		this.ticketLinkType = ticketLinkType;
	}

	/**
	 * @return the sourceTicket
	 */
	public IssuemanTicket getSourceTicket() {
		return sourceTicket;
	}

	/**
	 * @param sourceTicket the sourceTicket to set
	 */
	public void setSourceTicket(IssuemanTicket sourceTicket) {
		this.sourceTicket = sourceTicket;
	}

	/**
	 * @return the destinationTicket
	 */
	public IssuemanTicket getDestinationTicket() {
		return destinationTicket;
	}

	/**
	 * @param destinationTicket the destinationTicket to set
	 */
	public void setDestinationTicket(IssuemanTicket destinationTicket) {
		this.destinationTicket = destinationTicket;
	}
}
