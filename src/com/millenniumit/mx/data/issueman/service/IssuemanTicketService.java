/**
 * 
 */
package com.millenniumit.mx.data.issueman.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;

/**
 * 
 * @author Kalpag
 * 
 */

public interface IssuemanTicketService {

	public enum RoleCategory {
		CLIENT, MIT, EXTQA, THINKSOFT, VIRTUSA, ALLIED, ALL
	}

	public enum IssueType {
		VALID, INVALID, CURRENTOPEN, OPEN, TOTAL, UNCOPIED, COPIED
	}

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getInvalidTickets(long projectId, long type, long subType,
			Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getTotalTickets(long projectId, long type, long subType, Date from,
			Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getValidTickets(long projectId, long type, long subType, Date from,
			Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getCopiedTickets(long projectId, long type, long subType,
			Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getUncopiedTickets(long projectId, long type, long subType,
			Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @return
	 */
	public List<IssuemanTicket> getCurrentOpenTickets(long projectId, long type, long subType,
			Date from, Date to);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roleName
	 * @param issueType
	 * @return
	 */
	public List<IssuemanTicket> getTicketsByRole(long projectId, long type, long subType,
			Date from, Date to, String roleName, IssueType issueType);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param issueType
	 * @param roles
	 * @param invertRoles
	 * @param severity
	 * @return
	 */
	public List<IssuemanTicket> getTicketsByRolesPerSeverity(long projectId, long type,
			long subType, Date from, Date to, IssueType issueType, List<String> roles,
			boolean invertRoles, String severity);

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param severity
	 * @param issueType
	 * @return
	 */
	public List<IssuemanTicket> getTicketsPerSeverity(long projectId, long type, long subType,
			Date from, Date to, String severity, IssueType issueType);

	/**
	 * 
	 * @param critical
	 * @param high
	 * @param medium
	 * @param low
	 * @param total
	 * @return
	 */
	public Float getDSI(int critical, int high, int medium, int low, int total);

	/**
	 * 
	 * @param mitValid
	 * @param extQaValid
	 * @param total
	 * @return
	 */
	public Float getDRE(int mitValid, int extQaValid, int total);

	/**
	 * 
	 * @param valid
	 * @param invalid
	 * @return
	 */
	public Float getDRR(int valid, int invalid);

	/**
	 * 
	 */
	public void resetSession();

	/**
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roles
	 * @param issueType
	 * @param severity
	 * @param invertRoles
	 * @return
	 */
	public Map<String, Integer> getTicketsCountByRolesPerSeverity(long projectId, long type,
			long subType, Date from, Date to, List<String> roles, IssueType issueType,
			String severity, boolean invertRoles);

	/**
	 * 
	 * overload of getTicketsCountByRolesPerSeverity()
	 * 
	 *  if tickets reported by all is needed pass "all" for role parameter
	 *  
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roles
	 * @param issueType
	 * @param severity
	 * @return
	 */
	public Map<String, Integer> getTicketsCountByRolePerSeverity(long projectId, long type,
			long subType, Date from, Date to, String role, IssueType issueType, String severity);

	/**
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roles
	 * @param issueType
	 * @param invertRoles
	 * @return
	 */
	public Map<String, Integer> getTicketsCountByRoles(long projectId, long type, long subType,
			Date from, Date to, List<String> roles, IssueType issueType, boolean invertRoles);

	/**
	 * 
	 * ////overload of getTicketsCountByRoles() /////
	 *  
	 *  if tickets reported by all is needed pass "all" for role parameter
	 * 
	 * @param projectId
	 * @param type
	 * @param subType
	 * @param from
	 * @param to
	 * @param roles
	 * @param issueType
	 * @return
	 */

	public Map<String, Integer> getTicketsCountByRole(long projectId, long type, long subType,
			Date from, Date to, String role, IssueType issueType);
	
	
	
	public List<IssuemanTicket> getTotalTicketsPerTbdir(long projectId, long type, long subType,
			Date from, Date to,String tbdir);

}
