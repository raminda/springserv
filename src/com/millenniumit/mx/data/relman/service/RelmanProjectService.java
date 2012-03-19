package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanProject;
import com.millenniumit.mx.data.relman.util.RelmanProjectCriteria;

/**
 * This is the Standard interface to query Relman project
 * data.
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanProjectService {
	
	/**
	 * 
	 * @return All Relman projects
	 */
	public List<RelmanProject> getRelmanProjects();
	
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return All Relman projects considering offset and the limit for records
	 */
	public List<RelmanProject> getRelmanProjects(int offset, int limit);
	
	/**
	 * 
	 * @return  All Relman projects count
	 */
	public long getRelmanProjectsCount();
	
	/**
	 * 
	 * @param criteria
	 * @return  All Relman projects for criteria
	 */
	public List<RelmanProject> getRelmanProjects(RelmanProjectCriteria criteria);
	
	/**
	 * 
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return  All Relman projects for criteria considering offset and the limit for records
	 */
	public List<RelmanProject> getRelmanProjects(RelmanProjectCriteria criteria, int offset, int limit);
	
	/**
	 * 
	 * @param criteria
	 * @return All Relman projects count for criteria
	 */
	public long getRelmanProjectsCount(RelmanProjectCriteria criteria);
	
	

	/**
	 * 
	 * @param id
	 * @return Relman project for Id
	 */
	public RelmanProject getRelmanProject(Long id);
	
	/**
	 * 
	 * @param relman_id
	 * @return Relman project for Relman Id
	 */
	public RelmanProject getRelmanProject(String relman_id);
}
