package com.millenniumit.mx.data.metrics;

import java.util.*;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;


/**
 * Implements MetricsProvider for Hibernate for it's standard
 * aggregation functions
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class MetricsProviderImpl implements MetricsProvider {

	/**
	 * 
	 */
	private SessionFactory sessionfactory;

	/**
	 * Metrics configuration object for this provider
	 */
	private MetricsConfiguration metricsConfiguration;

	/**
	 * Metrics metricsAssociationManager object for this provider
	 */
	private MetricsAssociationManager metricsAssociationManager;
	
	/**
	 * Logger for this class
	 */
	private Logger logger = Logger.getLogger(MetricsProviderImpl.class);
	
	/**
	 * Preferred list of stats to get data for
	 */
	private List<String> prefStats;

	
	/**
	 * @return the metricsConfiguration
	 */
	public MetricsConfiguration getMetricsConfiguration() {
		return metricsConfiguration;
	}

	/**
	 * @param metricsConfiguration
	 *            the metricsConfiguration to set
	 */
	public void setMetricsConfiguration(
			MetricsConfiguration metricsConfiguration) {
		this.metricsConfiguration = metricsConfiguration;
	}

	/**
	 * @return the metricsAssociationManager
	 */
	public MetricsAssociationManager getMetricsAssociationManager() {
		return metricsAssociationManager;
	}

	/**
	 * @param metricsAssociationManager
	 *            the metricsAssociationManager to set
	 */
	public void setMetricsAssociationManager(
			MetricsAssociationManager metricsAssociationManager) {
		this.metricsAssociationManager = metricsAssociationManager;
	}

	/**
	 * 
	 */
	@Override
	@Transactional
	public List<?> getData(Object criteria) {
		Session s = sessionfactory.getCurrentSession();
		List<?> objList = null;
		// Get the columns with aggregation functions concatenated
		String agrString = getAggregationString(metricsConfiguration
				.getColumns());

		// Get the lowest association level objects for given criteria
		// Eg:- RelmanCodeItemFile objects
		List<?> lalo = metricsAssociationManager
				.getLowestAssociationLevelObjects(criteria);

		String queryString = "select new map(" + agrString + ") from "
				+ metricsConfiguration.getLowestAssociationLevelEntity()
				+ " lale where lale in (:list)";
		
		logger.debug("The query string - " + queryString);

		// If the list of lowest association level objects is not null
		// We run the query
		if (lalo != null && ! lalo.isEmpty()) {
			objList = (List<?>) s.createQuery(queryString)
					.setParameterList("list", lalo).list();
		}
		
		return objList;
	}

	/**
	 * Build the HQL aggregation string for the given column configuration
	 * Map. It contains a given column and it's aggregation function
	 * @param mp
	 * @return
	 */
	private String getAggregationString(Map<String, String> mp) {
		String hql = "";
		Iterator<Entry<String, String>> it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			if (prefStats != null && !prefStats.contains(pairs.getKey())){
				// The current stat is not a preferred one to get data for 
				continue;
			}
			if (hql == "") {
				hql = hql + pairs.getValue() + "(" + pairs.getKey() + ") as "
						+ pairs.getKey();
			} else {
				hql = hql + "," + pairs.getValue() + "(" + pairs.getKey()
						+ ") as " + pairs.getKey();
			}
		}

		logger.debug("The HQL aggregation string - " + hql);
		return hql;
	}

	/**
	 * @return the prefCols
	 */
	public List<String> getPrefStats() {
		return prefStats;
	}

	/**
	 * @param prefCols the prefCols to set
	 */
	public void setPrefStats(List<String> prefStats) {
		this.prefStats = prefStats;
	}

	/**
	 * @param sessionfactory
	 * @param metricsConfiguration
	 * @param metricsAssociationManager
	 */
	public MetricsProviderImpl(SessionFactory sessionfactory,
			MetricsConfiguration metricsConfiguration,
			MetricsAssociationManager metricsAssociationManager) {
		this.sessionfactory = sessionfactory;
		this.metricsConfiguration = metricsConfiguration;
		this.metricsAssociationManager = metricsAssociationManager;
	}

}
