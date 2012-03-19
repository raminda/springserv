package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanModule;

public interface RelmanModuleService {
	public List<RelmanModule> getRelmanModules();
	public RelmanModule getRelmanModule(String relmanId);
	public RelmanModule getRelmanModule(Long id);
}