package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanItemTypeDao;
import com.millenniumit.mx.data.relman.domain.RelmanItemType;
import com.millenniumit.mx.data.relman.service.RelmanItemTypeService;

@Service("relmanItemTypeService")
public class RelmanItemTypeServiceImpl implements RelmanItemTypeService {

	@Autowired
	@Qualifier("relmanItemTypeDao")
	private  RelmanItemTypeDao itemtypedao;
	

	public RelmanItemTypeDao getItemtypedao() {
		return itemtypedao;
	}


	public void setItemtypedao(RelmanItemTypeDao itemtypedao) {
		this.itemtypedao = itemtypedao;
	}


	@Transactional
	public List<RelmanItemType> getRelmanItemTypes() {
				return itemtypedao.getRelmanItemTypes();
	}

}