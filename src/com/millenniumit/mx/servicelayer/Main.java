/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTypeFieldCurrent;
import com.millenniumit.mx.data.issueman.service.IssuemanReleaseFieldCurrentService;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;
import com.millenniumit.spring.consoleutil.ApplicationContextLoader;

/**
 * 
 * Logs issue data from issue management systems
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class Main {

	// These variables provide access to services and databases

//	@Autowired
//	@Qualifier("jiraJdbcTemplate")
//	private JdbcTemplate jiraJdbcTemplate;
//
//	@Autowired
//	@Qualifier("issuemanJdbcTemplate")
//	private JdbcTemplate issuemanJdbcTemplate;

	@Autowired
	private IssuemanTicketService issuemanTicketService;

	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");
		Gson gs = new Gson();

		IssuemanProject project = new IssuemanProject();
		project.setId((long) 4);

		List<IssuemanTicket> tickets = main.issuemanTicketService
				.getTicketsGroupByWeek(project, 21, 21, new Date(), new Date(), false);
		
		System.out.println("Tickets = "+gs.toJson(tickets));
	}

	/**
	 * @return the jiraJdbcTemplate
	 */
//	public JdbcTemplate getJiraJdbcTemplate() {
//		return jiraJdbcTemplate;
//	}

	/**
	 * @param jiraJdbcTemplate
	 *            the jiraJdbcTemplate to set
	 */
//	public void setJiraJdbcTemplate(JdbcTemplate jiraJdbcTemplate) {
//		this.jiraJdbcTemplate = jiraJdbcTemplate;
//	}
//
//	/**
//	 * @return the issuemanJdbcTemplate
//	 */
//	public JdbcTemplate getIssuemanJdbcTemplate() {
//		return issuemanJdbcTemplate;
//	}

	/**
	 * @param issuemanJdbcTemplate
	 *            the issuemanJdbcTemplate to set
	 */
//public void setIssuemanJdbcTemplate(JdbcTemplate issuemanJdbcTemplate) {
//		this.issuemanJdbcTemplate = issuemanJdbcTemplate;
//	}	
}
