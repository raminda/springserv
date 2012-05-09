/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.springframework.beans.factory.annotation.*;
import org.springframework.util.StopWatch;

import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicketType;
import com.millenniumit.mx.data.issueman.service.IssuemanProjectService;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService;

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
	@Autowired
	private IssuemanProjectService issuemanProjectService;
	

	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		String fromStr = "2005-01-01";
		String toStr = "2012-07-09";

		Date from = new Date(dateFormat.parse(fromStr).getTime());
		Date to = new Date(dateFormat.parse(toStr).getTime());
		
		
		List<IssuemanProject> projects = main.issuemanProjectService.getIssuemanProjects();
		for (IssuemanProject issuemanProject : projects) {
			System.out.println(issuemanProject.getName());
		}
		

	// main.issuemanTicketService.Init(4,1, 7, from, to); //check and
		// correct the error comes here

//		StopWatch stopWatch = new StopWatch("Stop watch");
//		
//		stopWatch.start();
//		List<IssuemanTicket> invalidTickets = main.issuemanTicketService
//				.getValidTickets(11, 1, 7, from, to);
//		stopWatch.stop();
//		System.out.println(stopWatch.prettyPrint());
//		System.out.println("Total Time = "+stopWatch.getTotalTimeSeconds());

		//
		// List<IssuemanTicket> totalTickets =
		// main.issuemanTicketService.getTotalTickets();
		// List<IssuemanTicket> copiedTickets =
		// main.issuemanTicketService.getCopiedTickets();
		// //List<IssuemanTicket> invalidTickets =
		// main.issuemanTicketService.getInvalidTickets();
		// List<IssuemanTicket> validTickets =
		// main.issuemanTicketService.getValidTickets();
		//
		// MultiMap totalMap = getFoo(totalTickets);
		// MultiMap copiedMap = getFoo(copiedTickets);
		// MultiMap invalidMap = getFoo(invalidTickets);
		// MultiMap validMap = getFoo(validTickets);
		//
		//
		// //Print(totalMap);
		//
		//
		//
		//
		//
		//
		// System.out.println("Size of Total Map = " + totalMap.size());
		// System.out.println("Size of Copied Map = " +copiedMap.size());
		// System.out.println("Size of Valid Map = " + validMap.size());
		// System.out.println("Size of Invalid Map = " + invalidMap.size());

		// System.out.println("tickets size = " + .size());
	}

	private static void Print(MultiMap map) {

		Set keySet = map.keySet();
		Iterator keyIterator = keySet.iterator();
		while (keyIterator.hasNext()) {
			Object key = keyIterator.next();
			System.out.print("Key: " + key + ", ");
			List<IssuemanTicket> values = (List<IssuemanTicket>) map.get(key);
			Iterator valuesIterator = values.iterator();
			while (valuesIterator.hasNext()) {
				System.out.print("Value: " + valuesIterator.next() + ". ");
			}
			System.out.print("\n");
		}
	}

	private static MultiMap getFoo(List<IssuemanTicket> ticketList) {

		MultiMap mhm = new MultiHashMap();

		for (IssuemanTicket issuemanTicket : ticketList) {

			Timestamp reportedDate = issuemanTicket.getReportedDate();
			Calendar c = Calendar.getInstance();
			c.setTime(reportedDate);
			int weekofYear = c.get(Calendar.WEEK_OF_YEAR);
			int year = c.get(Calendar.YEAR);
			String yearweek = year + "-" + weekofYear;
			mhm.put(yearweek, issuemanTicket);
		}
		return mhm;
	}
}
