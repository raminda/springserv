/**
 * 
 */
package com.millenniumit.mx.data.kpi.service;

import java.util.List;

import com.millenniumit.mx.data.kpi.domain.KpiProject;

/**
 * 
 * @author kalpag
 *
 */
public interface KpiProjectService {
	
	/**
	 * 
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
