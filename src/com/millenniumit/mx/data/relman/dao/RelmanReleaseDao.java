package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * Standard Relman release Dao
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanReleaseDao {	
	
	/**
	 * 
	 * @param relmanId
	 * @return The Relman release for the given Relman id
	 */
	public RelmanRelease getRelmanRelease(String relmanId);
	
	/**
	 * 
	 * @param id
	 * @return The Relman release for the given id
	 */
	public RelmanRelease getRelmanRelease(Long id);
	
	/**
	 * 
	 * @return All Relman releases
	 */
	public List<RelmanRelease> getRelmanReleases();
	
	/**
	 * 
	 * @return
	 */
	public long getRelmanReleasesCount();
	
	/**
	 * 
	 * @param project
	 * @return Relman releases for the given project
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanProject project);
	
	/**
	 * 
	 * @param project
	 * @return
	 */
	public long getRelmanReleasesCount(RelmanProject project);
	
	/**
	 * 
	 * @param parentRelease
	 * @return Relman releases for the given parent release
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease);
	
	/**
	 * 
	 * @param parentRelease
	 * @return
	 */
	public long getRelmanReleasesCount(RelmanRelease parentRelease);
	
	/**
	 * 
	 * @param status
	 * @return Relman releases in given status
	 */
	public List<RelmanRelease> getRelmanReleases(String status);
	
	/**
	 * 
	 * @param status
	 * @return
	 */
	public long getRelmanReleasesCount(String status);
	
	/**
	 * 
	 * @param project
	 * @param status
	 * @return Relman releases with the given status in the given project
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			String status);	
	
	/**
	 * 
	 * @param project
	 * @param status
	 * @return
	 */
	public long getRelmanReleasesCount(RelmanProject project,
			String status);	
	
	/**
	 * 
	 * @param parentRelease
	 * @param status
	 * @return Relman releases with the given status for the given parent release
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease, String status);
	
	/**
	 * 
	 * @param parentRelease
	 * @param status
	 * @return
	 */
	public long getRelmanReleasesCount(RelmanRelease parentRelease, String status);
	
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return All Relman releases
	 */
	public List<RelmanRelease> getRelmanReleases(int offset, int limit);	

	/**
	 * 
	 * @param project
	 * @param offset
	 * @param limit
	 * @return Relman releases for the given project
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			int offset, int limit);

	/**
	 * 
	 * @param parentRelease
	 * @param offset
	 * @param limit
	 * @return Relman releases for the given parent release
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease,
			int offset, int limit);

	/**
	 * 
	 * @param parentRelease
	 * @param state
	 * @param offset
	 * @param limit
	 * @return Relman releases with the given status for the given parent release
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanRelease parentRelease,
			String status, int offset, int limit);

	/**
	 * 
	 * @param project
	 * @param state
	 * @param offset
	 * @param limit
	 * @return Relman releases with the given status for the given project
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanProject project,
			String status, int offset, int limit);

	/**
	 * 
	 * @param state
	 * @param offset
	 * @param limit
	 * @return Relman releases in given status
	 */
	public List<RelmanRelease> getRelmanReleases(String status, int offset,
			int limit);	
}
