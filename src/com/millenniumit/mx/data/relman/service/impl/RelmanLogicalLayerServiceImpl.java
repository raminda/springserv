package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanLogicalLayerDao;
import com.millenniumit.mx.data.relman.domain.RelmanLogicalLayer;
import com.millenniumit.mx.data.relman.service.RelmanLogicalLayerService;

@Service("relmanLogicalLayerService")
public class RelmanLogicalLayerServiceImpl implements RelmanLogicalLayerService {

	@Autowired
	@Qualifier("relmanLogicalLayerDao")
	private  RelmanLogicalLayerDao logicallayerdao;
	

	public RelmanLogicalLayerDao getLogicallayerdao() {
		return logicallayerdao;
	}


	public void setLogicallayerdao(RelmanLogicalLayerDao logicallayerdao) {
		this.logicallayerdao = logicallayerdao;
	}


	@Transactional
	public List<RelmanLogicalLayer> getRelmanLogicalLayers() {
				return logicallayerdao.getRelmanLogicalLayers();
	}

}