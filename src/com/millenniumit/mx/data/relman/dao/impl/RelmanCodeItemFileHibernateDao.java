package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanCodeItemFileDao;
import com.millenniumit.mx.data.relman.domain.RelmanCodeItemFile;

@Repository("relmanCodeItemFileDao")
@SuppressWarnings("unchecked")
public class RelmanCodeItemFileHibernateDao implements RelmanCodeItemFileDao {

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
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles() {
		return sessionfactory.getCurrentSession().
				createQuery("from RelmanCodeItemFile").setMaxResults(10).list();
	}

	@Override
	public RelmanCodeItemFile getRelmanCodeItemFile(Long id) {
		List<RelmanCodeItemFile> list = sessionfactory.getCurrentSession().
				createQuery("from RelmanCodeItemFile file where file.id=:id")
				.setParameter("id", id).list();
		if (list != null){
			return list.get(0);
		} else {
			return null;
		}
	}
	
}