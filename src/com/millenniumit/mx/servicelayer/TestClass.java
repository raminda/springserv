/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
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
	KpiWatchedReleaseService kpiWatchedReleaseService;

	@Autowired
	KpiProjectService kpiProjectService;

	@Autowired
	MetricFaultBugProjectService metricFaultBugProjectService;

	@Autowired
	MetricService metricService;

	public void TestMetrics() {

		String ids = metricService.getTickets(201237, 201227, 12l, 7l, "metric_fault_bug_release",
				"open_tickets", "<=");

		String[] s = ids.split(",");
		
	
		System.out.println("Output = " + ids);
		System.out.println("size = " + s.length);

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
