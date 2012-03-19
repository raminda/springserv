package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface RelmanRelationService {
	/**
	 * 
	 * @return
	 */
	public List<RelmanRelation> getRelmanRelations();
	
	/**
	 * 
	 * @param release
	 * @return
	 */
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @return
	 */
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @param module
	 * @return
	 */
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @param module
	 * @param codeItemType
	 * @return
	 */
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module, String codeItemType);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @param module
	 * @param codeItem
	 * @return
	 */
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles(RelmanRelease release,
			RelmanGroup group, RelmanModule module, RelmanCodeItem codeItem);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @param module
	 * @return
	 */
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module);
	
	/**
	 * 
	 * @param release
	 * @param group
	 * @return
	 */
	public List<RelmanModule> getRelmanModules(RelmanRelease release,
			RelmanGroup group);
	
	/**
	 * 
	 * @param release
	 * @return
	 */
	public List<RelmanGroup> getRelmanGroups(RelmanRelease release);

	/**
	 * 
	 * @param release
	 * @param group
	 * @param module
	 * @param codeItemType
	 * @return
	 */
	public List<RelmanCodeItem> getRelmanCodeItems(RelmanRelease release,
			RelmanGroup group, RelmanModule module, String codeItemType);
}
