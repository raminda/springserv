package com.millenniumit.mx.data.nethdsizing.service;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
public interface  ItemTypesService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public  ItemTypes getItemTypess(int id);
	
	/**
	 * 
	 * @param ItemTypes
	 * @return
	 */
	
	public  ItemTypes get(String ItemTypes);
	
	/**
	 * 
	 * @return
	 */
	public  List<ItemTypes> getItemTypes();
	
	
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<ItemTypes> getItemTypes(int start, int limit);
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(ItemTypes index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(ItemTypes index);
	/**
	 * 
	 * @param index
	 * @throws Exception 
	 */
	public  void update(ItemTypes index);

	
}
