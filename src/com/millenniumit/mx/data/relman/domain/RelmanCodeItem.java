package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanCodeItem")
@Table(name = "relman_code_items")
public class RelmanCodeItem extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "relman_id")
	private String relmanId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private RelmanModule module;

	/**
	 * 
	 */
	public RelmanCodeItem() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the relmanId
	 */
	public String getRelmanId() {
		return relmanId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the module
	 */
	public RelmanModule getModule() {
		return module;
	}	
}
