package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCurrentVersion;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanCurrentVersionDao {
	List<RelmanCurrentVersion> getRelmanCurrentVersions();
	
}
