package com.millenniumit.mx.data.relman.util;

import com.millenniumit.mx.data.relman.domain.RelmanLogicalLayer;

/**
 * 
 * This class provides a standard object to supply criteria for obtaining
 * RelmanProject objects
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class RelmanProjectCriteria {
	private Integer relmanLayerId = null;
	private RelmanLogicalLayer logicalLayer = null;
	private String type = null;

	/**
	 * @return the relmanLayerId
	 */
	public Integer getRelmanLayerId() {
		return relmanLayerId;
	}

	/**
	 * @param relmanLayerId
	 *            the relmanLayerId to set
	 */
	public void setRelmanLayerId(Integer relmanLayerId) {
		this.relmanLayerId = relmanLayerId;
	}

	/**
	 * @return the logicalLayer
	 */
	public RelmanLogicalLayer getLogicalLayer() {
		return logicalLayer;
	}

	/**
	 * @param logicalLayer
	 *            the logicalLayer to set
	 */
	public void setLogicalLayer(RelmanLogicalLayer logicalLayer) {
		this.logicalLayer = logicalLayer;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
}
