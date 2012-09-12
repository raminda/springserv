/**
 * 
 */
package com.millenniumit.mx.servicelayer;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.millenniumit.mx.data.kpi.service.KpiLevelService;
import com.millenniumit.mx.data.kpi.service.KpiProjectService;
import com.millenniumit.mx.data.kpi.service.KpiWatchedReleaseService;

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

	public void testHello() {
		System.out.println("hello    tessssssst");
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
