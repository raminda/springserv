package com.millenniumit.mx.data.relman.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.relman.dao.RelmanCurrentReleaseInfoDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentReleaseInfo;

@SuppressWarnings("unchecked")
@Repository("relmanCurrentReleaseInfoDao")
public class RelmanCurrentReleaseInfoHibernateDao implements
		RelmanCurrentReleaseInfoDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@Override
	public List<RelmanCurrentReleaseInfo> getCurrentReleaseInfo() {
		return sessionfactory.getCurrentSession().
				createQuery(
						"from RelmanCurrentReleaseInfo r where r.dateCreated =" +
						" (select max(dateCreated) from RelmanCurrentReleaseInfo c" +
						" where r.project=c.project) group by r.project")
						.list();
	}

	@Override
	public void saveCurrentReleaseInfo(RelmanCurrentReleaseInfo info) {
		sessionfactory.getCurrentSession().save(info);
		sessionfactory.getCurrentSession().flush();
	}

}
