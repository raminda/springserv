package com.millenniumit.mx.data.nethdsizing.dao;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author DECANS
 *
 */
public interface  ItemTypesDao extends Dao <ItemTypes> {
								
									/* Methods For  implementation in Imp. class   */
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	@Override
	public ItemTypes get(int ID);

	/**
	 * @param ItemtypesName
	 * @return
	 */
	public ItemTypes get(String ItemtypesName);
	
	/**
	 * @param ItemtypesName
	 * @return
	 */
	public List<ItemTypes> getAll(int AccsessLevel);
	
	/**
	 * @param Start,Limit
	 * @return
	 */
	@Override
	public List <ItemTypes> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	@Override
	public List <ItemTypes> getAll();
	/**
	 * 
	 * @param object
	 * @return
	 */
	
	@Override
	public int save(ItemTypes object)  ;
	
	/**
	 * 
	 * @param object
	 * @  
	 */
	@Override
	public void delete(ItemTypes object)  ;
	
	/**
	 *@param object
	 * @  
	 */
	@Override
	public void update(ItemTypes object)  ;
}
