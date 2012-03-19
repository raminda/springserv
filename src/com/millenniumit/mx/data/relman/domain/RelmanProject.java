package com.millenniumit.mx.data.relman.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
@Entity(name = "RelmanProject")
@Table(name = "relman_projects")
public class RelmanProject extends AuditFields implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "relman_id")
	private String relmanId;
	
	@Column(name = "relman_layer_id")
	private int relmanLayerId;
	
	@ManyToOne
	@JoinColumn(name = "logical_layer_id")
	private RelmanLogicalLayer logicalLayer;
	
	@Column(name = "load_stats")
	private int loadStats;
	
	@Column(name = "type")
	private String type;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the relmanId
	 */
	public String getRelmanId() {
		return relmanId;
	}

	/**
	 * @return the relmanLayerId
	 */
	public int getRelmanLayerId() {
		return relmanLayerId;
	}

	/**
	 * @return the loadStats
	 */
	public int getLoadStats() {
		return loadStats;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the logicalLayer
	 */
	public RelmanLogicalLayer getLogicalLayer() {
		return logicalLayer;
	}

	/**
	 * 
	 */
	public RelmanProject() {
		super();
	}
}
