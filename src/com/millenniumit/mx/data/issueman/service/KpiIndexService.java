package com.millenniumit.mx.data.issueman.service;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiCategory;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;



/**
 * 
 * @author Vimukthi
 *
 */
public interface KpiIndexService {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public KpiIndex getKpiIndex(Long id);
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public KpiIndex getKpiIndex(String name);
	
	/**
	 * 
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes();
	
	/**
	 * 
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes(KpiCategory category, String scope);
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes(int start, int limit);
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public Long saveKpiIndex(KpiIndex index);
	
	/**
	 * 
	 * @param index
	 */
	public void deleteKpiIndex(KpiIndex index);
	
}
