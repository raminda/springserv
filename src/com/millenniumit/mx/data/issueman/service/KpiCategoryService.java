package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiCategory;


/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiCategoryService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiCategory getKpiCategory(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public KpiCategory getKpiCategory(String name);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiCategory> getKpiCategories();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiCategory> getKpiCategories(int start, int limit);
	
	/**
	 * 
	 * @param category
	 */
	public Long saveKpiCategory(KpiCategory category);
	
	/**
	 * 
	 * @param category
	 */
	public void deleteKpiCategory(KpiCategory category);
	
}
