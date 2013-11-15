package com.millenniumit.mx.data.nethdsizing.dao;

import java.sql.Date;
import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author Raminda
 * 
 */
public interface PackagesDao extends Dao<Packages> {


					/* Methods For  implementation in Imp. interface   */
	
	/**
	* 
	* @param ID
	* @return
	*/
	@Override
	public Packages get(int ID);
	
	/**
	 * @param PackagesName
	 * @return
	 */
	public Packages get(String Packages);


	/**
	 * @param data
	 * @param Type
	 * @param =LUdate-1,EOL-2
	 * @param = Equal-1,Greater-2,Lower-3
	 * @return
	 */
	public List<Packages> getAll(Date date,int sumtype );

	/**
	 * @param Start
	 * @param Limit
	 * @return
	 */
	@Override
	public List<Packages> getAll(int start, int limit);

	/**
	 * 
	 * @return
	 */
	@Override
	public List<Packages>getAll();

	
	/**
	 * @param date1,date2
	 * @param type= LUDate-1,EOL-2
	 * @return
	 */
	public List<Packages> getAll(Date date1, Date date2);
	/**
	 * 
	 * @param object
	 * @return
	 */
	
	@Override
	public int save(Packages object) ;
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void delete(Packages object) ;
	
	/**
	 * 
	 * @param object
	 * @  
	 */
	@Override
	public void update(Packages object)  ;
}