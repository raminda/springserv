package com.millenniumit.mx.data.nethdsizing.domain;



import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.*;



/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 **/
@Entity(name="project")
@Table(name="project")
public class Project extends AuditFields implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name="ColumnHandl",table="ColumnHandler",pkColumnName="IdColumn",pkColumnValue="ProjectValue",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="ColumnHandl")
	private Integer ID;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "Company")
	private Company Company;
	
	private Long TotalAmount;
	@Column(nullable=false,unique = true)
	private String ProjectName;						
		
	private Blob SysReq;
	

	/*  Get Set Methods For Column*/
	/**
	 * @return the ID
	 */
	public Integer getId() {
		return ID;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	/**
	 * @return the Company name
	 */
	public Company getCompany() {
		return Company;
	}

	/**
	 * @param Company  the Company to set
	 */
	public void setCompany(Company Company) {
		this.Company = Company;
	}
	/**
	 * @return the sysReq
	 */
	public Blob getSysReq() {
		return SysReq;
	}

	/**
	 * @param sysReq the sysReq to set
	 */
	public void setSysReq(Blob sysReq) {
		SysReq = sysReq;
	}
	
	/**
	 * @return the ProjectName
	 */
	public String getProjectName() {
		return ProjectName;
	}

	/**
	 * @param ProjectName  the ProjectName to set
	 */
	public void setProjectName(String ProjectName) {
		this.ProjectName = ProjectName;
	}
	/**
	 * @return the Total amount
	 */
	public Long getAmount() {
		return TotalAmount;
	}

	/**
	 * @param Total amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.TotalAmount = amount;
	}

}
