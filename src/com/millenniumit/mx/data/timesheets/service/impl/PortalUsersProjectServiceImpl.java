/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.PortalUsersProjectDao;
import com.millenniumit.mx.data.timesheets.domain.*;
import com.millenniumit.mx.data.timesheets.service.PortalUserProjectService;

/**
 * @author Vimukthi
 *
 */
@Service("portalUsersProjectService")
public class PortalUsersProjectServiceImpl implements PortalUserProjectService {
	
	@Autowired
	@Qualifier("portalUsersProjectDao")
	private PortalUsersProjectDao usersProjectDao;

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserProjectService#getUsersProject(com.millenniumit.mx.data.timesheets.domain.PortalUser, com.millenniumit.mx.data.timesheets.domain.PortalProject, com.millenniumit.mx.data.timesheets.domain.PortalRole)
	 */
	@Override
	@Transactional
	public PortalUsersProject getUsersProject(PortalUser user,
			PortalProject project, PortalRole role) {
		return getUsersProjectDao().getUsersProject(user, project, role);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserProjectService#getUsersProjects()
	 */
	@Override
	@Transactional
	public List<PortalUsersProject> getUsersProjects() {
		return getUsersProjectDao().getUsersProjects();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalUserProjectService#saveUsersProject(com.millenniumit.mx.data.timesheets.domain.PortalUsersProject)
	 */
	@Override
	@Transactional
	public void saveUsersProject(PortalUsersProject usersProject) {
		getUsersProjectDao().save(usersProject);
	}

	/**
	 * @return the usersProjectDao
	 */
	public PortalUsersProjectDao getUsersProjectDao() {
		return usersProjectDao;
	}

	/**
	 * @param usersProjectDao the usersProjectDao to set
	 */
	public void setUsersProjectDao(PortalUsersProjectDao usersProjectDao) {
		this.usersProjectDao = usersProjectDao;
	}

}
