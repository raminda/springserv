package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.millenniumit.mx.data.nethdsizing.dao.CompanyDao;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 *
 */
@SuppressWarnings("unchecked")
@Repository("CompanyDao")
public class CompanyDaoImpl implements CompanyDao {
	
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	private String table=new String();

	

	/**
	 * @return the SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	/**
	 * @param SessionFactory the SessionFactory to set
	 */
	public void setSessionFactory(SessionFactory SessionFactory) {
		this.sessionFactory = SessionFactory;
	}
	
	//*******************************************end************************************************
	public CompanyDaoImpl(){
		table="from Company ";
	}	
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(Long)
	 */
	@Override
	public Company get(int ID) {
		  
		 
		return (Company)getSessionFactory().getCurrentSession().
				createQuery(table+" where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(String)
	 */
	@Override
	public Company get(String CompanyName) {
		  
		 
		return (Company)getSessionFactory().getCurrentSession()
				.createQuery(table+" where CompanyName =:CompanyName")
				.setParameter("CompanyName", CompanyName).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(String)
	 */
	@Override
	public List<Company> getAll(String CompanyName) {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where CompanyName =:CompanyName")
				.setParameter("CompanyName", CompanyName).list();
	}

	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll()
	 */
	@Override
	public List <Company> getAll() {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by CompanyName").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll(int, int)
	 */
	
	@Override
	public List<Company> getAll(int start, int limit) {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by CompanyName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(Company index){
		  
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Company index) {
		  
		 
			getSessionFactory().getCurrentSession().delete(index);
			getSessionFactory().getCurrentSession().flush();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Company object) {
		  
		 
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
