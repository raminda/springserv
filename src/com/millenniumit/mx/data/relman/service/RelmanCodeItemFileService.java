package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCodeItemFile;

public interface RelmanCodeItemFileService {
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles();
	public RelmanCodeItemFile getRelmanCodeItemFile(Long id);
	
}