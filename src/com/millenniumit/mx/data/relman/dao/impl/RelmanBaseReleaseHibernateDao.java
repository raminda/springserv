package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanBaseReleaseDao;
import com.millenniumit.mx.data.relman.domain.RelmanBaseRelease;

@Repository("relmanBaseReleaseDao")
public class RelmanBaseReleaseHibernateDao implements RelmanBaseReleaseDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RelmanBaseRelease> getRelmanBaseReleases() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanBaseRelease").list();
	}
	
}