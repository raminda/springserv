package com.millenniumit.mx.data.nethdsizing.dao;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 */
public interface  EquipmentsDao extends Dao <Equipments> {
							
			/* abstract Methods For  implementation in Imp. class   */
	
	/**
	 * @param ID
	 * @return
	 */
	@Override
	public  Equipments get(int ID);
	
	/**
	 * @param Equipments
	 * @return
	 */
	public  Equipments getName(String Equipments);
	
	/**
	 * @param equipmentsType
	 * @return
	 */
	public List<Equipments> getAll(ItemTypes equipmentsType);
	
	/**
	 * @param Price
	 * @param Type
	 * @param SumType= Equal-1,Greater-2,Lower-3
	 * @return
	 */
	public  List<Equipments> getAll(Long Price,int sumtype);
	
	/**
	 * @param date
	 * @param sumtype = Equal-1,Greater-2,Lower-3
	 * @return
	 */
	public  List<Equipments> getAll(Date date,int sumtype);
	
	/**
	 * @param date1
	 * @param date2
	 * @return
	 */
	public  List<Equipments> getAll(Date date1,Date date2);
	
	/**
	 * @param Start,Limit
	 * @return
	 */
	@Override
	public  List<Equipments> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	@Override
	public  List<Equipments> getAll();
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	
	@Override
	public  int save(Equipments object) ;
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public  void delete(Equipments object) ;
	
	/**
	 * 
	 * @param object
	 * @  
	 */
	@Override
	public  void update(Equipments object)  ;

	/**
	 * @param ID
	 * @return
	 */
	public List<Equipments> getBases(int ID);
	
}
