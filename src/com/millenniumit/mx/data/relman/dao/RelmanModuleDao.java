package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanModule;

public interface RelmanModuleDao {
	public List<RelmanModule> getRelmanModules();
	public RelmanModule getRelmanModule(String relmanId);
	public RelmanModule getRelmanModule(Long id);	
}
