/**
 * 
 */
package com.millenniumit.mx.data.kpi.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kalpag
 * 
 */

@Entity(name = "MetricFaultBugProject")
@Table(name = "metric_fault_bug_project")
public class MetricFaultBugProject extends ProjectMetricEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long Id;

	/**
	 * @return the id
	 */
	public long getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		Id = id;
	}
}
