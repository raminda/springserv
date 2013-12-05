package com.millenniumit.mx.data.nethdsizing.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.service.ProjectsService;
import com.millenniumit.mx.data.nethdsizing.dao.ProjectDao;

/**
 * 
 * @author Raminda
 *
 */
@Service("ProjectsService")
public class  ProjectsServiceImpl  implements  ProjectsService {


	@Autowired
	@Qualifier("ProjectDao")
	private ProjectDao ProjectDao;

	/**
	 * @return the ProjectsDeo
	 */
	public ProjectDao getProjectsDao() {
		return ProjectDao;
	}

	/**
	 * @param ProjectsDeo the ProjectsDeo to set
	 */
	public void setProjectsDao(ProjectDao ProjectsDao) {
		this.ProjectDao = ProjectsDao;
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects(java.lang.Long)
	 */
	@Override
	@Transactional
	public Project getProjects(int id) {
		return getProjectsDao().get(id);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects(java.lang.String)
	 */
	@Override
	@Transactional
	public Project getProjects(String ProjectsName) {
		return getProjectsDao().get(ProjectsName);
	}


	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#getProjects()
	 */
	@Override
	@Transactional
	public List<Project> getProjects() {
		return getProjectsDao().getAll();
	}
	@Override
	@Transactional
	public List <Project> getCompany(Company Campanyname){	
		return getProjectsDao().getCompnay(Campanyname);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	@Transactional
	public List <Project> getProjects(int start, int limit) {
		return getProjectsDao().getAll(start, limit);
	}
	@Override
	@Transactional
	public List<String> getAllNames() {
		return getProjectsDao().getAllNames();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#saveProjects(com.millenniumit.mx.data.Project.domain.Projects)
	 */
	@Override
	@Transactional
	public int save(Project index) {
		return getProjectsDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ProjectsService#deleteProjects(com.millenniumit.mx.data.Project.domain.Projects)
	 */
	@Override
	@Transactional
	public void delete(Project index) {
		getProjectsDao().delete(index);		
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.ProjectsService#update(com.millenniumit.mx.data.itic.domain.Projects)
	 */
	@Override
	@Transactional
	public void update(Project index) {
		getProjectsDao().update(index);
		
	}

}
