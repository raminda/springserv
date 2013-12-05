package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.ProjectDao;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.domain.Project;

@SuppressWarnings("unchecked")
@Repository("ProjectDao")
public class ProjectDaoImpl implements ProjectDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table="from project ";


	/**
	 * @return the ITICSessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}

	/**
	 * @param ITICSessionFactory the ITICSessionFactory to set
	 */
	public void setITICSessionFactory(SessionFactory ITICSessionFactory) {
		this.SessionFactory = ITICSessionFactory;
	}
	
	@Override
	public Project get(String id) {
		 
		 
		return (Project) getSessionFactory().getCurrentSession()
				.createQuery(table+" projects where ProjectName=:ProjectName")
				.setParameter("ProjectName", id).uniqueResult();
	}

	@Override
	public List <Project> getCompnay(Company Campanyname) {
		 
		 
		return  getSessionFactory().getCurrentSession()
				.createQuery(table+" projects where Company=:Campanyname")
				.setParameter("Campanyname", Campanyname).list();
	}

	@Override
	public List<Project> getAll(int start, int limit) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" projects order by ID")
				.setFirstResult(start).setMaxResults(limit).list();
	}

	@Override
	public List<Project> getAll() {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" projects order by  ID ")
				.list();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<String> getAllNames() {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery("select distinct Company from  projects order by Company").list();
	}
	@Override
	public Project get(int ID) {
		 
		 
		return (Project) getSessionFactory().getCurrentSession()
				.createQuery(table+" projects where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	@Override
	public int save(Project index)  {
		 
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getId();
	}
	

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Project  index)  {
		 
		 
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Project object)  {
		 
		 
		getSessionFactory().getCurrentSession().update(object);
		getSessionFactory().getCurrentSession().flush();
	}
	/**
	 * @category Destructor
	 */
	@Override
	protected void finalize() throws Throwable {
		getSessionFactory().getCurrentSession().flush();
		super.finalize();
	}
}