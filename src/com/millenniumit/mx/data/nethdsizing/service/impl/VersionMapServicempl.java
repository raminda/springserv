package com.millenniumit.mx.data.nethdsizing.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;
import com.millenniumit.mx.data.nethdsizing.service.VersionMapService;
import com.millenniumit.mx.data.nethdsizing.dao.VersionMapDao;

/**
 * 
 * @author Raminda
 *
 */
@Service("VersionMapService")
public class  VersionMapServicempl  implements  VersionMapService {

	@Autowired
	@Qualifier("VersionMapDao")
	private VersionMapDao Version_MapDao;

	/**
	 * @return the Version_MapsDeo
	 */
	public VersionMapDao getVersion_MapsDao() {
		return Version_MapDao;
	}

	/**
	 * @param Version_MapsDeo the Version_MapsDeo to set
	 */
	public void setVersion_MapsDao(VersionMapDao VersionMapDao) {
		this.Version_MapDao = VersionMapDao;
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#getVersion_Maps(java.lang.Long)
	 */
	@Override
	@Transactional
	public VersionMap get(int id) {
		return getVersion_MapsDao().get(id);
	}


	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#getVersion_Maps()
	 */
	@Override
	@Transactional
	public List<VersionMap> getVersion_Maps() {
		return getVersion_MapsDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	@Transactional
	public List <VersionMap> getVersion_Maps(int start, int limit) {
		return getVersion_MapsDao().getAll(start, limit);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#saveVersion_Maps(com.millenniumit.mx.data.VersionMap.domain.Version_Maps)
	 */
	@Override
	@Transactional
	public int save(VersionMap index) {
		return getVersion_MapsDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.Version_MapsService#deleteVersion_Maps(com.millenniumit.mx.data.VersionMap.domain.Version_Maps)
	 */
	@Override
	@Transactional
	public void delete(VersionMap index) {
		getVersion_MapsDao().delete(index);		
	}
	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.Version_MapsService#update(com.millenniumit.mx.data.itic.domain.Version_Maps)
	 */
	@Override
	@Transactional
	public void update(VersionMap index) {
		getVersion_MapsDao().update(index);
		
	}
	@Override
	@Transactional
	public List<String> getSite(Project project, String OptionID,String Version) {
		return getVersion_MapsDao().getSite(project, OptionID,Version);
	}
	
	@Override
	@Transactional
	public List<String> getVersion_Maps(Project project, String OptionID) {
		return getVersion_MapsDao().getAll(project, OptionID);
	}

	@Override
	@Transactional
	public List<String> getProjects(Project project) {
		return getVersion_MapsDao().getAllPackagetype(project);
	}

	@Override
	@Transactional
	public List<VersionMap> getAll(Project project, String OptionID,String Version) {
		return getVersion_MapsDao().get(project, OptionID, Version);
	}
	
	@Override
	@Transactional
	public VersionMap getAll(Project project, String OptionID,String Version,String SiteID) {
		return getVersion_MapsDao().get(project,OptionID,Version,SiteID);
	}
	@Override
	@Transactional
	public List<VersionMap> getAll(Project project) {
		return getVersion_MapsDao().getAll(project);
	}
}
