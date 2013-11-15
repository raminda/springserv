package com.millenniumit.mx.data.nethdsizing.service;

import java.sql.Date;
import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Packages;

public   interface PackagesService {
	/**
	 * 
	 * @param Level
	 * @return
	 */
	public   Packages  getPackagess(int ID);

	/**
	 * 
	 * @return
	 */
	public  List<Packages> getPackages();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<Packages> getPackages(int start, int limit);
	
	/**
	 * 
	 * @param Packages
	 */

	public  Packages getPackages(String Packages);


	/**
	 * @param date
	 * @param sumtype
	 */
	public  List<Packages> getAll(Date date, int sumtype);

	/**
	 * @param date1
	 * @param date2
	 */
	public  List<Packages> getAll(Date date1, Date date2);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(Packages index);
	
	/**
	 * 
	 * @param Packages
	 */
	public  void delete(Packages index);
	/**
	 * 
	 * @param index
	 */
	public  void update(Packages index);
}
