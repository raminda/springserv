package com.millenniumit.mx.data.relman.util;

import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * This class provides a standard object to supply criteria to obtain
 * RelmanCodeItemFile objects from RelmanRelations
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class RelmanRelationCriteria {

	private RelmanRelease release = null;
	private RelmanGroup group = null;
	private RelmanModule module = null;
	private RelmanCodeItem codeItem = null;
	private String codeItemType = null;
	private RelmanCodeItemFile codeItemFile = null;

	/**
	 * @return the release
	 */
	public RelmanRelease getRelease() {
		return release;
	}

	/**
	 * @param release
	 *            the release to set
	 */
	public void setRelease(RelmanRelease release) {
		this.release = release;
	}

	/**
	 * @return the group
	 */
	public RelmanGroup getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(RelmanGroup group) {
		this.group = group;
	}

	/**
	 * @return the module
	 */
	public RelmanModule getModule() {
		return module;
	}

	/**
	 * @param module
	 *            the module to set
	 */
	public void setModule(RelmanModule module) {
		this.module = module;
	}

	/**
	 * @return the codeItem
	 */
	public RelmanCodeItem getCodeItem() {
		return codeItem;
	}

	/**
	 * @param codeItem
	 *            the codeItem to set
	 */
	public void setCodeItem(RelmanCodeItem codeItem) {
		this.codeItem = codeItem;
	}

	/**
	 * @return the codeItemType
	 */
	public String getCodeItemType() {
		return codeItemType;
	}

	/**
	 * @param codeItemType
	 *            the codeItemType to set
	 */
	public void setCodeItemType(String codeItemType) {
		this.codeItemType = codeItemType;
	}

	/**
	 * @return the codeItemFile
	 */
	public RelmanCodeItemFile getCodeItemFile() {
		return codeItemFile;
	}

	/**
	 * @param codeItemFile
	 *            the codeItemFile to set
	 */
	public void setCodeItemFile(RelmanCodeItemFile codeItemFile) {
		this.codeItemFile = codeItemFile;
	}

	/**
	 * @param release
	 */
	public RelmanRelationCriteria(RelmanRelease release) {
		this.release = release;
	}

	/**
	 * @param release
	 * @param group
	 */
	public RelmanRelationCriteria(RelmanRelease release, RelmanGroup group) {
		this.release = release;
		this.group = group;
	}

	/**
	 * @param release
	 * @param group
	 * @param module
	 */
	public RelmanRelationCriteria(RelmanRelease release, RelmanGroup group,
			RelmanModule module) {
		this.release = release;
		this.group = group;
		this.module = module;
	}

	/**
	 * @param release
	 * @param group
	 * @param module
	 * @param codeItem
	 */
	public RelmanRelationCriteria(RelmanRelease release, RelmanGroup group,
			RelmanModule module, RelmanCodeItem codeItem) {
		this.release = release;
		this.group = group;
		this.module = module;
		this.codeItem = codeItem;
	}

	/**
	 * @param release
	 * @param group
	 * @param module
	 * @param codeItemType
	 */
	public RelmanRelationCriteria(RelmanRelease release, RelmanGroup group,
			RelmanModule module, String codeItemType) {
		this.release = release;
		this.group = group;
		this.module = module;
		this.codeItemType = codeItemType;
	}

	/**
	 * @param codeItemFile
	 */
	public RelmanRelationCriteria(RelmanCodeItemFile codeItemFile) {
		this.codeItemFile = codeItemFile;
	}

}
