/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;

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

		String ids = metricService.getSourceTickets(201238, 201219, 24l,72,  7l, "metric_fault_bug_release",
				"open_high_tickets", "<=");

		String nativeIds = issuemanTicketService.getNativeTickets(ids);
		
		String[] s = ids.split(",");
		String[] n = nativeIds.split(",");
	
		System.out.println("Output = " + ids);
		System.out.println("Native Ids  = " +nativeIds );
		System.out.println("size = " + s.length);
		System.out.println("nsize = " + n.length);

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
