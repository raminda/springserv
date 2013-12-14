package com.millenniumit.mx.data.nethdsizing.service;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Project;
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
	 * @param VersionMap index
	 * @param String OptionID
	 * @return
	 */
	public  List<String> getVersion_Maps(Project project, String OptionID);
	
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
	 * @param project
	 * @return
	 */
	public List<VersionMap> getAll(Project project);
	
	/**
	 * @param project
	 * @param OptionID
	 * @param Version
	 * @return
	 */
	public List<VersionMap> getAll(Project project, String OptionID,String Version);
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

	public List<String> getProjects(Project project);

	public VersionMap getAll(Project project, String OptionID, String Version,
			String SiteID);

	public List<String> getSite(Project project, String OptionID, String Version);

	/**
	 * @return
	 */
}
