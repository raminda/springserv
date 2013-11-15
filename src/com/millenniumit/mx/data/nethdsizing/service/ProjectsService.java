package com.millenniumit.mx.data.nethdsizing.service;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
/**
 * 
 * @author Raminda
 *
 */
public interface ProjectsService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public  Project getProjects(int id);
	
	/**
	 * 
	 * @param ProjectsName
	 * @return
	 */
	public  Project getProjects(String ProjectsName);
	
	/**
	 * 
	 * @param Company
	 * @return
	 */
	public  List <Project> getCompany(Company company);
	
	/**
	 * 
	 * @return
	 */
	public  List<Project> getProjects();

	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public  List<Project> getProjects(int start, int limit);
	
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
	public  int save(Project index);
	
	/**
	 * 
	 * @param index
	 */
	public  void delete(Project index);
	/**
	 * 
	 * @param index
	 */
	public  void update(Project index);

	/**
	 * @return
	 */
}
