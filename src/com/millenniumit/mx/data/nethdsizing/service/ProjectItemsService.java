package com.millenniumit.mx.data.nethdsizing.service;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;

public interface ProjectItemsService {
	/**
	 * 
	 * @param ID
	 * @return
	 */
	public   ProjectItems  getProjectItemss(int ID);

	/**
	 * 
	 * @return
	 */
	public   List<ProjectItems> getAll();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public   List<ProjectItems> getAll(int start, int limit);
	
	/**
	 * 
	 * @param Project
	 * @return
	 */
	public   List<ProjectItems> getAll(VersionMap VersionID) ;
	
/*	*//**
	 * 
	 * @param date
	 * @param sumtype
	 * @return
	 *//*
	public   List<ProjectItems> getAll(Date date, int sumtype);
	
	*//**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 *//*
	public   List<ProjectItems> getAll(Date date1, Date date2);*/
	public ProjectItems get(VersionMap VersionID, String SiteID, Packages PackageID);
	
	public List<ProjectItems> getAll(VersionMap VersionID,String SiteID);

	/**
	 * @param string
	 * @param lenth
	 * @return
	 */
	public List<String> getAllString(VersionMap VersionID,String[] string, int lenth);

	/**
	 * @param ProjectID
	 * @param OptionID
	 * @param VersionID
	 * @param SiteID
	 * @param PacakgeType
	 * @return
	 */
	public List<ProjectItems> getAll(VersionMap VersionID, String SiteID, String PacakgeType);

	/**
	 * @param ProjectID
	 * @return
	 */
	public List<ProjectItems> getAlldtl(VersionMap VersionID);
	/**
	 * 
	 * @param index
	 * @return
	 */
	public   int save(ProjectItems index);
	
	/**
	 * 
	 * @param index
	 */
	public   void delete(ProjectItems index);
	/**
	 * 
	 * @param index
	 */
	public  void update(ProjectItems index);
}
