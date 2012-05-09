/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;

/**
 * 
 * @author kalpag
 * 
 */
public interface IssuemanTicketTypeService {
	public List<IssuemanTicketType> getIssuemanTicketTypes();

	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			IssuemanTicketType issuemanTicketType);

	public List<IssuemanTicketType> getIssuemanTicketSubTypes(
			String issuemanTicketTypeName);

	public List<IssuemanTicketType> getIssuemanTicketSubTypes();
}
