package com.millenniumit.mx.data.metrics;

import java.util.Map;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class MetricsConfiguration {
	
	/**
	 * This is the Hibernate entity name representing the metric table for
	 * the currently configured metric
	 */
	private String lowestAssociationLevelEntity;
	
	/**
	 * This map contains the Hibernate entity fields representing the metric table column
	 * And the associated operation(SUM, AVG)
	 */
	private Map<String, String> columns;
	
	/**
	 * The data type of each stat
	 */
	private Map<String, String> statsTypes;
	
	/**
	 * Human readable names for each stat
	 */
	private Map<String, String> columnsHumanReadableNames;
	
	/**
	 * @return the columns
	 */
	public Map<String, String> getColumns() {
		return columns;
	}

	/**
	 * @param columns the columns to set
	 */
	public void setColumns(Map<String, String> columns) {
		this.columns = columns;
	}

	/**
	 * @return the lowestAssociationLevelEntity
	 */
	public String getLowestAssociationLevelEntity() {
		return lowestAssociationLevelEntity;
	}

	/**
	 * @param lowestAssociationLevelEntity the lowestAssociationLevelEntity to set
	 */
	public void setLowestAssociationLevelEntity(
			String lowestAssociationLevelEntity) {
		this.lowestAssociationLevelEntity = lowestAssociationLevelEntity;
	}

	/**
	 * @return the statsTypes
	 */
	public Map<String, String> getStatsTypes() {
		return statsTypes;
	}

	/**
	 * @param statsTypes the statsTypes to set
	 */
	public void setStatsTypes(Map<String, String> statsTypes) {
		this.statsTypes = statsTypes;
	}

	/**
	 * @return the columnsHumanReadableNames
	 */
	public Map<String, String> getColumnsHumanReadableNames() {
		return columnsHumanReadableNames;
	}

	/**
	 * @param columnsHumanReadableNames the columnsHumanReadableNames to set
	 */
	public void setColumnsHumanReadableNames(
			Map<String, String> columnsHumanReadableNames) {
		this.columnsHumanReadableNames = columnsHumanReadableNames;
	}
}
