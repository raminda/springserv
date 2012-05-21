/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService.IssueType;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketTypeService;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService.RoleCategory;

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

		StopWatch stopWatch = new StopWatch("Stop watch");
		stopWatch.start();

//		Map<String, Integer> totalMap = main.issuemanTicketService
//				.getTicketsCountByRoleCategoryPerSeverity(7, 1, 7, from, to,
//						RoleCategory.ALL, IssueType.TOTAL, "HIGH");

		
		Map<String, Integer> totalMap = main.issuemanTicketService.getTicketsCountByRoleCategory(7, 1, 7, from, to,
						RoleCategory.ALL, IssueType.TOTAL);
		
		
		PrintMap(totalMap);
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
		System.out.println("Total Time = " + stopWatch.getTotalTimeSeconds());
	}

	/**
	 * 
	 * @param map
	 */
	private static void PrintMap(Map<String, Integer> map) {
		Iterator<String> iterator = map.keySet().iterator();

		int count = 0;
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			int value = map.get(key);
			count += value;
			System.out.println("key = " + key + "  " + " value = " + value);
		}
		System.out.println("Total Value = " + count);
	}
}
