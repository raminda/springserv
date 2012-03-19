package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCodeItem;

public interface RelmanCodeItemDao {
	public List<RelmanCodeItem> getRelmanCodeItems();
	public RelmanCodeItem getRelmanCodeItem(String relmanId);
	public RelmanCodeItem getRelmanCodeItem(Long id);
}
