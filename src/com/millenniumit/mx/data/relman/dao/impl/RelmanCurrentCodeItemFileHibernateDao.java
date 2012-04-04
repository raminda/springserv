package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanCurrentCodeItemFileDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentCodeItemFile;


@Repository("relmanCurrentCodeItemFileDao")
public class RelmanCurrentCodeItemFileHibernateDao implements RelmanCurrentCodeItemFileDao {

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
	public List<RelmanCurrentCodeItemFile> getRelmanCurrentCodeItemFiles() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanCurrentCodeItemFile").setMaxResults(100).list();
	}
	
	
	
}