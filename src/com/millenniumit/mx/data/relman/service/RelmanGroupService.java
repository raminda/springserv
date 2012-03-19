package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanGroup;

public interface RelmanGroupService {
	public List<RelmanGroup> getRelmanGroups();
	public RelmanGroup getRelmanGroup(String relmanId);
	public RelmanGroup getRelmanGroup(Long id);
}