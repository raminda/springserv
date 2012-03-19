package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanActivityDao;
import com.millenniumit.mx.data.relman.domain.RelmanActivity;
import com.millenniumit.mx.data.relman.domain.RelmanProject;
import com.millenniumit.mx.data.relman.service.RelmanActivityService;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Service("relmanActivityService")
public class RelmanActivityServiceImpl implements RelmanActivityService {

	@Autowired
	@Qualifier("relmanActivityDao")
	private RelmanActivityDao activitydao;

	public RelmanActivityDao getActivitydao() {
		return activitydao;
	}

	public void setActivitydao(RelmanActivityDao activitydao) {
		this.activitydao = activitydao;
	}

	@Transactional
	public List<RelmanActivity> getRelmanActivities() {
		return activitydao.getRelmanActivities();
	}

	@Override
	@Transactional
	public List<RelmanProject> getUniqueProjectsForRelmanActivity() {
		return activitydao.getUniqueProjectsForRelmanActivity();
	}

	@Override
	@Transactional
	public List<RelmanActivity> getRelmanActivities(int offset, int limit) {
		return activitydao.getRelmanActivities(offset, limit);

	}

	@Override
	@Transactional
	public String getRelmanActivitiesJSON() {

		List<RelmanActivity> activities = this.getRelmanActivities();
		return getJSON(activities);
	}

	// ---------------------------------------------------------------------------------------------

	@Override
	@Transactional
	public String getRelmanActivitiesJSON(int start, int limit) {

		List<RelmanActivity> activities = this
				.getRelmanActivities(start, limit);
		return getJSON(activities);

	}

	// ---------------------------------------------------------------------------------------------

	private String getJSON(List<RelmanActivity> activities) {

		String Jsonstr = "[";
		for (RelmanActivity relmanActivity : activities) {

			Jsonstr += relmanActivity.toJSON() + ",";
		}

		Jsonstr = Jsonstr.substring(0, Jsonstr.length() - 1);
		Jsonstr += "]";
		return Jsonstr;

	}

	@Override
	@Transactional
	public int getTotalRelmanActivityCount() {

		return activitydao.getTotalRelmanActivityCount();
	}

}
