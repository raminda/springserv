package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

import com.millenniumit.mx.data.issueman.domain.KpiCategory;
import com.millenniumit.mx.data.issueman.domain.KpiIndex;



/**
 * 
 * @author Kalpag
 *
 */
public interface KpiIndexDao extends Dao<KpiIndex> {

	/**
	 * @param name
	 * @return
	 */
	public KpiIndex get(String name);

	/**
	 * @param scope
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes(String scope);

	/**
	 * @param category
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes(KpiCategory category);

	/**
	 * @param category
	 * @param scope
	 * @return
	 */
	public List<KpiIndex> getKpiIndexes(KpiCategory category, String scope);
	
}
