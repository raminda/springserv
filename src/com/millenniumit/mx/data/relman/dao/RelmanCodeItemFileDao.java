package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCodeItemFile;

public interface RelmanCodeItemFileDao {
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles();
	public RelmanCodeItemFile getRelmanCodeItemFile(Long id);	
}
