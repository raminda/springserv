/**
 * 
 */
package com.millenniumit.mx.servicelayer;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import com.google.gson.Gson;
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

	@Autowired
	@Qualifier("jiraJdbcTemplate")
	private JdbcTemplate jiraJdbcTemplate;

	@Autowired
	@Qualifier("issuemanJdbcTemplate")
	private JdbcTemplate issuemanJdbcTemplate;

	@Autowired
	private IssuemanTicketService issuemanTicketService;

	@Autowired
	private IssuemanReleaseFieldCurrentService issuemanReleaseFieldCurrentService;
	
	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");
		Gson gs = new Gson();

		System.out.println("Issue Ticket Current Value Fields = "
				+ gs.toJson(main.issuemanReleaseFieldCurrentService.getIssuemanReleaseFieldCurrent(1, 100)));
	}

	/**
	 * @return the jiraJdbcTemplate
	 */
	public JdbcTemplate getJiraJdbcTemplate() {
		return jiraJdbcTemplate;
	}

	/**
	 * @param jiraJdbcTemplate
	 *            the jiraJdbcTemplate to set
	 */
	public void setJiraJdbcTemplate(JdbcTemplate jiraJdbcTemplate) {
		this.jiraJdbcTemplate = jiraJdbcTemplate;
	}

	/**
	 * @return the issuemanJdbcTemplate
	 */
	public JdbcTemplate getIssuemanJdbcTemplate() {
		return issuemanJdbcTemplate;
	}

	/**
	 * @param issuemanJdbcTemplate
	 *            the issuemanJdbcTemplate to set
	 */
	public void setIssuemanJdbcTemplate(JdbcTemplate issuemanJdbcTemplate) {
		this.issuemanJdbcTemplate = issuemanJdbcTemplate;
	}
}
