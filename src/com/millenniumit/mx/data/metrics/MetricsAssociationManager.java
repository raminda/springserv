package com.millenniumit.mx.data.metrics;

import java.util.List;

/**
 * Implement this class to change the lowest association level
 * Eg:- RelmanModule
 * @author Vimukthi <vimukthi@millenniumit.com>
 *
 */
public interface MetricsAssociationManager {
	
	/**
	 * 
	 * @param criteria
	 * @return
	 */
	public List<?> getLowestAssociationLevelObjects(Object criteria);
}
