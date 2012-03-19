package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanGroup;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanGroupDao {
	public List<RelmanGroup> getRelmanGroups();
	public RelmanGroup getRelmanGroup(String relmanId);
	public RelmanGroup getRelmanGroup(Long id);
}
