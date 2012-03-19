package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanCodeItemDao;
import com.millenniumit.mx.data.relman.domain.RelmanCodeItem;


@Repository("relmanCodeItemDao")
public class RelmanCodeItemHibernateDao implements RelmanCodeItemDao {

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
	public List<RelmanCodeItem> getRelmanCodeItems() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanCodeItem").list();
	}

	@Override
	public RelmanCodeItem getRelmanCodeItem(String relmanId) {
		return (RelmanCodeItem) sessionfactory.getCurrentSession().
				createQuery("from RelmanCodeItem where relmanId=:param")
				.setParameter("param", relmanId).list().get(0);
	}

	@Override
	public RelmanCodeItem getRelmanCodeItem(Long id) {
		return (RelmanCodeItem) sessionfactory.getCurrentSession().
				createQuery("from RelmanCodeItem where id=:param")
				.setParameter("param", id).list().get(0);
	}
	
}