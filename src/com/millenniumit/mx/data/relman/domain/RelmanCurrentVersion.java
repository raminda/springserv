package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanCurrentVersion")
@Table(name = "relman_current_versions")
public class RelmanCurrentVersion extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "release_id")
	private RelmanRelease release;
	
	@ManyToOne
	@JoinColumn(name = "code_item_id")
	private RelmanCodeItem codeItem;
	
	@Column(name = "current_version")
	private int currentVersion;

	/**
	 * 
	 */
	public RelmanCurrentVersion() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the release
	 */
	public RelmanRelease getRelease() {
		return release;
	}

	/**
	 * @return the codeItem
	 */
	public RelmanCodeItem getCodeItem() {
		return codeItem;
	}

	/**
	 * @return the currentVersion
	 */
	public int getCurrentVersion() {
		return currentVersion;
	}
}
