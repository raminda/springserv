/**
 * 
 */
package com.millenniumit.mx.data.timesheets.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.timesheets.dao.PortalRoleDao;
import com.millenniumit.mx.data.timesheets.domain.PortalDivision;
import com.millenniumit.mx.data.timesheets.domain.PortalRole;
import com.millenniumit.mx.data.timesheets.service.PortalRoleService;

/**
 * @author Vimukthi
 *
 */
@Service("portalRoleService")
public class PortalRoleServiceImpl implements PortalRoleService {

	@Autowired
	@Qualifier("portalRoleDao")
	private PortalRoleDao roleDao;
	
	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalRoleService#getRole(java.lang.String, com.millenniumit.mx.data.timesheets.domain.PortalDivision)
	 */
	@Override
	@Transactional
	public PortalRole getRole(String title, PortalDivision division) {
		return getRoleDao().getRole(title, division);
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalRoleService#getRoles()
	 */
	@Override
	@Transactional
	public List<PortalRole> getRoles() {
		return getRoleDao().getRoles();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.timesheets.service.PortalRoleService#saveRole(com.millenniumit.mx.data.timesheets.domain.PortalRole)
	 */
	@Override
	@Transactional
	public void saveRole(PortalRole role) {
		getRoleDao().save(role);
	}

	/**
	 * @return the roleDao
	 */
	public PortalRoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(PortalRoleDao roleDao) {
		this.roleDao = roleDao;
	}

}
