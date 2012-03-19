package com.millenniumit.mx.data.relman.util;

/**
 * 
 * This class provides a standard object to 
 * supply criteria to obtain RelmanCodeItemFile objects
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class RelmanRelationRelmanIdCriteria {
	private String releaseRelmanId;
	private String groupRelmanId;
	private String moduleRelmanId;
	private String codeItemRelmanId;	
	
	public RelmanRelationRelmanIdCriteria(String releaseRelmanId) {
		this.releaseRelmanId = releaseRelmanId;
	}
	
	public String getReleaseRelmanId() {
		return releaseRelmanId;
	}
	
	public void setReleaseRelmanId(String releaseRelmanId) {
		this.releaseRelmanId = releaseRelmanId;
	}
	
	public String getGroupRelmanId() {
		return groupRelmanId;
	}
	
	public void setGroupRelmanId(String groupRelmanId) {
		this.groupRelmanId = groupRelmanId;
	}
	
	public String getModuleRelmanId() {
		return moduleRelmanId;
	}
	
	public void setModuleRelmanId(String moduleRelmanId) {
		this.moduleRelmanId = moduleRelmanId;
	}
	
	public String getCodeItemRelmanId() {
		return codeItemRelmanId;
	}
	
	public void setCodeItemRelmanId(String codeItemRelmanId) {
		this.codeItemRelmanId = codeItemRelmanId;
	}

	@Override
	public String toString() {
		return "{\"releaseRelmanId\" : \"" + releaseRelmanId
				+ "\", \"groupRelmanId\" : \"" + groupRelmanId + "\", \"moduleRelmanId\" : \""
				+ moduleRelmanId + "\", \"codeItemRelmanId\" : " + codeItemRelmanId
				+ "\"}";
	}
}
