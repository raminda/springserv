package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanLogicalLayer;
import com.millenniumit.mx.data.relman.domain.RelmanProject;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanProjectDao {
	
	/**
	 * 
	 * @param id
	 * @return RelmanProject object for Id
	 */
	public RelmanProject getRelmanProject(Long id);
	
	/**
	 * 
	 * @param relman_id
	 * @return RelmanProject object for Relman Id
	 */
	public RelmanProject getRelmanProject(String relman_id);
	
	
	
	/*************************************************************************
	 * return all functions
	 * 
	 ************************************************************************/
	
	/**
	 * 
	 * @return get all Relman Projects
	 */
	public List<RelmanProject> getRelmanProjects();

	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @param type
	 * @return get all Relman Projects
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId, String type);

	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @return get all Relman Projects
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId);

	/**
	 * 
	 * @param logicalLayer
	 * @param type
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, String type);

	/**
	 * 
	 * @param relmanLayerId
	 * @param type
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			String type);

	/**
	 * 
	 * @param relmanLayerId
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId);

	/**
	 * 
	 * @param logicalLayer
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(RelmanLogicalLayer logicalLayer);

	/**
	 * 
	 * @param type
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(String type);

	
	/*************************************************************************
	 * pagination functions
	 * 
	 ************************************************************************/
	
	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @param type
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId,
			String type, int offset, int limit);

	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, Integer relmanLayerId, int offset,
			int limit);

	/**
	 * 
	 * @param logicalLayer
	 * @param type
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, String type, int offset, int limit);

	/**
	 * 
	 * @param relmanLayerId
	 * @param type
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			String type, int offset, int limit);

	/**
	 * 
	 * @param relmanLayerId
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(Integer relmanLayerId,
			int offset, int limit);

	/**
	 * 
	 * @param logicalLayer
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(
			RelmanLogicalLayer logicalLayer, int offset, int limit);

	/**
	 * 
	 * @param type
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(String type, int offset,
			int limit);

	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<RelmanProject> getRelmanProjects(int offset, int limit);

	
	/*************************************************************************
	 * Count functions
	 * 
	 ************************************************************************/
	
	/**
	 * 
	 * @return
	 */
	public long getRelmanProjectsCount();

	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @param type
	 * @return
	 */
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			Integer relmanLayerId, String type);

	/**
	 * 
	 * @param logicalLayer
	 * @param relmanLayerId
	 * @return
	 */
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			Integer relmanLayerId);

	/**
	 * 
	 * @param logicalLayer
	 * @param type
	 * @return
	 */
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer,
			String type);

	/**
	 * 
	 * @param relmanLayerId
	 * @param type
	 * @return
	 */
	public long getRelmanProjectsCount(Integer relmanLayerId, String type);

	/**
	 * 
	 * @param relmanLayerId
	 * @return
	 */
	public long getRelmanProjectsCount(Integer relmanLayerId);

	/**
	 * 
	 * @param logicalLayer
	 * @return
	 */
	public long getRelmanProjectsCount(RelmanLogicalLayer logicalLayer);

	/**
	 * 
	 * @param type
	 * @return
	 */
	public long getRelmanProjectsCount(String type);	
}
