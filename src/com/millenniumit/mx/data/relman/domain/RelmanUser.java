package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanUser")
@Table(name = "relman_users")
public class RelmanUser extends AuditFields implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ruser_id")
	private String ruserId;
	
	@Column(name = "is_portal_user")
	private int isPortalUser;
	
//	@ManyToOne
//	@JoinColumn(name = "user")
//	private User user;
	
	@Column(name = "division_id")
	private Long divisionId;

	
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
	 * @return the ruserId
	 */
	public String getRuserId() {
		return ruserId;
	}

	/**
	 * @param ruserId the ruserId to set
	 */
	public void setRuserId(String ruserId) {
		this.ruserId = ruserId;
	}

	/**
	 * @return the isPortalUser
	 */
	public int getIsPortalUser() {
		return isPortalUser;
	}

	/**
	 * @param isPortalUser the isPortalUser to set
	 */
	public void setIsPortalUser(int isPortalUser) {
		this.isPortalUser = isPortalUser;
	}

	

	/**
	 * @return the divisionId
	 */
	public Long getDivisionId() {
		return divisionId;
	}

	/**
	 * @param divisionId the divisionId to set
	 */
	public void setDivisionId(Long divisionId) {
		this.divisionId = divisionId;
	}

	/**
	 * 
	 */
	public RelmanUser() {
		super();
	}	
}
