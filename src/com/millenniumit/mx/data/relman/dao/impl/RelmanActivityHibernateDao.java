package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanActivityDao;
import com.millenniumit.mx.data.relman.domain.RelmanActivity;
import com.millenniumit.mx.data.relman.domain.RelmanProject;

@SuppressWarnings("unchecked")
@Repository("relmanActivityDao")
public class RelmanActivityHibernateDao implements RelmanActivityDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List<RelmanActivity> getRelmanActivities() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanActivity where action='Create'").list();
	}
		
	@Override
	public List<RelmanProject> getUniqueProjectsForRelmanActivity(){
		return sessionfactory.getCurrentSession().
				createQuery("select distinct act.project from RelmanActivity act").list();
	}
	
	@Override
	public List<RelmanActivity> getRelmanActivities(int offset, int limit){		
		Query query = sessionfactory.getCurrentSession().createQuery("from RelmanActivity");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return  query.list();
	}

	@Override
	public int getTotalRelmanActivityCount() {
		
		Query q = 	sessionfactory.getCurrentSession().createQuery("select count(*) from RelmanActivity");
	   	int result  = Integer.parseInt(q.list().get(0).toString());
	   	return result; 
	}
	
	
}
