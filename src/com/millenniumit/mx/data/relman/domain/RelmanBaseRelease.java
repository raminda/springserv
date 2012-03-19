package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanBaseRelease")
@Table(name = "relman_base_releases")
public class RelmanBaseRelease extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "release_id")
	private RelmanRelease release;
	
	@Column(name = "base_release_relman_id")
	private String baseReleaseRelmanId;

	/**
	 * 
	 */
	public RelmanBaseRelease() {
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
	 * @return the baseReleaseRelmanId
	 */
	public String getBaseReleaseRelmanId() {
		return baseReleaseRelmanId;
	}
}
