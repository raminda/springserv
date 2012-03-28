/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.millenniumit.mx.data.relman.service.RelmanReleaseService;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsReferenceService;
import com.millenniumit.mx.data.timesheets.service.TimeSheetsWorkService;
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
	private RelmanReleaseService releaseService;

	
	@Autowired
	private TimeSheetsWorkService timesheetsWorkService;

	private static ApplicationContextLoader contextLoader = new ApplicationContextLoader();

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// Initialize the Spring application main
		Main main = new Main();
		contextLoader.load(main, "applicationContext.xml");
		Gson gs = new Gson();
		
		Calendar currentDate = Calendar.getInstance();
		TimeSheetsWork timesheetsWork = new TimeSheetsWork();
		timesheetsWork.setDateCreated(currentDate.getTime());
		timesheetsWork.setDivisionId((long)2055);
		timesheetsWork.setHoursPlanned((float) 2.30);
		timesheetsWork.setHoursUnplanned((float) 3.20);
		timesheetsWork.setNote("note");
		timesheetsWork.setProjectId(1020);
		timesheetsWork.setReference("kalpa");
		timesheetsWork.setRoleId(205);
		timesheetsWork.setUpdateCount(110);
		timesheetsWork.setUserId(102);
		timesheetsWork.setWorkDate(currentDate.getTime());
	//	timesheetsWork.setId(555555);
		main.timesheetsWorkService.saveTimeSheetsWork(timesheetsWork);
	
		
	
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

	/**
	 * @return the releaseService
	 */
	public RelmanReleaseService getReleaseService() {
		return releaseService;
	}

	/**
	 * @param releaseService
	 *            the releaseService to set
	 */
	public void setReleaseService(RelmanReleaseService releaseService) {
		this.releaseService = releaseService;
	}

	/**
	 * @return the timesheetsWorkService
	 */
	public TimeSheetsWorkService getTimesheetsWorkService() {
		return timesheetsWorkService;
	}

	/**
	 * @param timesheetsWorkService the timesheetsWorkService to set
	 */
	public void setTimesheetsWorkService(TimeSheetsWorkService timesheetsWorkService) {
		this.timesheetsWorkService = timesheetsWorkService;
	}

}
