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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;
import org.springframework.beans.factory.annotation.*;

import org.springframework.util.StopWatch;



import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.domain.PortalUser;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.service.*;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

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

	

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
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
