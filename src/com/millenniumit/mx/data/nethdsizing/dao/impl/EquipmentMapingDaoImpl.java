package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
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
	private String table="from equipmentmaping";

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
	//*******************************************end************************************************
			
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(Long)
	 * @return EquipmentMaping
	 */
	@Override
	public EquipmentMaping get(int ID) {
		return (EquipmentMaping)getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID =:ID ")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#get(EquipmentBulk)
	 * @return List<EquipmentMaping>
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ParentID,Equipments ChildID) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where PEquipment =:PEquipment and CEquipment=:CEquipment")
				.setParameter("PEquipment", ParentID)
				.setParameter("CEquipment", ChildID).list();
	}
	


	/**
	 * 
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll()
	 * @return List<EquipmentMaping>
	 */
	@Override
	public List<EquipmentMaping> getAll() {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by PEquipment").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#getAll(int, int)
	 * @return List<EquipmentMaping>
	 */
	@Override
	public List<EquipmentMaping> getAll(int start, int limit) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by PEquipment")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.EquipmentMapingDaoImpl#getEquipmentsBulk(Equipments,ItemTypes )
	 * @return List<EquipmentMaping>
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ItemID,ItemTypes itemType) {
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where CEquipment=CEquipment.ID and CEquipment.itemtypes=:itemType and PEquipment=:PEquipment ")
				.setParameter("PEquipment", ItemID)
				.setParameter("itemType", itemType).list();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.EquipmentMapingDaoImpl#getEquipmentsBulk(Equipments,ItemTypes )
	 * @return List<EquipmentMaping>
	 */
	@Override
	public List<EquipmentMaping> getAll(Equipments ItemID,int type) {
		if(type==1){
			return getSessionFactory().getCurrentSession()
					.createQuery(table+" where CEquipment=:ChildID")
					.setParameter("ChildID", ItemID).list();
		}
		else{
			return getSessionFactory().getCurrentSession()
					.createQuery(table+" where PEquipment=:ParentID ")
					.setParameter("ParentID", ItemID).list();
		}
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#save(java.lang.Object)
	 * @return int
	 */
	
	@Override
	public int save(EquipmentMaping index) {
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(EquipmentMaping index) {
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.nethdsizing.dao.Dao#update(java.lang.Object)
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
