package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanRelease;
import com.millenniumit.mx.data.relman.util.RelmanReleaseCriteria;

/**
 * This is the Standard interface to query Relman release
 * data. 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanReleaseService {
	
	/**
	 * 
	 * @return All Relman releases
	 */
	public List<RelmanRelease> getRelmanReleases();		
	
	/**
	 * 
	 * @return All Relman releases count
	 */
	public long getRelmanReleasesCount();	
	
	/**
	 * 
	 * @param offset
	 * @param limit
	 * @return All Relman releases
	 */
	public List<RelmanRelease> getRelmanReleases(int offset, int limit);
	
	/**
	 * 
	 * @param criteria
	 * @return Relman releases for a given criteria
	 */
	public long getRelmanReleasesCount(RelmanReleaseCriteria criteria);
	
	/**
	 * 
	 * @param criteria
	 * @return Relman releases for a given criteria
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanReleaseCriteria criteria);
	
	/**
	 * 
	 * @param criteria
	 * @param offset
	 * @param limit
	 * @return Relman releases for a given criteria
	 */
	public List<RelmanRelease> getRelmanReleases(RelmanReleaseCriteria criteria, int offset, int limit);
	
	/**
	 * 
	 * @param relmanId
	 * @return The Relman release with the given relmanId
	 */
	public RelmanRelease getRelmanRelease(String relmanId);
	
	/**
	 * 
	 * @param id
	 * @return The Relman release with the given id
	 */
	public RelmanRelease getRelmanRelease(Long id);
}
