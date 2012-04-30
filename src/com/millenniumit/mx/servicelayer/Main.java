/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.IssueType;
import com.millenniumit.mx.data.issueman.dao.impl.IssuemanTicketDaoImpl.RoleCategory;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
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

	// @Autowired
	// @Qualifier("jiraJdbcTemplate")
	// private JdbcTemplate jiraJdbcTemplate;
	//
	// @Autowired
	// @Qualifier("issuemanJdbcTemplate")
	// private JdbcTemplate issuemanJdbcTemplate;

	@Autowired
	private IssuemanTicketService issuemanTicketService;

	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();
	private static final Logger LOG = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");
		Gson gs = new Gson();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date from = dateFormat.parse("2005-01-01");
		Date to = dateFormat.parse("2012-07-09");
		// List<IssuemanTicket> tickets = main.issuemanTicketService
		// .getInvalidTickets(3, 3, 21, from, to);

		// main.issuemanTicketService.Init(4,1, 7, from, to); //check and
		// correct the error comes here

		main.issuemanTicketService.Init(4, 1, 7, from, to);
		// List<IssuemanTicket> tickets =
		// main.issuemanTicketService.getTotalTickets();

		List<IssuemanTicket> tickets = main.issuemanTicketService
				.getTicketsByRoleCategory(RoleCategory.MIT, IssueType.TOTAL);

		System.out.println("tickets size = "
				+ tickets.size());

	}
}
