package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "KpiThreshold")
@Table(name = "kpi_thresholds")
public class KpiThreshold extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "kpi_instance_id")
	private KpiKpiInstance instance;
	
	@Column(name = "green_threshold")
	private Integer greenThreshold;
	
	@Column(name = "amber_threshold")
	private Integer amberThreshold;

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
	 * @return the instance
	 */
	public KpiKpiInstance getInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(KpiKpiInstance instance) {
		this.instance = instance;
	}

	/**
	 * @return the greenThreshold
	 */
	public Integer getGreenThreshold() {
		return greenThreshold;
	}

	/**
	 * @param greenThreshold the greenThreshold to set
	 */
	public void setGreenThreshold(Integer greenThreshold) {
		this.greenThreshold = greenThreshold;
	}

	/**
	 * @return the amberThreshold
	 */
	public Integer getAmberThreshold() {
		return amberThreshold;
	}

	/**
	 * @param amberThreshold the amberThreshold to set
	 */
	public void setAmberThreshold(Integer amberThreshold) {
		this.amberThreshold = amberThreshold;
	}
}
