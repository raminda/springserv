package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanCurrentVersionDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentVersion;

@Repository("relmanCurrentVersionDao")
public class RelmanCurrentVersionHibernateDao implements RelmanCurrentVersionDao {

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
	public List<RelmanCurrentVersion> getRelmanCurrentVersions() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanCurrentVersion").list();
	}
	
}