package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanModule")
@Table(name = "relman_modules")
public class RelmanModule extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "relman_id")
	private String relmanId;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "group_id")
	private RelmanGroup group;

	/**
	 * 
	 */
	public RelmanModule() {
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
	 * @return the group
	 */
	public RelmanGroup getGroup() {
		return group;
	}
}
