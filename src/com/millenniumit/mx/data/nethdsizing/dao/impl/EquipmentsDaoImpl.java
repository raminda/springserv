package com.millenniumit.mx.data.nethdsizing.dao.impl;



import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.EquipmentsDao;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
@SuppressWarnings("unchecked")
@Repository("EquipmentsDao")
public class EquipmentsDaoImpl implements EquipmentsDao {
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table="from equipments ";
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
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	//****************************************************************************
	@Override
	public Equipments get(int ID) {
		 
		 
		return (Equipments)getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID=:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	//****************************************************************************
	@Override
	public List<Equipments> getBases(int ID) {
		return  getSessionFactory().getCurrentSession()
				.createQuery(table+" where  itemtypes.AccsessLevel=:ID and itemtypes=itemtypes.ID and itemtypes.ID!='1' order by ItemName ")
				.setParameter("ID", ID).list();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<Equipments> getAll() {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where ID!='1' order by ItemName").list();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<Equipments> getAll(int start, int limit) {
		return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where ID!='1' order by ItemName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @param type =EquipmentsName=1,EquipmentsID=2
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getname(String,int)
	 */
	@Override
	public Equipments getName(String Equipments){
			return (Equipments) getSessionFactory().getCurrentSession()
					.createQuery(table+" where ItemName =:ItemName")
					.setParameter("ItemName", Equipments).uniqueResult();
	}
	
	/**
	 * @return
	 * @param
	 */
	@Override
	public List<Equipments> getAll(ItemTypes equipmentsType) {
		return getSessionFactory()
			.getCurrentSession()
			.createQuery(table+" where itemtypes=:equipmentsType and ID!='1' order by ItemName")
			.setParameter("equipmentsType", equipmentsType).list();
	}

	@Override
	public List<Equipments> getAll(Long Price, int sumtype) {
		if(sumtype==1){
			return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where Price=:Price and ID!='1' order by ItemName")
				.setParameter("Price", Price).list();
		}
		else if(sumtype==2){
			return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where Price>:Price and ID!='1' order by ItemName")
				.setParameter("Price", Price).list();
		}
		else{
			return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where Price<:Price and ID!='1'  order by ItemName")
				.setParameter("Price", Price).list();
		}
	}

	@Override
	public List<Equipments> getAll(Date date, int sumtype) {

			if(sumtype==1){
				return getSessionFactory()
					.getCurrentSession()
					.createQuery(table+" where EOLDate=:date and ID!='1' order by ItemName")
					.setParameter("date", date).list();
			}
			else if(sumtype==2){
				return getSessionFactory()
					.getCurrentSession()
					.createQuery(table+" where EOLDate>:date and ID!='1' order by ItemName")
					.setParameter("date",date).list();
			}
			else{
				return getSessionFactory()
					.getCurrentSession()
					.createQuery(table+" where EOLDate<:date and  ID!='1'  order by ItemName")
					.setParameter("date", date).list();
			}
	}

	@Override
	public List<Equipments> getAll(Date date1, Date date2) {
			return getSessionFactory()
				.getCurrentSession()
				.createQuery(table+" where EOLDate>:date1 and EOLDate<:date2 and ID!='1'  order by ItemName")
				.setParameter("date1", date1)
				.setParameter("date2", date2).list();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public int save(Equipments index)  {
			getSessionFactory().getCurrentSession().save(index);
			getSessionFactory().getCurrentSession().flush();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Equipments index)  {
			getSessionFactory().getCurrentSession().delete(index);
			getSessionFactory().getCurrentSession().flush();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Equipments object)  {
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
