package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanItemTypeDao;
import com.millenniumit.mx.data.relman.domain.RelmanItemType;

@Repository("relmanItemTypeDao")
public class RelmanItemTypeHibernateDao implements RelmanItemTypeDao {

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
	public List<RelmanItemType> getRelmanItemTypes() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanItemType").list();
	}
}