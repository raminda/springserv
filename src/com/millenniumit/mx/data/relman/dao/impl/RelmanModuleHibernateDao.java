package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanModuleDao;
import com.millenniumit.mx.data.relman.domain.RelmanModule;

@Repository("relmanModuleDao")
public class RelmanModuleHibernateDao implements RelmanModuleDao {

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
	public List<RelmanModule> getRelmanModules() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanModule").list();
	}

	@Override
	public RelmanModule getRelmanModule(String relmanId) {
		return (RelmanModule) sessionfactory.getCurrentSession().
				createQuery("from RelmanModule where relmanId=:param")
				.setParameter("param", relmanId).list().get(0);
	}

	@Override
	public RelmanModule getRelmanModule(Long id) {
		return (RelmanModule) sessionfactory.getCurrentSession().
				createQuery("from RelmanModule where id=:param")
				.setParameter("param", id).list().get(0);
	}

}