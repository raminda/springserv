package com.millenniumit.mx.data.nethdsizing.service;
import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Company;

public interface CompanyService {


	
	/**
	 * 
	 * @param Level
	 * @return
	 */
	public  List<Company> getAll();
	
	/**
	 * 
	 * @param AcssUser
	 * @return
	 */
	
	public  List<Company> getAll(int Strat,int End);
	
	/**
	 * 
	 * @return
	 */
	public  Company get(int ID);
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public  Company get(String Companyname);
	
	/**
	 * 
	 * @param index
	 * @return
	 * @throws Exception 
	 */
	public  int save(Company index) ;
	
	/**
	 * 
	 * @param index
	 * @throws Exception 
	 */
	public  void delete(Company index);
	/**
	 * 
	 * @param index
	 */
	public  void update(Company index);
}

