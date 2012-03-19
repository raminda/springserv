package com.millenniumit.mx.data.timesheets.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsUserDao;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsUser;

@Repository("timesheetsUserDao")
public class TimeSheetsUserHibernateDao implements TimeSheetsUserDao {

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
	public List<TimeSheetsUser> getTimeSheetsUsers() {
		return sessionfactory.getCurrentSession()
				.createQuery("from TimeSheetsUser").list();
	}

	@Override
	public void saveTimeSheetsUsers(TimeSheetsUser timesheetsuser) {
		sessionfactory.getCurrentSession().saveOrUpdate(timesheetsuser);
		sessionfactory.getCurrentSession().flush();
	}

	@Override
	public void deleteTimeSheetsUsers(long userId) {

		TimeSheetsUser timesheetsuser = (TimeSheetsUser) sessionfactory
				.getCurrentSession()
				.createQuery(
						"from TimeSheetsUser where userId ='" + userId + "'")
				.list().get(0);

		sessionfactory.getCurrentSession().delete(timesheetsuser);
	}

	
}