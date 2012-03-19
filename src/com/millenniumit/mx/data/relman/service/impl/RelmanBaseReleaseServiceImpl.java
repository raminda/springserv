package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanBaseReleaseDao;
import com.millenniumit.mx.data.relman.domain.RelmanBaseRelease;
import com.millenniumit.mx.data.relman.service.RelmanBaseReleaseService;


@Service("relmanBaseReleaseService")
public class RelmanBaseReleaseServiceImpl implements RelmanBaseReleaseService {

	@Autowired
	@Qualifier("relmanBaseReleaseDao")
	private RelmanBaseReleaseDao basereleasedao;
	

	public RelmanBaseReleaseDao getBasereleasedao() {
		return basereleasedao;
	}


	public void setBasereleasedao(RelmanBaseReleaseDao basereleasedao) {
		this.basereleasedao = basereleasedao;
	}


	@Transactional
	public List<RelmanBaseRelease> getRelmanBaseReleases() {
				return basereleasedao.getRelmanBaseReleases();
	}

}