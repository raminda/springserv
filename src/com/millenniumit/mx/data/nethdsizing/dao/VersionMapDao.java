package com.millenniumit.mx.data.nethdsizing.dao;


import java.util.List;


import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;


/**
 * 
 * @author DECANS
 *
 */
public interface VersionMapDao extends Dao <VersionMap> {
	
				 //Methods For  implementation in Imp. interface   
		
	/**
	* 
	* @param ID
	* @return
	*/
	@Override
	public VersionMap get(int ID);
	
	/**
	 * @param VersionID
	 * @return
	 */
	public List<VersionMap> getAll(VersionMap VersionID);
	
	/**
	 * @param VersionID
	 * @param SiteID
	 * @return
	 */
	public List<String> getAll(Project project, String OptionID);
	
	/**
	 * @param VersionID
	 * @return
	 */
	public List<VersionMap> getAll(Project project);
	/**
	 * @param VersionID
	 * @param SiteID
	 * @param PackageID
	 * @return
	 */
	public  List<VersionMap> get(Project project,String OptionID, String Version);
		
	/**
	 * @param Start,Limit
	 * @return
	 */
	@Override
	public List<VersionMap> getAll(int start, int limit);
	
	/**
	 * @return
	 */
	@Override
	public List<VersionMap> getAll();
	/**
	 * @param VersionID
	 * @param SiteID
	 * @param PackageType
	 * @return
	 */
	public List<VersionMap> getAll( VersionMap VersionID,
			String SiteID, String PackageType);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<VersionMap> getAlldtl(VersionMap VersionID);
	
	
	// pass string values 
	
	/**
	 * @param VersionID
	 * @param SiteID
	 * @return
	 */
	public VersionMap get(Project project,String OptionID, String Version,String SiteID);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<String> getAllSites( VersionMap VersionID);

	/**
	 * @param VersionID
	 * @return
	 */
	public List<String> getAllPackagetype( VersionMap VersionID,String SiteID);

	/**
	 * 
	 * @param object
	 * @return
	 */
	
	@Override
	public int save(VersionMap object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void delete(VersionMap object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void update(VersionMap object);

	public List<String> getAllPackagetype(Project project);

	public List<String> getSite(Project project, String OptionID, String Version);

}


