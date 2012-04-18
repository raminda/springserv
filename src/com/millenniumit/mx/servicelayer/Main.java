/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.*;
import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketLink;
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

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
		Date from = dateFormat.parse("2010/01/01");
		Date to = dateFormat.parse("2012/04/09");
		List<IssuemanTicket> tickets = main.issuemanTicketService
				.getInvalidTickets(3, 3, 21, from, to);

		System.out.println("size of the list = " + tickets.size());

		// System.out.println("Tickets = "+gs.toJson(tickets));
		//
	}
}
