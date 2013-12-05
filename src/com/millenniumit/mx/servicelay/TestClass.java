/**
 * 
 */
package com.millenniumit.mx.servicelay;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentMapingService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsBulkService;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsService;
import com.millenniumit.mx.data.nethdsizing.service.ItemTypesService;
import com.millenniumit.mx.data.nethdsizing.service.PackagesService;

/**
 * @author Vimukthi
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
	public void TestMetrics() {
	}

	public void TestSourceTickets() {
		System.out.println(packagesService.getPackages().get(0).getPackageName());
		equipmentsBulkService.EquipmentsBulkget(packagesService.getPackages("fd"),equipmentsService.getEquipments("Serve22"));
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
	}
}
