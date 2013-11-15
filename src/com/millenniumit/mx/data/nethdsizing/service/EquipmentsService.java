package com.millenniumit.mx.data.nethdsizing.service;


import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
public interface EquipmentsService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public  Equipments getEquipments(int ID);
	
	/**
	 * 
	 * @param Equipments
	 * @return
	 */
	
	public  Equipments getEquipments(String Equipments);
	
	/**
	 * 
	 * @return
	 */
	public  List<Equipments> getAll();

	/**
	 * 
	 * @param ItemType
	 * @return
	 */
	public  List<Equipments> getAll(ItemTypes equipmentsType);
	
	/**
	 * @param sumtype
	 * @param Price
	 * @return
	 */
	public  List<Equipments> getAll(Long Price, int sumtype);

	/**
	 * @param sumtype
	 * @param Price
	 * @return
	 */
	public  List<Equipments> getAll(Date date, int sumtype);
	
	/**
	 * @param sumtype
	 * @param Price
	 * @return
	 */
	public  List<Equipments> getAll(Date date1, Date date2);
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<Equipments> getEquipments(int start, int limit);
	
	/**
	 * @param id
	 * @return
	 */
	public List<Equipments> getBase(int id);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(Equipments index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(Equipments index);
	/**
	 * 
	 * @param index
	 * @throws Exception 
	 */
	public  void update(Equipments index) ;

}
