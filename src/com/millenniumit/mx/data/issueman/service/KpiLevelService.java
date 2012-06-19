package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiLevel;

/**
 * 
 * @author Kalpag
 *
 */
public interface KpiLevelService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiLevel getKpiLevel(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public KpiLevel getKpiLevel(String name);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiLevel> getKpiLevels();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiLevel> getKpiLevels(int start, int limit);
	
	/**
	 * 
	 * @param level
	 * @return
	 */
	public Long saveKpiLevel(KpiLevel level);
	
	/**
	 * 
	 * @param level
	 */
	public void deleteKpiLevel(KpiLevel level);
}
