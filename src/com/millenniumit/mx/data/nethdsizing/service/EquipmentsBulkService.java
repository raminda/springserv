package com.millenniumit.mx.data.nethdsizing.service;

/*public class EquipmentsBulkService {

}
*/

import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
/**
 * 
 * @author Raminda
 *
 */
public interface EquipmentsBulkService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public  EquipmentBulk getEquipmentsBulks(int id);
	
	/**
	 * 
	 * @param EquipmentsID
	 * @return
	 */
	
	public   List<EquipmentBulk> getEquipmentsBulk(Equipments EquipmentID);
	
	/**
	 * 
	 * @param Package ID
	 * @return
	 */
	public   List<EquipmentBulk> getPackageBulk(Packages PackageID);
	
	/**
	 * 
	 * @return
	 */
	public  List<EquipmentBulk> getEquipmentsBulk();
	
	/**
	 * 
	 * @param Package
	 * @param Equipment
	 * @return
	 */
	public  EquipmentBulk EquipmentsBulkget(Packages PackageID, Equipments ItemId);
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<EquipmentBulk> getEquipmentsBulk(int start, int limit);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(EquipmentBulk index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(EquipmentBulk index);
	/**
	 * 
	 * @param index
	 */
	public  void update(EquipmentBulk index);
	
	
}
