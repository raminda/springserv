package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi
 *
 */
@Entity(name = "KpiScoringScheme")
@Table(name = "kpi_scoring_schemes")
public class KpiScoringScheme extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "kpi_instance_id")
	private KpiKpiInstance instance;
	
	@Column(name = "range_sequence")
	private Integer rangeSequence;
	
	@Column(name = "upper_limit")
	private Double upperLimit;
	
	@Column(name = "lower_limit")
	private Double lowerLimit;
	
	@Column(name = "base_percentage")
	private Double basePercentage;

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
	 * @return the rangeSequence
	 */
	public Integer getRangeSequence() {
		return rangeSequence;
	}

	/**
	 * @param rangeSequence the rangeSequence to set
	 */
	public void setRangeSequence(Integer rangeSequence) {
		this.rangeSequence = rangeSequence;
	}

	/**
	 * @return the upperLimit
	 */
	public Double getUpperLimit() {
		return upperLimit;
	}

	/**
	 * @param upperLimit the upperLimit to set
	 */
	public void setUpperLimit(Double upperLimit) {
		this.upperLimit = upperLimit;
	}

	/**
	 * @return the lowerLimit
	 */
	public Double getLowerLimit() {
		return lowerLimit;
	}

	/**
	 * @param lowerLimit the lowerLimit to set
	 */
	public void setLowerLimit(Double lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	/**
	 * @return the basePercentage
	 */
	public Double getBasePercentage() {
		return basePercentage;
	}

	/**
	 * @param basePercentage the basePercentage to set
	 */
	public void setBasePercentage(Double basePercentage) {
		this.basePercentage = basePercentage;
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
}
