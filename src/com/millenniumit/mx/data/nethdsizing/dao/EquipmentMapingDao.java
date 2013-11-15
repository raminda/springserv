/*
public class EuipmentMapingDao {

}
*/
package com.millenniumit.mx.data.nethdsizing.dao;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 */
public interface  EquipmentMapingDao extends Dao <EquipmentMaping> {
								
									/* Methods For  implementation in Imp. class   */
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	@Override
	public EquipmentMaping get(int ID);

	/**
	 * @param EquipmentPera
	 * @param EquipmentChild
	 * @return
	 */
	public List<EquipmentMaping> getAll(Equipments EquipmentPera,Equipments EquipmentChild);
	
	/**
	 * @param EquipmentPera
	 * @return
	 */
	public List<EquipmentMaping> getAll(Equipments EquipmentPera,ItemTypes itemType);
	
	/**
	 * @param Start,Limit
	 * @return
	 */
	@Override
	public List<EquipmentMaping> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	@Override
	public List<EquipmentMaping> getAll();
	/**
	 * 
	 * @param object
	 * @return
	 */
	
	@Override
	public int save(EquipmentMaping object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void delete(EquipmentMaping object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void update(EquipmentMaping object);
}
