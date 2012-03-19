package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "RelmanBaseComponent")
@Table(name = "relman_base_components")
public class RelmanBaseComponent extends AuditFields implements Serializable {

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

	@Column(name = "base_component_relman_id")
	private String baseComponentRelmanId;

	/**
	 * 
	 */
	public RelmanBaseComponent() {
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
	 * @return the baseComponentRelmanId
	 */
	public String getBaseComponentRelmanId() {
		return baseComponentRelmanId;
	}

}
