package com.millenniumit.mx.data.nethdsizing.dao.impl;



import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.VersionMapDao;
import com.millenniumit.mx.data.nethdsizing.domain.Project;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;

/**
 * 
 * @author DECANS
 *
 */
@SuppressWarnings("unchecked")
@Repository("VersionMapDao")
public class VersionMapDaoImpl implements VersionMapDao {
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String 	table=" from versionMap ";

			/**
			 * @return the SessionFactory
			 */
			public SessionFactory getSessionFactory() {
				return SessionFactory;
			}
			
			/**
			 * @param SessionFactory the SessionFactory to set
			 */
			public void setSessionFactory(SessionFactory SessionFactory) {
				this.SessionFactory = SessionFactory;
			}
			//*******************************************end************************************************

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(java.lang.Long)
	 */
	
	@Override
	public VersionMap get(int ID) {
		 
		 
		return (VersionMap) getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<VersionMap> getAll() {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by Version").list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<VersionMap> getAll(int start, int limit) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" VersionMap order by Version")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	@Override
	public List<VersionMap> getAll(VersionMap VersionID) { 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE VersionID =:VersionID")
				.setParameter("VersionID", VersionID).list();
	}
	
	@Override
	public  List<VersionMap> get(Project project,String OptionID, String Version) {
		return  getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Project =:Project and OptionID =:OptionID and Version =:Version")
				.setParameter("Project", project)
				.setParameter("OptionID", OptionID)
				.setParameter("Version", Version).list();
	}
	
	@Override
	public List<String> getAll(Project project,String OptionID) { 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct Version "+table+" WHERE OptionID =:OptionID and  Project =:Project")
				.setParameter("OptionID", OptionID)
				.setParameter("Project", project).list();
	}
	@Override
	public List<VersionMap> getAll(Project project) { 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Project =:Project")
				.setParameter("Project", project).list();
	}
	@Override
	public VersionMap get(Project project,String OptionID, String Version,String SiteID) {	 
		return (VersionMap) getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Project =:Project and SiteID =:SiteID and OptionID =:OptionID and Version =:Version")
				.setParameter("SiteID", SiteID)
				.setParameter("Version", Version)
				.setParameter("OptionID", OptionID)
				.setParameter("Project", project).uniqueResult();
	}

	
	@Override
	public List<String> getAllSites(VersionMap VersionID) { 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct SiteID "+table+" WHERE VersionID =:VersionID")
				.setParameter("VersionID", VersionID).list();
	}
//*********************************************************************
	@Override
	public List<String> getAllPackagetype(VersionMap VersionID,String SiteID) { 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct PackageType "+table+" WHERE VersionID =:VersionID and SiteID =:SiteID")
				.setParameter("SiteID", SiteID)
				.setParameter("VersionID", VersionID).list();
	}
	@Override
	public List<String> getAllPackagetype(Project project) {  
		return getSessionFactory().getCurrentSession()
				.createQuery("SELECT distinct OptionID "+table+" WHERE Project =:Project")
				.setParameter("Project", project).list();
	}
	@Override
	public List<VersionMap> getAll(VersionMap VersionID,String SiteID,String PackageType) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE VersionID =:VersionID  and SiteID =:SiteID and  PackageType =:PackageType")
				.setParameter("SiteID", SiteID)
				.setParameter("PackageType", PackageType)
				.setParameter("VersionID", VersionID).list();
	}
	@Override
	public List<VersionMap> getAlldtl(VersionMap VersionID) {
		
		return null;
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override 
	public int save(VersionMap index)  {
		 
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush(); 
		return index.getID();
	}

	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(VersionMap index)  {
		 
		 
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush(); 
	}

	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(VersionMap object)  {
		 
		 
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
