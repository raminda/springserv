package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Vimukthi
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
	private KpiKpiDefinition definition;
	
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

	/**
	 * @return the definition
	 */
	public KpiKpiDefinition getDefinition() {
		return definition;
	}

	/**
	 * @param definition the definition to set
	 */
	public void setDefinition(KpiKpiDefinition definition) {
		this.definition = definition;
	}
}
