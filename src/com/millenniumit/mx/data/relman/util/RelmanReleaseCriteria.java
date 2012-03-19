package com.millenniumit.mx.data.relman.util;

import com.millenniumit.mx.data.relman.domain.*;

/**
 * 
 * This class provides a standard object to supply criteria for obtaining
 * RelmanRelease objects
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public class RelmanReleaseCriteria {

	private RelmanProject project = null;
	private RelmanRelease parentRelease = null;
	private String state = null;

	/**
	 * @return the project
	 */
	public RelmanProject getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(RelmanProject project) {
		this.project = project;
	}

	/**
	 * @return the parentRelease
	 */
	public RelmanRelease getParentRelease() {
		return parentRelease;
	}

	/**
	 * @param parentRelease
	 *            the parentRelease to set
	 */
	public void setParentRelease(RelmanRelease parentRelease) {
		this.parentRelease = parentRelease;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
