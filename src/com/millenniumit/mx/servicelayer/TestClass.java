/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.millenniumit.mx.data.issueman.service.IssuemanTicketService;
import com.millenniumit.mx.data.kpi.service.KpiLevelService;
import com.millenniumit.mx.data.kpi.service.KpiProjectService;
import com.millenniumit.mx.data.kpi.service.KpiWatchedReleaseService;
import com.millenniumit.mx.data.kpi.service.MetricFaultBugProjectService;
import com.millenniumit.mx.data.kpi.service.MetricService;

/**
 * @author Vimukthi
 * 
 */
public class TestClass {

	@Autowired
	KpiLevelService kpiLevelService;

	@Autowired
	IssuemanTicketService issuemanTicketService;
	
	@Autowired
	KpiWatchedReleaseService kpiWatchedReleaseService;

	@Autowired
	KpiProjectService kpiProjectService;

	@Autowired
	MetricFaultBugProjectService metricFaultBugProjectService;

	@Autowired
	MetricService metricService;

	public void TestMetrics() {

		
	
		
		
		Map<String, String> colmap = new HashedMap();
		
		colmap.put("metric_fault_bug_project", "open_high_tickets");
		colmap.put("metric_fault_spec_project", "open_high_tickets");
		colmap.put("metric_spec_update_project", "open_high_tickets");
		
		
		
//		String ids = metricService.getSourceTickets(201238, 201220, 502l,8l,7l, "metric_fault_bug_release",
//				"open_high_tickets", "<=");
//		
		
		String ticketString = metricService.getSourceTickets(201238, 201238, 12,0,7l,colmap, "<=");
		
		System.out.println("ticketssssss returned = " + ticketString);
		
		

		String nativeIds = issuemanTicketService.getNativeTickets(ticketString);
		String ikeys = issuemanTicketService.getTicketIkeys(ticketString);
		
		String[] s = ticketString.split(",");
		String[] n = nativeIds.split(",");
	
		System.out.println("Output = " + ticketString);
		System.out.println("Native Ids  = " +nativeIds );
		System.out.println("size = " + s.length);
		System.out.println("nsize = " + n.length);
		System.out.println("Ikeys = " +ikeys);

	}

	public void TestKpis() {

		try {

			Gson gs = new Gson();
			String op = gs.toJson(kpiProjectService.getKpiProjects());
			System.out.println("Output = " + op);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
