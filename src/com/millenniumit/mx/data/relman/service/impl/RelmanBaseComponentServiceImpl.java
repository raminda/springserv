package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanBaseComponentDao;
import com.millenniumit.mx.data.relman.domain.RelmanBaseComponent;
import com.millenniumit.mx.data.relman.service.RelmanBaseComponentService;


@Service("relmanBaseComponentService")
public class RelmanBaseComponentServiceImpl implements RelmanBaseComponentService {

	@Autowired
	@Qualifier("relmanBaseComponentDao")
	private  RelmanBaseComponentDao basecomponentdao;
	

	public RelmanBaseComponentDao getBasecomponentdao() {
		return basecomponentdao;
	}


	public void setBasecomponentdao(RelmanBaseComponentDao basecomponentdao) {
		this.basecomponentdao = basecomponentdao;
	}


	@Transactional
	public List<RelmanBaseComponent> getRelmanBaseComponents() {
				return basecomponentdao.getRelmanBaseComponents();
	}

}