package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;

import javax.persistence.*;


/**
 * This class models the relationships between different levels of code
 * in Relman
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "RelmanRelation")
@Table(name = "relman_relations")
public class RelmanRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id 
    private RelationId relationKey = new RelationId();
	
	@Column(name = "code_path")
	private Long codePath;
	
	@Column(name = "current_version")
	private Long currentVersion;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "code_item_id")
	private RelmanCodeItem codeItem;
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private RelmanModule module;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private RelmanGroup group;

	/**
	 * 
	 */
	public RelmanRelation() {
		super();
	}

	/**
	 * @return the relationKey
	 */
	public RelationId getRelationKey() {
		return relationKey;
	}

	/**
	 * @return the codePath
	 */
	public Long getCodePath() {
		return codePath;
	}

	/**
	 * @return the currentVersion
	 */
	public Long getCurrentVersion() {
		return currentVersion;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the codeItem
	 */
	public RelmanCodeItem getCodeItem() {
		return codeItem;
	}

	/**
	 * @return the module
	 */
	public RelmanModule getModule() {
		return module;
	}

	/**
	 * @return the group
	 */
	public RelmanGroup getGroup() {
		return group;
	}
}

@Embeddable 
class RelationId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "release_id")
    private RelmanRelease release;

    @ManyToOne
    @JoinColumn(name = "file_id")
    private RelmanCodeItemFile file;

	/**
	 * 
	 */
	public RelationId() {
		super();
	}

	/**
	 * @return the release
	 */
	public RelmanRelease getRelease() {
		return release;
	}

	/**
	 * @return the file
	 */
	public RelmanCodeItemFile getFile() {
		return file;
	}	
}
