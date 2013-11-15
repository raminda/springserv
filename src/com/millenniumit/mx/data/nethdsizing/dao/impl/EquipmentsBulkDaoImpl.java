package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.EquipmentbulkDao;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author Raminda
 *
 */
@SuppressWarnings("unchecked")
@Repository("EquipmentbulkDao")
public class EquipmentsBulkDaoImpl implements EquipmentbulkDao {
	
	//*******************************************sessionFactor******************************************

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table=new String();
			protected EquipmentsBulkDaoImpl() {
	}

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
	
			public EquipmentsBulkDaoImpl(SessionFactory SessionFactory) {
				table="from Equipmentbulk ";
				this.SessionFactory=SessionFactory;
			}		
	//*******************************************end************************************************
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public EquipmentBulk get(int ID) {
		 
		return (EquipmentBulk)getSessionFactory().getCurrentSession()
				.createQuery(table + "  where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(EquipmentBulk)
	 */
	@Override
	public List<EquipmentBulk> getAll(Packages PackageID) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table + "  where PackageID =:PackageID ")
				.setParameter("PackageID", PackageID).list();
	}
	


	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<EquipmentBulk> getAll() {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table + "  order by PackageID").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<EquipmentBulk> getAll(int start, int limit) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table + "  order by PackageID")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.EquipmentbulkDao.dao.EquipmentsBulkDao#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.Equipments )
	 */
	@Override
	public List<EquipmentBulk> getAll(Equipments ItemID) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table + "  where ItemID=:ItemID order by PackageID")
				.setParameter("ItemID", ItemID).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.EquipmentbulkDao.dao.EquipmentsBulkDao#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.KpiCategory, java.lang.String)
	 */
	@Override
	public EquipmentBulk get(Packages PackageID, Equipments ItemID) { 
		return (EquipmentBulk) getSessionFactory().getCurrentSession()
				.createQuery(table + "  where PackageID=:PackageID and ItemID=:ItemID order by PackageID")
				.setParameter("PackageID", PackageID)
				.setParameter("ItemID", ItemID).uniqueResult();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(EquipmentBulk index) {
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getId();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(EquipmentBulk index) {
		 
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(EquipmentBulk object) {

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
