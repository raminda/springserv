package com.millenniumit.mx.data.nethdsizing.dao.impl;



import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.ProjectItemsDao;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.domain.ProjectItems;
import com.millenniumit.mx.data.nethdsizing.domain.VersionMap;

/**
 * 
 * @author DECANS
 *
 */
@SuppressWarnings("unchecked")
@Repository("ProjectItemsDao")
public class ProjectItemsDaoImpl implements ProjectItemsDao {
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table="from projectItems ";
			
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
	public ProjectItems get(int ID) {
		 
		 
		return (ProjectItems) getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<ProjectItems> getAll() {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by Version").list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<ProjectItems> getAll(int start, int limit) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" projectitems order by Version")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	@Override
	public List<ProjectItems> getAll(VersionMap VersionID) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Version_Map =:Version_Map")
				.setParameter("Version_Map", VersionID).list();
	}
	
	@Override
	public List<ProjectItems> getAll(VersionMap VersionID,String PackageType) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Version_Map =:Version_Map and PackageType =:PackageType")
				.setParameter("PackageType", PackageType)
				.setParameter("Version_Map", VersionID).list();
	}
	@Override
	public List<String> getPackageType(VersionMap VersionID) {
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct PackageType "+table+" WHERE Version_Map =:Version_Map")
				.setParameter("Version_Map", VersionID).list();
	}
	@Override
	public ProjectItems get(VersionMap VersionID, Packages PackageID) {
 
		return (ProjectItems) getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Version_Map =:Version_Map and Packages =:Packages")
				.setParameter("Version_Map", VersionID)
				.setParameter("Packages", PackageID).uniqueResult();
	}
	
/*	@Override
	public List<ProjectItems> getAll(VersionMap VersionID,String SiteID) {	 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE SiteID =:SiteID and  Version_Map =:Version_Map")
				.setParameter("SiteID", SiteID)
				.setParameter("Version_Map", VersionID).list();
	}*/

	@Override
	public List<String> getAllPackage(VersionMap VersionID,String SiteID) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct PackageType from projectitems WHERE Version_Map =:VersionID")
				.setParameter("SiteID", SiteID)
				.setParameter("VersionID", VersionID).list();
	}

	
	@Override
	public List<String> getAllSites(VersionMap VersionID) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct SiteID from projectitems WHERE Version_Map =:VersionID")
				.setParameter("VersionID", VersionID).list();
	}
//*********************************************************************
	@Override
	public List<String> getAllPackagetype(VersionMap VersionID,String SiteID) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery("Select distinct PackageType from projectitems WHERE Version_Map =:VersionID and SiteID =:SiteID")
				.setParameter("SiteID", SiteID)
				.setParameter("VersionID", VersionID).list();
	}
	
	@Override
	public List<ProjectItems> getAll(VersionMap VersionID,String SiteID,String PackageType) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" WHERE Version_Map =:VersionID  and SiteID =:SiteID and  PackageType =:PackageType")
				.setParameter("SiteID", SiteID)
				.setParameter("PackageType", PackageType)
				.setParameter("VersionID", VersionID).list();
	}
	@Override
	public List<ProjectItems> getAlldtl(VersionMap VersionID) {
		
		return null;
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override 
	public int save(ProjectItems index)  {
		 
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getId();
	}

	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(ProjectItems index)  {
		 
		 
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}

	
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(ProjectItems object)  {
		 
		 
		getSessionFactory().getCurrentSession().update(object);
		getSessionFactory().getCurrentSession().flush();
	}
	/**
	 * @category Destructor
	 */
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
