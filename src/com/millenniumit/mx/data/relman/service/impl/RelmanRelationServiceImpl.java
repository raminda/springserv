package com.millenniumit.mx.data.relman.service.impl;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.metrics.MetricsAssociationManager;
import com.millenniumit.mx.data.relman.dao.RelmanRelationDao;
import com.millenniumit.mx.data.relman.domain.*;
import com.millenniumit.mx.data.relman.service.*;
import com.millenniumit.mx.data.relman.util.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Service("relmanRelationService")
public class RelmanRelationServiceImpl implements RelmanRelationService,
		MetricsAssociationManager {

	@Autowired
	@Qualifier("relmanRelationDao")
	private RelmanRelationDao relationdao;
	
	/**
	 * This function implements the getLowestAssociationLevelObjects(Object criteria)
	 * method from MetricsAssociationManager for Relman source hierachy
	 */
	@Override
	@Transactional
	public List<?> getLowestAssociationLevelObjects(Object criteria) {
		RelmanRelease release = null;
		RelmanGroup group = null;
		RelmanModule module = null;
		RelmanCodeItem codeItem = null;
		RelmanRelationCriteria relmanCriteria = (RelmanRelationCriteria) criteria;
		
		/**
		 * If a file id is given then we only need to return that file in a list
		 */
		if (relmanCriteria.getCodeItemFile() != null) {
			List<RelmanCodeItemFile> fList = new ArrayList<RelmanCodeItemFile>();
			fList.add(relmanCriteria.getCodeItemFile());
			return fList;
		}
		
		/**
		 * If the release id given is null we'll return null
		 * The stat has no meaning without the release
		 */
		if (relmanCriteria.getRelease() != null) {
			release = relmanCriteria.getRelease();
		} else {
			return null;
		}
		
		/**
		 * If the group id is null we'll return the stat for the whole release
		 * This logic continues for all upper layers
		 */
		if (relmanCriteria.getGroup() != null){
			group = relmanCriteria.getGroup();
		} else {
			return getRelmanCodeItemFiles(release);
		}
		
		if (relmanCriteria.getModule() != null){
			module = relmanCriteria.getModule();
		} else {
			return getRelmanCodeItemFiles(release, group);
		}
		
		/**
		 * CodeItemId and CodeItemType are properties of the same level object
		 * Therefore we'll use them as mutually exclusive
		 */
		if (relmanCriteria.getCodeItem() == null && relmanCriteria.getCodeItemType() == null){
			return getRelmanCodeItemFiles(release, group, module);
		} else if (relmanCriteria.getCodeItemType() != null) {
			return getRelmanCodeItemFiles(release, group, module, relmanCriteria.getCodeItemType());
		} else if (relmanCriteria.getCodeItem() != null){
			codeItem = relmanCriteria.getCodeItem();
		}		
		
		return getRelmanCodeItemFiles(release, group, module, codeItem);
	}
	
	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module, RelmanCodeItem codeItem) {
		return relationdao.getRelmanCodeItemFiles(release, group, module, codeItem);
	}

	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module, String codeItemType) {
		return relationdao.getRelmanCodeItemFiles(release, group, module, codeItemType);
	}

	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group) {
		return relationdao.getRelmanCodeItemFiles(release, group);
	}

	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module) {
		return relationdao.getRelmanCodeItemFiles(release, group, module);
	}

	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release) {
		return relationdao.getRelmanCodeItemFiles(release);
	}

	@Override
	@Transactional
	public List<RelmanRelation> getRelmanRelations() {
		return relationdao.getRelmanRelations();
	}
	
	@Override
	@Transactional
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module, String codeItemType) {
		return relationdao.getRelmanCodeItems(release, group, module, codeItemType);
	}
	
	@Override
	@Transactional
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module) {
		return relationdao.getRelmanCodeItems(release, group, module);
	}

	@Override
	@Transactional
	public List<RelmanModule> getRelmanModules(RelmanRelease release,
			RelmanGroup group) {
		return relationdao.getRelmanModules(release, group);
	}

	@Override
	@Transactional
	public List<RelmanGroup> getRelmanGroups(RelmanRelease release) {
		return relationdao.getRelmanGroups(release);
	}

	public RelmanRelationDao getRelationdao() {
		return relationdao;
	}

	public void setRelationdao(RelmanRelationDao relationdao) {
		this.relationdao = relationdao;
	}
}


