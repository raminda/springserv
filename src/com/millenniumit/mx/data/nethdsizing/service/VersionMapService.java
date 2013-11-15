package com.millenniumit.mx.data.nethdsizing.service;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
/**
 * 
 * @author Raminda
 *
 */
public interface VersionMapService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public  VersionMap get(int id);
	
	/**
	 * 
	 * @param Version_MapsName
	 * @return
	 */
	public  VersionMap getVersion_Maps(String Version_MapsName);
	
	/**
	 * 
	 * @param Company
	 * @return
	 */
	public  List <VersionMap> getCompany(Company company);
	
	/**
	 * 
	 * @return
	 */
	public  List<VersionMap> getVersion_Maps();

	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<VersionMap> getVersion_Maps(int start, int limit);
	
	/**
	 * 
	 * @return
	 */
	public List<String> getAllNames();
	/**
	 * 
	 * @param index
	 * @return
	 */
	public  int save(VersionMap index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(VersionMap index);
	/**
	 * 
	 * @param index
	 */
	public  void update(VersionMap index);

	/**
	 * @return
	 */
}
