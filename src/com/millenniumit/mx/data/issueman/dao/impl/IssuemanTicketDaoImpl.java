/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.millenniumit.mx.data.issueman.dao.IssuemanTicketDao;
import com.millenniumit.mx.data.issueman.domain.IssuemanProject;
import com.millenniumit.mx.data.issueman.domain.IssuemanTicket;
import com.millenniumit.mx.data.issueman.domain.IssuemanTypeFieldCurrent;

/**
 * 
 * @author Kalpag
 * 
 */
@Repository("issuemanTicketDao")
public class IssuemanTicketDaoImpl implements IssuemanTicketDao {

	@Autowired
	@Qualifier("IssuemanSessionFactory")
	private SessionFactory IssuemanSessionFactory;

	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek() {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(int offset, int limit) {
		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
				"from IssuemanTicket");
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<IssuemanTicket>) query.list();
	}

	/**
 * 
 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanTicket> getTicketsGroupByWeek(IssuemanProject project,
			int type, int subType, Date from, Date to, boolean clientCopied) {

		long projectId = project.getId();

		String queryString = "select ticket from IssuemanTypeFieldCurrent as type " +
				" where type.ticket.project.id = "+projectId+"";

		Query query = IssuemanSessionFactory.getCurrentSession().createQuery(
				queryString);
		query.setFirstResult(1);
		query.setMaxResults(100);
		return (List<IssuemanTicket>) query.list();
	}

	/**
	 * @return the sessionfactory
	 */
	public SessionFactory getSessionfactory() {
		return IssuemanSessionFactory;
	}

	/**
	 * @param sessionfactory
	 *            the sessionfactory to set
	 */
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.IssuemanSessionFactory = sessionfactory;
	}

}
