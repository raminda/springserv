/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.issueman.domain.IssuemanRole;
import com.millenniumit.mx.data.issueman.dao.IssuemanRoleDao;

/**
 * @author kalpag
 * 
 */
@Repository("issuemanRoleDao")
public class IssuemanRoleDaoImpl implements IssuemanRoleDao {

	private String ROLE_NAME = "Ext QA%";

	@Autowired
	@Qualifier("issuemanSessionFactory")
	private SessionFactory issuemanSessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanRole#getIssuemanRoles()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanRole> getIssuemanRoles() {
		List<IssuemanRole> qaRoles = null;
		String queryString = "from IssuemanRole";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		qaRoles = (List<IssuemanRole>) query.list();
		return qaRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.millenniumit.mx.data.issueman.dao.IssuemanRole#getEqaRoles()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<IssuemanRole> getEqaRoles() {
		List<IssuemanRole> qaRoles = null;
		String queryString = "from IssuemanRole where name like :Role";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("Role", ROLE_NAME);
		qaRoles = (List<IssuemanRole>) query.list();
		return qaRoles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.millenniumit.mx.data.issueman.dao.IssuemanRoleDao#getEqaRoleNames()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getEqaRoleNames() {

		List<String> qaRoleNames = null;
		String queryString = "select name from IssuemanRole where name like :Role";
		Query query = issuemanSessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter("Role", ROLE_NAME);
		qaRoleNames = (List<String>) query.list();
		return qaRoleNames;
	}
}
