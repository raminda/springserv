package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanGroupDao;
import com.millenniumit.mx.data.relman.domain.RelmanGroup;
import com.millenniumit.mx.data.relman.service.RelmanGroupService;


@Service("relmanGroupService")
public class RelmanGroupServiceImpl implements RelmanGroupService {

	@Autowired
	@Qualifier("relmanGroupDao")
	private  RelmanGroupDao groupdao;
	

	public RelmanGroupDao getGroupdao() {
		return groupdao;
	}

	public void setGroupdao(RelmanGroupDao groupdao) {
		this.groupdao = groupdao;
	}

	@Override
	@Transactional
	public List<RelmanGroup> getRelmanGroups() {
				return groupdao.getRelmanGroups();
	}

	@Override
	@Transactional
	public RelmanGroup getRelmanGroup(String relmanId) {
		return groupdao.getRelmanGroup(relmanId);
	}

	@Override
	@Transactional
	public RelmanGroup getRelmanGroup(Long id) {
		return groupdao.getRelmanGroup(id);
	}

}