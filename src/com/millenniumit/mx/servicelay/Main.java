/**
 * 
 */
package com.millenniumit.mx.servicelay;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.spring.consoleutil.ApplicationContextLoader;

/**
 * 
 * Logs issue data from issue management systems
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
//@Service("Main")
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
	
//	@Autowired
//	private KpiProjectService projectService;
//	
//	@Autowired
//	private KpiCategoryService categoryService;
//	
//	@Autowired
//	private KpiIndexService indexService;
//	
//	@Autowired
//	private KpiKpiInstanceService instanceService;
//	
//	@Autowired
//	private KpiLevelService levelService;
//	
//	@Autowired
//	private KpiIndexScoreService indexScoreService;
//	
//	@Autowired
//	private KpiKpiScoreService kpiScoreService;
//	
//	@Autowired
//	private KpiWatchedReleaseService releaseService;
	
//	@Autowired
//	@Qualifier(value="timeSheetsWorkService")
//	private WorkService<TimeSheetsWork> workService;
	@Autowired
	ItemTypesService itemTypesService;
	/**
	 * Spring application context loader
	 */
	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();
	
	/**
	 * Logger for the main class
	 */
	static final Logger logger = Logger.getLogger(Main.class);

	@Autowired
	TestClass tc;
	


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
		
		//System.out.println(new Gson().toJson(main.ks.getKpiProjects()));
		
		
		// comment this when testing
		contextLoader.load(main, "applicationContext.xml");
		
		
	
		main.tc.TestSourceTickets();

	
	}

	/**
	 * 
	 * @param map
	 */
	@SuppressWarnings("unused")
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
