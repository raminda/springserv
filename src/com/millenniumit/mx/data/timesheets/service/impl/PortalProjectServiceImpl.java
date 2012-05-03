/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.PortalProjectDao;
import com.millenniumit.mx.data.timesheets.domain.PortalProject;
import com.millenniumit.mx.data.timesheets.service.PortalProjectService;

/**
 * @author Vimukthi
 *
 */
@Service("portalProjectService")
public class PortalProjectServiceImpl implements PortalProjectService {
	
	@Autowired
	@Qualifier("portalProjectDao")
	private PortalProjectDao projectDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalProjectService#getProject(java.lang.String)
	 */
	@Override
	@Transactional
	public PortalProject getProject(String title) {
		return getProjectDao().getProject(title);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalProjectService#getProjects()
	 */
	@Override
	@Transactional
	public List<PortalProject> getProjects() {
		return getProjectDao().getProjects();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalProjectService#saveProject(com.millenniumit.mx.data.timesheets.domain.PortalProject)
	 */
	@Override
	@Transactional
	public void saveProject(PortalProject project) {
		getProjectDao().save(project);
	}

	/**
	 * @return the projectDao
	 */
	public PortalProjectDao getProjectDao() {
		return projectDao;
	}

	/**
	 * @param projectDao the projectDao to set
	 */
	public void setProjectDao(PortalProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
