package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "KpiKpiInstance")
@Table(name = "kpi_kpi_instances")
public class KpiKpiInstance extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "level_id")
	private KpiLevel level;
	
	@ManyToOne
	@JoinColumn(name = "kpi_definition_id")
	private KpiKpiDefinition kpiDefinition;
	
	@Column(name = "weight")
	private Integer weight;
	
	@Column(name = "go_no_go")
	private String goNoGo;

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
	 * @return the level
	 */
	public KpiLevel getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(KpiLevel level) {
		this.level = level;
	}

	/**
	 * @return the kpiDefinition
	 */
	public KpiKpiDefinition getKpiDefinition() {
		return kpiDefinition;
	}

	/**
	 * @param kpiDefinition the kpiDefinition to set
	 */
	public void setKpiDefinition(KpiKpiDefinition kpiDefinition) {
		this.kpiDefinition = kpiDefinition;
	}

	/**
	 * @return the weight
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * @return the goNoGo
	 */
	public String getGoNoGo() {
		return goNoGo;
	}

	/**
	 * @param goNoGo the goNoGo to set
	 */
	public void setGoNoGo(String goNoGo) {
		this.goNoGo = goNoGo;
	}
}
