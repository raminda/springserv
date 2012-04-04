package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanGroupDao;
import com.millenniumit.mx.data.relman.domain.RelmanGroup;

@Repository("relmanGroupDao")
public class RelmanGroupHibernateDao implements RelmanGroupDao {

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
	public List<RelmanGroup> getRelmanGroups() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanGroup").list();
	}

	@Override
	public RelmanGroup getRelmanGroup(String relmanId) {
		return (RelmanGroup) sessionfactory.getCurrentSession().
				createQuery("from RelmanGroup where relmanId=:param")
				.setParameter("param", relmanId).list().get(0);
	}

	@Override
	public RelmanGroup getRelmanGroup(Long id) {
		return (RelmanGroup) sessionfactory.getCurrentSession().
				createQuery("from RelmanGroup where id=:param")
				.setParameter("param", id).list().get(0);
	}
	
}