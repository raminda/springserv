package com.millenniumit.mx.data.timesheets.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.millenniumit.mx.data.timesheets.dao.TimeSheetsWorkDao;
import com.millenniumit.mx.data.timesheets.domain.TimeSheetsWork;
import com.millenniumit.mx.data.timesheets.util.TimeSheetsWorkCriteria;

/**
 * 
 * @author Kalpag
 * 
 */

@Repository("timesheetsWorkDao")
public class TimeSheetsWorkHibernateDao implements TimeSheetsWorkDao {

	@Autowired
	private SessionFactory sessionfactory;
	private long timeSheetsWorkRowCount;

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

		String queryString = " select new map(t.divisionId as divisionId,t.projectId as projectId,t.roleId as roleId,"
				+ "	t.userId as userId, t.reference as reference,"
				+ "	t.note as note,"
				+ " sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ " sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t "
				+ " group by t.divisionId, t.userId, t.projectId, t.roleId";

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
			TimeSheetsWorkCriteria workcriteria) {

		boolean whereFlag = false;
		String selectString = " select new map(t.divisionId as divisionId,"
				+ "t.projectId as projectId,t.roleId as roleId,"
				+ "t.userId as userId, t.reference as reference,"
				+ "t.note as note,"
				+ "sum(t.hoursPlanned) as hoursPlanned,sum(t.hoursUnplanned) as hoursUnplanned,"
				+ "sum(t.hoursPlanned) + sum(t.hoursUnplanned) as total) from TimeSheetsWork t";

		String countSelectString = "select count(*) from TimeSheetsWork t";
		String groupString = " group by t.divisionId,t.userId,t.projectId,t.roleId";
		String criteriaString = "";
		String queryString = "";
		String countQueryString = "";

		if (workcriteria.getUserIds() != null) {
			criteriaString += getCriteriaString(whereFlag, "t.userId", "in",
					":_users");
			whereFlag = true;
		}

		if (workcriteria.getDivisionIds() != null) {
			criteriaString += getCriteriaString(whereFlag, "t.divisionId",
					"in", ":_divisions");
			whereFlag = true;
		}

		if (workcriteria.getRoleIds() != null) {
			criteriaString += getCriteriaString(whereFlag, "t.roleId", "in",
					":_roles");
			whereFlag = true;
		}

		if (workcriteria.getProjectIds() != null) {
			criteriaString += getCriteriaString(whereFlag, "t.projectId", "in",
					":_projects");
			whereFlag = true;
		}

		if ((workcriteria.getStartDate() != null)) {
			criteriaString += getCriteriaString(whereFlag, "t.workDate", ">",
					":_startdate");
			whereFlag = true;
		}

		if ((workcriteria.getEndDate() != null)) {
			criteriaString += getCriteriaString(whereFlag, "t.workDate", "<",
					":_enddate");
			whereFlag = true;
		}

		queryString += selectString + criteriaString + groupString;
		countQueryString = countSelectString + criteriaString + groupString;

		Query query = sessionfactory.getCurrentSession().createQuery(
				queryString);
		Query countHQLQuery = getSessionfactory().getCurrentSession()
				.createQuery(countQueryString);

		DateFormat formatter;
		formatter = new SimpleDateFormat("yyyy/mm/dd");
		Date startdate = null;
		Date enddate = null;

		if (workcriteria.getProjectIds() != null) {
			query.setParameterList("_projects", workcriteria.getProjectIds());
			countHQLQuery.setParameterList("_projects",
					workcriteria.getProjectIds());
		}
		if (workcriteria.getUserIds() != null) {
			query.setParameterList("_users", workcriteria.getUserIds());
			countHQLQuery.setParameterList("_users", workcriteria.getUserIds());
		}
		if (workcriteria.getDivisionIds() != null) {
			query.setParameterList("_divisions", workcriteria.getDivisionIds());
			countHQLQuery.setParameterList("_divisions",
					workcriteria.getDivisionIds());
		}
		if (workcriteria.getEndDate() != null) {
			try {
				enddate = (Date) formatter.parse(workcriteria.getEndDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			query.setParameter("_enddate", enddate);
			countHQLQuery.setParameter("_enddate", enddate);
		}

		if (workcriteria.getStartDate() != null) {
			try {
				startdate = (Date) formatter.parse(workcriteria.getStartDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			query.setParameter("_startdate", startdate);
			countHQLQuery.setParameter("_startdate", startdate);
		}
		if (workcriteria.getRoleIds() != null) {
			query.setParameterList("_roles", workcriteria.getRoleIds());
			countHQLQuery.setParameterList("_roles", workcriteria.getRoleIds());
		}
		long returnedRowcount = countHQLQuery.list().size();
		setTimeSheetsWorkRowCount(returnedRowcount);

		System.out.println("Returned rowCount is " + returnedRowcount);

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

	/**
	 * @return the timeSheetsWorkRowCount
	 */
	public long getTimeSheetsWorkRowCount() {
		return timeSheetsWorkRowCount;
	}

	/**
	 * @param timeSheetsWorkRowCount
	 *            the timeSheetsWorkRowCount to set
	 */
	public void setTimeSheetsWorkRowCount(long timeSheetsWorkRowCount) {
		this.timeSheetsWorkRowCount = timeSheetsWorkRowCount;
	}

	@Override
	public long getTimeSheetWorkReturnedRowCount() {
		return getTimeSheetsWorkRowCount();
	}

	@Override
	public void saveTimeSheetsWork(TimeSheetsWork timesheetWork) {
		// sessionfactory.getCurrentSession().save(timesheetWork);
		Gson gs = new Gson();

	 sessionfactory.getCurrentSession().save(timesheetWork);
		sessionfactory.getCurrentSession().flush();
		System.out.println("ID = " + timesheetWork.getId());
		//
		// sessionfactory.getCurrentSession().clear();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TimeSheetsWork> getAllTimeSheetsWork(long offset, long limit) {
		Query query = sessionfactory.getCurrentSession().createQuery(
				"from TimeSheetsWork");
		int first = (int) offset;
		int last = (int) limit;
		query.setFirstResult(first);
		query.setMaxResults(last);
		return query.list();
	}
}