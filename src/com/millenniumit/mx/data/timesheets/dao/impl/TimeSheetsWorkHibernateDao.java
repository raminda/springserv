package com.millenniumit.mx.data.timesheets.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkDao;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

@Repository("timesheetsWorkDao")
public class TimeSheetsWorkHibernateDao implements TimeSheetsWorkDao {

	@Autowired
	private SessionFactory sessionfactory;

	/*
	 * * @see
	 * com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkDao#getTimeSheetsWork
	 * ()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TimeSheetsWork> getTimeSheetsWork() {

		return sessionfactory.getCurrentSession()
				.createQuery("from TimeSheetsWork").list();
	}

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	/**
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getTimeSheetsWork(long offset, long limit) {

		String queryString = " select new map(t.projectId as projectId,t.roleId as roleId,"
				+ "	t.userId as userId, t.reference as reference,"
				+ "	t.note as note,"
				+ " sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ " sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t "
				+ " group by t.userId, t.projectId, t.roleId";

		return getPaginatedResultSet(queryString, offset, limit);
	}

	/**
	 * 
	 * @param queryString
	 * @param offset
	 * @param limit
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Object> getPaginatedResultSet(String queryString, long offset,
			long limit) {

		Query query = sessionfactory.getCurrentSession().createQuery(
				queryString);

		int first = (int) offset;
		int last = (int) limit;
		query.setFirstResult(first);
		query.setMaxResults(last);
		return (List<Object>) query.list();
	}

	@Override
	public long getTotalTimeSheetsWorkCount() {
		Query q = sessionfactory.getCurrentSession().createQuery(
				"select count(*) from TimeSheetsWork");
		long result = Long.parseLong(q.list().get(0).toString());
		return result;
	}

	/**
 * 
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getTimeSheetsWork(long offset, long limit,
			Long[] users, Long[] roles) {

		String queryString = " select new map(t.projectId as projectId,t.roleId as roleId,"
				+ "t.userId as userId, t.reference as reference,"
				+ "t.note as note,"
				+ "sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ "sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t"
				+ " where t.roleId in :_roles and t.userId in :_users "
				+ "group by t.userId,t.projectId,t.roleId";

		Query query = sessionfactory.getCurrentSession().createQuery(
				queryString);

		query.setParameterList("_users", users);
		query.setParameterList("_roles", roles);

		int first = (int) offset;
		int last = (int) limit;
		query.setFirstResult(first);
		query.setMaxResults(last);
		return (List<Object>) query.list();

		// return getPaginatedResultSet(queryString, offset, limit);
	}

	/**
 * 
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getTimeSheetsWork(long offset, long limit,
			String startDate, String endDate) {

		String queryString = " select new map(t.projectId as projectId,t.roleId as roleId,"
				+ "t.userId as userId, t.reference as reference,"
				+ "t.note as note,"
				+ "sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ "sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t"
				+ " where t.workDate > :_startdate and t.workDate < :_enddate "
				+ "group by t.userId,t.projectId,t.roleId";

		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy/mm/dd");
		Date startdate = null;
		Date enddate = null;
		try {
			enddate = (Date) formatter.parse(endDate);
			startdate = (Date) formatter.parse(startDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Query query = sessionfactory.getCurrentSession().createQuery(
				queryString);

		query.setParameter("_startdate", startdate);
		query.setParameter("_enddate", enddate);

		int first = (int) offset;
		int last = (int) limit;
		query.setFirstResult(first);
		query.setMaxResults(last);
		return (List<Object>) query.list();
	}

	/**
 * 
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getTimeSheetsWork(long offset, long limit,
			TimeSheetsWorkCriteria workcriteria) {

		boolean whereFlag = false;

		String queryString = " select new map(t.projectId as projectId,t.roleId as roleId,"
				+ "t.userId as userId, t.reference as reference,"
				+ "t.note as note,"
				+ "sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ "sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t";

		if (workcriteria.getUserIds() != null) {
			queryString += getCriteriaString(whereFlag, "t.userId", "in",
					":_users");
			whereFlag = true;
		}

		if (workcriteria.getRoleIds() != null) {
			queryString += getCriteriaString(whereFlag, "t.roleId", "in",
					":_roles");
			whereFlag = true;
		}

		if (workcriteria.getProjectIds() != null) {
			queryString += getCriteriaString(whereFlag, "t.projectId", "in",
					":_projects");
			whereFlag = true;
		}

		if ((workcriteria.getStartDate() != null)) {
			queryString += getCriteriaString(whereFlag, "t.workDate", ">",
					":_startdate");
			whereFlag = true;
		}

		if ((workcriteria.getEndDate() != null)) {
			queryString += getCriteriaString(whereFlag, "t.workDate", "<",
					":_enddate");
			whereFlag = true;
		}

		queryString += " group by t.userId,t.projectId,t.roleId";
		Query query = sessionfactory.getCurrentSession().createQuery(
				queryString);

		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy/mm/dd");
		Date startdate = null;
		Date enddate = null;

		if (workcriteria.getProjectIds() != null)
			query.setParameterList("_projects", workcriteria.getProjectIds());
		if (workcriteria.getUserIds() != null)
			query.setParameterList("_users", workcriteria.getUserIds());
		if (workcriteria.getEndDate() != null) {

			try {
				enddate = (Date) formatter.parse(workcriteria.getEndDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			query.setParameter("_enddate", enddate);

		}
		if (workcriteria.getStartDate() != null) {

			try {
				startdate = (Date) formatter.parse(workcriteria.getStartDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			query.setParameter("_startdate", startdate);

		}
		if (workcriteria.getRoleIds() != null)
			query.setParameterList("_roles", workcriteria.getRoleIds());

		    		
		int first = (int) offset;
		int last = (int) limit;
		query.setFirstResult(first);
		query.setMaxResults(last);

		System.out.println("Query String = " + query.getQueryString());
		return (List<Object>) query.list();
	}

	/**
	 * 
	 * @param whereFlag
	 * @param operand
	 * @param operator
	 * @param parameter
	 * @return
	 */
	private String getCriteriaString(boolean whereFlag, String operand,
			String operator, String parameter) {

		if (whereFlag)
			return " and " + operand + " " + operator + " " + parameter;
		else
			return " where " + operand + " " + operator + " " + parameter;
	}
}
