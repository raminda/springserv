package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCodeItem;

public interface RelmanCodeItemService {
	public List<RelmanCodeItem> getRelmanCodeItems();
	public RelmanCodeItem getRelmanCodeItem(String relmanId);
	public RelmanCodeItem getRelmanCodeItem(Long id);
}