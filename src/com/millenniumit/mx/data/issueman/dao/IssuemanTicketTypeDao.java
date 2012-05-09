/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;
import java.util.List;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;


/**
 * 
 * @author kalpag
 *
 */
public interface IssuemanTicketTypeDao {

	public List<IssuemanTicketType> getIssuemanTicketTypes() ;
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(IssuemanTicketType issuemanTicketType);
	public List<IssuemanTicketType> getIssuemanTicketSubTypes(String issuemanTicketTypeName);
	public List<IssuemanTicketType> getIssuemanTicketSubTypes();
}
