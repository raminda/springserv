/**
 * 
 */
package com.millenniumit.mx.servicelay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;

/**
 * @author Vimukthi
 * 
 */
@Service("Test")
public class TestClass {

	/*@Autowired
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
	MetricService metricService;*/
	@Autowired
	ItemTypesService itemTypesService;
	
	//@Autowired
	//ItemTypesService itemTypesServices;
	public void TestMetrics() {

		/*Map<String, String> colmap = new HashedMap();

		colmap.put("metric_fault_bug_release", "open_high_tickets");
		colmap.put("metric_fault_spec_release", "open_high_tickets");
		colmap.put("metric_spec_update_release", "open_high_tickets");

		// String ids = metricService.getSourceTickets(201238, 201220,
		// 502l,8l,7l, "metric_fault_bug_release",
		// "open_high_tickets", "<=");
		//

		String ticketString = metricService.getSourceTickets(201239, 201238, 24, 72, 7l, colmap,
				"<=");

		// String ticketString = metricService.getSourceTickets(201238, 201238,
		// 12, 0, 7l, "metric_fault_bug_project",
		// "valid_tickets", "<=");

		// String nativeIds = "";
		// String ikeys = "";
		//
		// System.out.println("ticketssssss returned = " + ticketString);
		//
		// if (ticketString != null && ticketString != "") {
		// nativeIds = issuemanTicketService.getNativeTickets(ticketString);
		// ikeys = issuemanTicketService.getTicketIkeys(ticketString);
		// }
		//
		// String[] s = ticketString.split(",");
		// String[] n = nativeIds.split(",");
		//
		// System.out.println("Output = " + ticketString);
		// System.out.println("Native Ids  = " + nativeIds);
		// System.out.println("size = " + s.length);
		// System.out.println("nsize = " + n.length);
		// System.out.println("Ikeys = " + ikeys);
*/
	}

	public void TestSourceTickets() {

		//Map<String, String> colmap = new HashedMap();

		/*colmap.put("metric_fault_bug_release", "open_high_tickets");
		colmap.put("metric_fault_spec_release", "open_high_tickets");
		colmap.put("metric_spec_update_release", "open_high_tickets");*/

//		 List<String> tickets = metricService.getSourceTicketsList(201239,
//		 201238, 24, 72, 7l, colmap,
//		 "<=");

		/*List<String> tickets = metricService.getSourceTicketsList(201239, 201151, 12, 0, 7l,
				"metric_fault_bug_project", "valid_tickets", "<=");

		List<Integer> ntickets = issuemanTicketService.getNativeTickets(StringUtils
				.collectionToCommaDelimitedString(tickets));*/
/*
		System.out.println("t size = " + tickets.size());
		System.out.println("n size = " + ntickets.size());

		String tString = Format(ntickets);
		
//		for (String string : tickets) {
//			System.out.println("ticket= " + string);
//		}
		*/
		System.out.println(itemTypesService.getItemTypess(1).getTypeName());
		ItemTypes itemTypes=new ItemTypes();
		itemTypes.setAccsessLevel(2);
		itemTypes.setTypeName("fsdfsccdf");
		try{
		itemTypesService.save(itemTypes);
		}catch(Exception e){
			System.out.println(" Err \n "+e.getMessage());
		}
//itemTypesService.getItemTypess(1);
	}

	/*private String Format(List<Integer> tickets) {

		List<String> t = new ArrayList<String>();

		for (Integer i : tickets) {
			String s = i.toString(); 
		
			
			t.add("\"" + s + "\"");
		}
		
		String ticketString = StringUtils.collectionToCommaDelimitedString(t);
		
		System.out.println("tickets string = " + ticketString);
		
		return "([ID] IN{" + ticketString.trim() + "})";
	}*/
}
