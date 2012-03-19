package com.millenniumit.mx.data.metrics;

import java.util.*;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.domain.RelmanRelease;

/**
 * This metrics provider was implemented to make it faster to retrieve
 * statistics for a set of releases
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class RelmanReleaseMetricsProvider implements MetricsProvider {

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
	 * This is not used in this particular provider
	 */
	private MetricsAssociationManager metricsAssociationManager;

	/**
	 * Logger for this class
	 */
	private Logger logger = Logger
			.getLogger(RelmanReleaseMetricsProvider.class);

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<?> getData(Object criteria) {
		Session s = sessionfactory.getCurrentSession();
		List<RelmanRelease> releases = (List<RelmanRelease>) criteria;
		List<?> objList = null;
		// Get the columns with aggregation functions concatenated
		String agrString = getAggregationString(metricsConfiguration
				.getColumns());

		String queryString = "select new map(release.id as release_id, "
				+ "release.project.id as project_id, release.relmanId as relman_id, "
				+ "release.name as name, release.parentRelease.id as parent_release_id, "
				+ "release.status as status, " + agrString + ") "
				+ "from RelmanRelation rr "
				+ "join rr.relationKey.release as release "
				+ "join rr.relationKey.file as file "
				+ "where release in :list group by release";

		logger.debug("The query string - " + queryString);

		objList = (List<?>) s.createQuery(queryString)
				.setParameterList("list", releases).list();

		return objList;
	}

	/**
	 * Build the HQL aggregation string for the given column configuration Map.
	 * It contains a given column and it's aggregation function
	 * 
	 * @param mp
	 * @return
	 */
	private String getAggregationString(Map<String, String> mp) {
		String hql = "";
		Iterator<Entry<String, String>> it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, String> pairs = it.next();
			if (prefStats != null && !prefStats.contains(pairs.getKey())) {
				// The current stat is not a preferred one to get data for
				continue;
			}
			if (hql == "") {
				hql = hql + pairs.getValue() + "(file." + pairs.getKey()
						+ ") as " + pairs.getKey();
			} else {
				hql = hql + "," + pairs.getValue() + "(file." + pairs.getKey()
						+ ") as " + pairs.getKey();
			}
		}

		logger.debug("The HQL aggregation string - " + hql);
		return hql;
	}

	@Override
	public void setPrefStats(List<String> prefStats) {
		this.prefStats = prefStats;
	}

	/**
	 * @param sessionfactory
	 * @param metricsConfiguration
	 * @param metricsAssociationManager
	 */
	public RelmanReleaseMetricsProvider(SessionFactory sessionfactory,
			MetricsConfiguration metricsConfiguration,
			MetricsAssociationManager metricsAssociationManager) {
		this.sessionfactory = sessionfactory;
		this.metricsConfiguration = metricsConfiguration;
		this.metricsAssociationManager = metricsAssociationManager;
	}

}
