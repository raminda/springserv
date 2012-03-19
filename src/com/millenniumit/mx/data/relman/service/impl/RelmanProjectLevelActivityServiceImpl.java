package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanProjectLevelActivityDao;
import com.millenniumit.mx.data.relman.domain.RelmanProjectLevelActivity;
import com.millenniumit.mx.data.relman.service.RelmanProjectLevelActivityService;


@Service("relmanProjectLevelActivityService")
public class RelmanProjectLevelActivityServiceImpl implements RelmanProjectLevelActivityService {

	@Autowired
	@Qualifier("relmanProjectLevelActivityDao")
	private RelmanProjectLevelActivityDao projectlevelactivitydao;
	
	public RelmanProjectLevelActivityDao getProjectlevelactivitydao() {
		return projectlevelactivitydao;
	}

	public void setProjectlevelactivitydao(
			RelmanProjectLevelActivityDao projectlevelactivitydao) {
		this.projectlevelactivitydao = projectlevelactivitydao;
	}

	@Transactional
	public List<RelmanProjectLevelActivity> getRelmanProjectLevelActivities() {
				return projectlevelactivitydao.getRelmanProjectLevelActivities();
	}

}