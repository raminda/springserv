/**
 * 
 */
package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author kalpag
 *
 */
@Entity(name = "IssuemanSeverity")
@Table(name = "severity")
public class IssuemanSeverity extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@Column(name = "native_id")
	private Long nativeId;
	
	@Column(name = "level")
	private Long level;
	
	@Column(name = "description")
	private String description;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nativeId
	 */
	public Long getNativeId() {
		return nativeId;
	}

	/**
	 * @param nativeId the nativeId to set
	 */
	public void setNativeId(Long nativeId) {
		this.nativeId = nativeId;
	}

	/**
	 * @return the level
	 */
	public Long getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(Long level) {
		this.level = level;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
