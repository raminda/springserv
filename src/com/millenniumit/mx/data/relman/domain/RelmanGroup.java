package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanGroup")
@Table(name = "relman_groups")
public class RelmanGroup extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "relman_id")
	private String relmanId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private RelmanProject project;

	/**
	 * 
	 */
	public RelmanGroup() {
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
	 * @return the project
	 */
	public RelmanProject getProject() {
		return project;
	}
}
