package com.millenniumit.mx.data.nethdsizing.service;



import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
public interface  EquipmentMapingService {
	
	/**
	 * 
	 * @param Level
	 * @return
	 */
	public  List<EquipmentMaping> getEquipmentMapings(Equipments PerantID,ItemTypes itemType);
	
	/**
	 * 
	 * @param AcssUser
	 * @return
	 */
	
	public  List<EquipmentMaping> getEquipmentMapings(Equipments PerantID,Equipments ChildID);
	
	/**
	 * 
	 * @return
	 */
	public  List<EquipmentMaping> getEquipmentMapings();
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public  EquipmentMaping getEquipmentMapings(int ID);
	
	
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<EquipmentMaping> getEquipmentMapings(int start, int limit);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(EquipmentMaping index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(EquipmentMaping index);
	/**
	 * 
	 * @param index
	 */
	public  void update(EquipmentMaping index);
}

