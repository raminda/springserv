package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanLogicalLayer")
@Table(name = "relman_logical_layers")
public class RelmanLogicalLayer extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 */
	public RelmanLogicalLayer() {
		super();
	}
}
