package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanCurrentVersionDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentVersion;
import com.millenniumit.mx.data.relman.service.RelmanCurrentVersionService;


@Service("relmanCurrentVersionService")
public class RelmanCurrentVersionServiceImpl implements RelmanCurrentVersionService {

	@Autowired
	@Qualifier("relmanCurrentVersionDao")
	private  RelmanCurrentVersionDao currentversiondao;
	

	public RelmanCurrentVersionDao getCurrentversiondao() {
		return currentversiondao;
	}


	public void setCurrentversiondao(RelmanCurrentVersionDao currentversiondao) {
		this.currentversiondao = currentversiondao;
	}


	@Transactional
	public List<RelmanCurrentVersion> getRelmanCurrentVersions() {
				return currentversiondao.getRelmanCurrentVersions();
	}

}