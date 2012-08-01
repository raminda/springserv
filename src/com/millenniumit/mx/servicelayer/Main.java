/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.io.File;
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
import java.util.SortedMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.*;

import org.springframework.util.StopWatch;



import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanRelease;
import com.millenniumit.mx.data.issueman.domain.KpiKpiDefinition;
import com.millenniumit.mx.data.issueman.domain.KpiKpiInstance;
import com.millenniumit.mx.data.issueman.domain.KpiWatchedRelease;
import com.millenniumit.mx.data.issueman.service.IssuemanProjectService;
import com.millenniumit.mx.data.issueman.service.IssuemanReleaseService;
import com.millenniumit.mx.data.issueman.service.KpiCategoryService;
import com.millenniumit.mx.data.issueman.service.KpiIndexScoreService;
import com.millenniumit.mx.data.issueman.service.KpiIndexService;
import com.millenniumit.mx.data.issueman.service.KpiKpiDefinitionService;
import com.millenniumit.mx.data.issueman.service.KpiKpiInstanceService;
import com.millenniumit.mx.data.issueman.service.KpiKpiScoreService;
import com.millenniumit.mx.data.issueman.service.KpiLevelService;
import com.millenniumit.mx.data.issueman.service.KpiScoringSchemeService;
import com.millenniumit.mx.data.issueman.service.KpiThresholdService;
import com.millenniumit.mx.data.issueman.service.KpiWatchedReleaseService;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.service.*;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;
import com.millenniumit.mx.utils.excelexporter.ExcelExporter;
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
	
//	@Autowired
//	private IssuemanProjectService projectService;
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
		
		
		File file = new File("C:\\Users\\kalpag\\Desktop\\exporterTest.xls");
		file.createNewFile();
		
		Map<String, Object> sMap = new HashMap<String, Object>();	
		Map<String, Object> tMap = new HashMap<String, Object>();	
		Map<String, Object> uMap = new HashMap<String, Object>();	
		
		sMap.put("name","kalpa");
		sMap.put("age","24");
		sMap.put("town","panadura");
		
		tMap.put("name","vihangi");
		tMap.put("age","23");
		tMap.put("town","wadduwa");
		
		uMap.put("name","prarthana");
		uMap.put("age","15");
		uMap.put("town","borella");
		
	
		List<Map<String, Object>> valuesList = new ArrayList<Map<String,Object>>();
		valuesList.add(sMap);
		valuesList.add(tMap);
		valuesList.add(uMap);
		
		
		
		Map<String, Object> sMap1 = new HashMap<String, Object>();	
		Map<String, Object> tMap1 = new HashMap<String, Object>();	
		Map<String, Object> uMap1 = new HashMap<String, Object>();	
		
		sMap1.put("name","sunera");
		sMap1.put("age","25");
		sMap1.put("town","kalutara");
		
		tMap1.put("name","dilan");
		tMap1.put("age","25");
		tMap1.put("town","wadiyamankada");
		
		uMap1.put("name","ruwanthi");
		uMap1.put("age","26");
		uMap1.put("town","hospital");
		
		
		
		List<Map<String, Object>> valuesList2 = new ArrayList<Map<String,Object>>();
		valuesList2.add(sMap1);
		valuesList2.add(tMap1);
		valuesList2.add(uMap1);
		
		ExcelExporter ex = new ExcelExporter(file);
		ex.createExcelSheet("firstSheet", 0, valuesList);
		ex.createExcelSheet("secondsheet", 1, valuesList2);
		ex.export();
//		IssuemanProject p = main.projectService.getIssuemanProject(11L);
//		KpiWatchedRelease r = main.releaseService.getWatchedRelease(2L);
//		KpiKpiInstance i = main.instanceService.getKpiKpiInstance(12L);
//		
//		System.out.println(main.releaseService.getWatchedReleases(p, null));
		
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
