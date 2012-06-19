/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.net.URL;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.*;

import org.springframework.util.StopWatch;



import com.millenniumit.mx.data.issueman.domain.KpiKpiDefinition;
import com.millenniumit.mx.data.issueman.service.KpiCategoryService;
import com.millenniumit.mx.data.issueman.service.KpiIndexScoreService;
import com.millenniumit.mx.data.issueman.service.KpiIndexService;
import com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService;
import com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService;
import com.millenniumit.mx.data.issueman.service.KpiKpiScoreService;
import com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService;
import com.millenniumit.mx.data.issueman.service.KpiThresholdService;
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
	
//	@Autowired
//	private TimeSheetsReminderService reminderService;
//	
//	@Autowired
//	private PortalDivisionService divisionService;
//
//	@Autowired
//	private PortalProjectService projectService;
//	
//	@Autowired
//	private PortalUserService userService;
//	
//	@Autowired
//	private PortalRoleService roleService;
	
	@Autowired
	private KpiThresholdService iService;
	
//	@Autowired
//	@Qualifier(value="timeSheetsWorkService")
//	private WorkService<TimeSheetsWork> workService;
	
	/**
	 * Spring application context loader
	 */
	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();
	
	/**
	 * Logger for the main class
	 */
	static final Logger logger = Logger.getLogger(Main.class);

	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// initialize logging
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);	
		
		logger.info("*******************Application Start********************");
		
		// Initialize the Spring application main
		Main main = new Main();
		// comment this when testing
		contextLoader.load(main, "applicationContext.xml");
		
		System.out.println(main.iService.getKpiThresholds().get(0).getGreenThreshold());
		
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
