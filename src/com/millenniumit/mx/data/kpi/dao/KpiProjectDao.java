/**
 * 
 */
package com.millenniumit.mx.data.kpi.dao;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;

/**
 * 
 * @author Kalpag
 *
 */
public interface KpiProjectDao {
	
	/**
	 * @param id
	 * @return
	 */
	public KpiProject getKpiProject(Long id);

	/**
	 * 
	 * @return
	 */
	public List<KpiProject> getKpiProjects();
}
