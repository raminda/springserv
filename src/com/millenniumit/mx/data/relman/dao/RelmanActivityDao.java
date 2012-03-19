package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanActivity;
import com.millenniumit.mx.data.relman.domain.RelmanProject;

public interface RelmanActivityDao {
	List<RelmanActivity> getRelmanActivities();
	List<RelmanProject> getUniqueProjectsForRelmanActivity();
	List<RelmanActivity> getRelmanActivities(int offset,int limit);
	int getTotalRelmanActivityCount();
}



