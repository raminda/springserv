/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;

import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.service.*;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

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
//	@Qualifier("timesheetsJdbcTemplate")
//	private JdbcTemplate timesheetsJdbcTemplate;
	//
	// @Autowired
	// @Qualifier("issuemanJdbcTemplate")
	// private JdbcTemplate issuemanJdbcTemplate;
	
	@Autowired
	private TimeSheetsReminderService reminderService;
	
	@Autowired
	private PortalDivisionService divisionService;

	@Autowired
	private PortalProjectService projectService;
	
	@Autowired
	private PortalUserService userService;
	
	@Autowired
	private PortalRoleService roleService;
	
	@Autowired
	@Qualifier(value="timeSheetsWorkService")
	private WorkService<TimeSheetsWork> workService;

	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");
		
		//System.out.println("manager".split("rninr")[0]);
		
		
		
		
		
		List<PortalUser> users = main.userService.getUsers();
		
		
		
		List<PortalProject> projects = new ArrayList<PortalProject>();
		List<PortalRole> roles = new ArrayList<PortalRole>();
		//List<PortalUser> users = new ArrayList<PortalUser>();
		Date startDate = new Date(110, 5, 12);
		Date endDate = new Date(111, 5, 12);
		
Map<String, Integer> m = main.reminderService.getActivityPercentage(users, startDate, endDate);
		
		System.out.println(m.get("received"));
		
		//projects.add(project);
		
		TimeSheetsWorkCriteria c = new TimeSheetsWorkCriteria(projects, roles, users, startDate, endDate);

		//System.out.println("project = " + main.workService.getTimeSheetsWorkCount(c));
	}
}
