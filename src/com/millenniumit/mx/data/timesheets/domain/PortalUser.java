/**
 * 
 */
package com.millenniumit.mx.data.timesheets.domain;

import javax.persistence.*;

/**
 * This class represents a user from previous Portal.
 * Each of these users are matched(by email) to a single 
 * user in Mx.
 * @author Vimukthi
 *
 */
@Entity(name = "PortalUser")
@Table(name = "users")
public class PortalUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "division_id")
	private PortalDivision division;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private PortalRole defaultRole;

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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the division
	 */
	public PortalDivision getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(PortalDivision division) {
		this.division = division;
	}

	/**
	 * @return the defaultRole
	 */
	public PortalRole getDefaultRole() {
		return defaultRole;
	}

	/**
	 * @param defaultRole the defaultRole to set
	 */
	public void setDefaultRole(PortalRole defaultRole) {
		this.defaultRole = defaultRole;
	}	
}
