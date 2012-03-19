package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanProjectDao;
import com.millenniumit.mx.data.relman.domain.RelmanProject;
import com.millenniumit.mx.data.relman.service.RelmanProjectService;
import com.millenniumit.mx.data.relman.util.RelmanProjectCriteria;

/**
 * 
 * @author Vimukthi
 *
 */
@Service("relmanProjectService")
public class RelmanProjectServiceImpl implements RelmanProjectService {

	@Autowired
	@Qualifier("relmanProjectDao")
	private RelmanProjectDao projectdao;

	public RelmanProjectDao getProjectdao() {
		return projectdao;
	}

	public void setProjectdao(RelmanProjectDao projectdao) {
		this.projectdao = projectdao;
	}
	
	@Override
	@Transactional
	public RelmanProject getRelmanProject(Long id) {
		return projectdao.getRelmanProject(id);
	}
	
	@Override
	@Transactional
	public RelmanProject getRelmanProject(String relman_id) {
		return projectdao.getRelmanProject(relman_id);
	}

	@Override
	@Transactional
	public List<RelmanProject> getRelmanProjects() {
		return projectdao.getRelmanProjects();
	}	

	@Override
	@Transactional
	public List<RelmanProject> getRelmanProjects(int offset, int limit) {
		return projectdao.getRelmanProjects(offset, limit);
	}

	@Override
	@Transactional
	public long getRelmanProjectsCount() {
		return projectdao.getRelmanProjectsCount();
	}

	@Override
	@Transactional
	public List<RelmanProject> getRelmanProjects(RelmanProjectCriteria criteria) {
		if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId(), criteria.getType());

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId());

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getType());

		} else if (criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getRelmanLayerId(),
					criteria.getType());

		} else if (criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjects(criteria.getRelmanLayerId());

		} else if (criteria.getLogicalLayer() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer());

		} else if (criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getType());

		}

		return null;
	}

	@Override
	@Transactional
	public List<RelmanProject> getRelmanProjects(
			RelmanProjectCriteria criteria, int offset, int limit) {
		
		if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId(), criteria.getType(), offset, limit);

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId(), offset, limit);

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(),
					criteria.getType(), offset, limit);

		} else if (criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getRelmanLayerId(),
					criteria.getType(), offset, limit);

		} else if (criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjects(criteria.getRelmanLayerId(), offset, limit);

		} else if (criteria.getLogicalLayer() != null) {
			return projectdao.getRelmanProjects(criteria.getLogicalLayer(), offset, limit);

		} else if (criteria.getType() != null) {
			return projectdao.getRelmanProjects(criteria.getType(), offset, limit);

		}

		return null;
	}

	@Override
	@Transactional
	public long getRelmanProjectsCount(RelmanProjectCriteria criteria) {
		if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId(), criteria.getType());

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getLogicalLayer(),
					criteria.getRelmanLayerId());

		} else if (criteria.getLogicalLayer() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getLogicalLayer(),
					criteria.getType());

		} else if (criteria.getRelmanLayerId() != null
				&& criteria.getType() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getRelmanLayerId(),
					criteria.getType());

		} else if (criteria.getRelmanLayerId() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getRelmanLayerId());

		} else if (criteria.getLogicalLayer() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getLogicalLayer());

		} else if (criteria.getType() != null) {
			return projectdao.getRelmanProjectsCount(criteria.getType());

		}
		
		return 0;
	}

	
}
