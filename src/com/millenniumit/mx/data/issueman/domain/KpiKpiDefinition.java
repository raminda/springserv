package com.millenniumit.mx.data.issueman.domain;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 
 * @author Kalpag
 *
 */
@Entity(name = "KpiKpiDefinition")
@Table(name = "kpi_kpi_definitions")
public class KpiKpiDefinition extends AuditFields2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "index_id")
	private KpiIndex index;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "sdlc_phase")
	private String sdlcPhase;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "source_table")
	private String sourceTable;
	
	@Column(name = "source_column")
	private String sourceColumn;

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

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the sdlcPhase
	 */
	public String getSdlcPhase() {
		return sdlcPhase;
	}

	/**
	 * @param sdlcPhase the sdlcPhase to set
	 */
	public void setSdlcPhase(String sdlcPhase) {
		this.sdlcPhase = sdlcPhase;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the sourceTable
	 */
	public String getSourceTable() {
		return sourceTable;
	}

	/**
	 * @param sourceTable the sourceTable to set
	 */
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	/**
	 * @return the sourceColumn
	 */
	public String getSourceColumn() {
		return sourceColumn;
	}

	/**
	 * @param sourceColumn the sourceColumn to set
	 */
	public void setSourceColumn(String sourceColumn) {
		this.sourceColumn = sourceColumn;
	}	
}
