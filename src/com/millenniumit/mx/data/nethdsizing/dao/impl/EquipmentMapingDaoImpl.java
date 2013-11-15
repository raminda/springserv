package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.millenniumit.mx.data.nethdsizing.dao.EquipmentMapingDao;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;

/**
 * 
 * @author Raminda
 *
 */
@Repository("EquipmentMapingDao")
@SuppressWarnings("unchecked")
public class EquipmentMapingDaoImpl implements EquipmentMapingDao {
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	
	private String table=new String();
	private Transaction trans;
	//private getSessionFactory().getCurrentSession() ssession;

	/**
	 * @return  SessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}
	/**
	 * @param SessionFactory
	 */
	public void setITICSessionFactory(SessionFactory ITICSessionFactory) {
		this.SessionFactory = ITICSessionFactory;
	}
	public EquipmentMapingDaoImpl(){
		table="from Equipmentmaping ";
	}
	//*******************************************end************************************************
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public EquipmentMaping get(int ID) {
		return (EquipmentMaping)getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(EquipmentBulk)
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ParentID,Equipments ChildID) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where ParentID =:ParentID and ChildID=:ChildID")
				.setParameter("ParentID", ParentID)
				.setParameter("ChildID", ChildID).list();
	}
	


	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<EquipmentMaping> getAll() {
		return getSessionFactory().getCurrentSession()
				.createQuery("from equipmentmaping order by ParentID").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<EquipmentMaping> getAll(int start, int limit) {
		return getSessionFactory().getCurrentSession()
				.createQuery("from equipmentmaping order by ParentID")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.EquipmentMapingDaoImpl#getEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.Equipments )
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ItemID,ItemTypes itemType) {
		return getSessionFactory().getCurrentSession()
				.createQuery("from equipmentmaping where ChildID=ChildID.ID and ChildID.ItemType=:itemType and ParentID=:ParentID ")
				.setParameter("ParentID", ItemID)
				.setParameter("itemType", itemType).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(EquipmentMaping index) {
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();trans.commit();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(EquipmentMaping index) {
		
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(EquipmentMaping object) {
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
