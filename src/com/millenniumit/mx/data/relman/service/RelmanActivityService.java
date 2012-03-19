package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanActivity;
import com.millenniumit.mx.data.relman.domain.RelmanProject;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
public interface RelmanActivityService {
	public List<RelmanActivity> getRelmanActivities();
	public List<RelmanActivity> getRelmanActivities(int offset, int limit);
	public List<RelmanProject> getUniqueProjectsForRelmanActivity();
	public String getRelmanActivitiesJSON();
	public String getRelmanActivitiesJSON(int start, int limit);
	public int getTotalRelmanActivityCount();
	
}
