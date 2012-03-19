package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanModuleDao;
import com.millenniumit.mx.data.relman.domain.RelmanModule;
import com.millenniumit.mx.data.relman.service.RelmanModuleService;

@Service("relmanModuleService")
public class RelmanModuleServiceImpl implements RelmanModuleService {

	@Autowired
	@Qualifier("relmanModuleDao")
	private  RelmanModuleDao moduledao;
	
	public RelmanModuleDao getModuledao() {
		return moduledao;
	}

	public void setModuledao(RelmanModuleDao moduledao) {
		this.moduledao = moduledao;
	}

	@Override
	@Transactional
	public List<RelmanModule> getRelmanModules() {
				return moduledao.getRelmanModules();
	}

	@Override
	@Transactional
	public RelmanModule getRelmanModule(String relmanId) {
		return moduledao.getRelmanModule(relmanId);
	}

	@Override
	@Transactional
	public RelmanModule getRelmanModule(Long id) {
		return moduledao.getRelmanModule(id);
	}

}