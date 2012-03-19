package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanLogicalLayerDao;
import com.millenniumit.mx.data.relman.domain.RelmanLogicalLayer;

@Repository("relmanLogicalLayerDao")
public class RelmanLogicalLayerHibernateDao implements RelmanLogicalLayerDao {

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
	public List<RelmanLogicalLayer> getRelmanLogicalLayers() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanLogicalLayer").list();
	}

}