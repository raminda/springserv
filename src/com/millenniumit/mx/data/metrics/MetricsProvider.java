package com.millenniumit.mx.data.metrics;

import java.util.List;

/**
 * 
 * Implement this class to create new ways of calculating stats
 * Eg:- Through a web service
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public interface MetricsProvider {
	
	/**
	 * Get Metrics for given criteria
	 * @param criteria
	 * @return
	 */
	public List<?> getData(Object criteria);
	
	/**
	 * Set a list of preferred statistics to get
	 * @param prefStats
	 */
	public void setPrefStats(List<String> prefStats);
}
