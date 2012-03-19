package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Entity(name = "RelmanRelease")
@Table(name = "relman_releases")
public class RelmanRelease extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private RelmanProject project;

	@Column(name = "relman_id")
	private String relmanId;

	@Column(name = "name")
	private String name;

	@Column(name = "parent_release_relman_id")
	private String parentReleaseRelmanId;

	@ManyToOne
	@JoinColumn(name = "parent_release_id")
	@NotFound( action = NotFoundAction.IGNORE )
	private RelmanRelease parentRelease;

	@OneToMany(mappedBy = "parentRelease")
	private Set<RelmanRelease> childReleases = new HashSet<RelmanRelease>();

	@Column(name = "status")
	private String status;

	/**
	 * 
	 */
	public RelmanRelease() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the project
	 */
	public RelmanProject getProject() {
		return project;
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
	 * @return the parentReleaseRelmanId
	 */
	public String getParentReleaseRelmanId() {
		return parentReleaseRelmanId;
	}

	/**
	 * @return the parentRelease
	 */
	public RelmanRelease getParentRelease() {
		return parentRelease;
	}

	/**
	 * @return the childReleases
	 */
	public Set<RelmanRelease> getChildReleases() {
		return childReleases;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
}
