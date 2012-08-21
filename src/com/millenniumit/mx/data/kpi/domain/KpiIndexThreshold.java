package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi
 *
 */
@Entity(name = "KpiIndexThreshold")
@Table(name = "kpi_index_thresholds")
public class KpiIndexThreshold extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "index_id")
	private KpiIndex index;
	
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

	/**
	 * @return the index
	 */
	public KpiIndex getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(KpiIndex index) {
		this.index = index;
	}
}
