package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanProjectLevelActivityDao;
import com.millenniumit.mx.data.relman.domain.RelmanProjectLevelActivity;

@Repository("relmanProjectLevelActivityDao")
public class RelmanProjectLevelActivityHibernateDao implements RelmanProjectLevelActivityDao {

	@Autowired
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RelmanProjectLevelActivity> getRelmanProjectLevelActivities() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanProjectLevelActivity").list();
	}

}