package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanCodeItemFile")
@Table(name = "relman_code_item_files")
@Inheritance(strategy=InheritanceType.JOINED)
public class RelmanCodeItemFile extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "code_item_id")
	private RelmanCodeItem codeItem;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hash")
	private String hash;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "build_config")
	private String buildConfig;
	
	@Column(name = "path")
	private String path;

	/**
	 * 
	 */
	public RelmanCodeItemFile() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the codeItem
	 */
	public RelmanCodeItem getCodeItem() {
		return codeItem;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @return the buildConfig
	 */
	public String getBuildConfig() {
		return buildConfig;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}	
}
