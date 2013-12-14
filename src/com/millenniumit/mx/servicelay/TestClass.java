/**
 * 
 */
package com.millenniumit.mx.servicelay;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.service.CompanyService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentMapingService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsBulkService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsService;
import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.mx.data.nethdsizing.service.PackagesService;
import com.millenniumit.mx.data.nethdsizing.service.ProjectItemsService;
import com.millenniumit.mx.data.nethdsizing.service.ProjectsService;
import com.millenniumit.mx.data.nethdsizing.service.VersionMapService;

/**
 * @author Decans
 * 
 */
@Service("Test")
public class TestClass {

	
	@Autowired
	ItemTypesService itemTypesService;
	
	@Autowired
	EquipmentsService equipmentsService;
	
	@Autowired
	EquipmentMapingService equipmentMapingService;
	
	@Autowired
	PackagesService packagesService;
	@Autowired
	EquipmentsBulkService equipmentsBulkService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	VersionMapService versionMapService;
	
	@Autowired
	ProjectsService projectService;
	
	@Autowired
	ProjectItemsService projectItemsService;
	public void TestMetrics() {
	}

	public void TestSourceTickets() {
		System.out.println(packagesService.getPackages().get(0).getPackageName());
		System.out.println(equipmentsBulkService.getPackageBulk(packagesService.getPackagess(1)).get(0).getPackageID().getPackageName());
		System.out.println(companyService.get("nirobi").getCompanyName());
		System.out.println(itemTypesService.get("RAM").getTypeName());
		System.out.println(equipmentMapingService.getEquipmentMapings(equipmentsService.getEquipments(3), itemTypesService.getItemTypess(2)).get(0).getCEquipment().getItemName());
		List<String> PacakgeTypes=projectItemsService.getPackageType(versionMapService.getAll(projectService.getProjects("Dhilli"), "Op12","1.12","Primary"));
		System.out.println(PacakgeTypes.size());
		//System.out.println(equipmentsBulkService.EquipmentsBulkgetD(packagesService.getPackagess(1), equipmentMapingService.getEquipmentMapings(equipmentsService.getEquipments(3), itemTypesService.getItemTypess(2)).get(0).getCEquipment()).get(0).getEquipmentsId().getItemName());
		//packagesService.delete(packagesService.getPackagess(2));
		/*ItemTypes itemTypes=new ItemTypes();
		itemTypes.setAccsessLevel(2);
		itemTypes.setTypeName("fsdfsccdf");
		try{
		itemTypesService.save(itemTypes);
		}catch(Exception e){
			System.out.println(" Err \n "+e.getMessage());
		}*/
		//System.out.println(equipmentMapingService.getEquipmentMapings(equipmentsService.getEquipments(9), 0).get(0).getChildID().getItemName());
		//List <EquipmentMaping> list=equipmentMapingService.getEquipmentMapings(equipmentsService.getEquipments(10), 1);
		//System.out.println(list.size());
		/*for(int i=0;i<list.size();i++){
			equipmentMapingService.delete(list.get(i));
		}*/
		List<String> a= versionMapService.getProjects(projectService.getProjects("Dhilli"));
		System.out.println(a.size());
	}
}
