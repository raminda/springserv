package com.millenniumit.mx.data.nethdsizing.dao.impl;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.ItemTypesDao;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
/**
 * 
 * @author Raminda
 *
 */
@SuppressWarnings("unchecked")
@Repository("ItemTypesDao")
public class ItemTypesDaoImpl implements ItemTypesDao {
	
	//*******************************************sessionFactor******************************************
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table="from itemTypes ";
			protected ItemTypesDaoImpl() {
	}

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
			public ItemTypesDaoImpl(SessionFactory SessionFactory){
				table="from ItemTypes ";
				this.SessionFactory=SessionFactory;
			}
		//*******************************************end************************************************


	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(Long)
	 */
	@Override
	public ItemTypes get(int  ID) {
		return (ItemTypes) getSessionFactory().getCurrentSession()
				.createQuery(table+"  where ID =:ID and TypeName!='base'")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(String)
	 */
	@Override
	public ItemTypes get(String TypeName) {
		  
		 
		return (ItemTypes) getSessionFactory().getCurrentSession()
				.createQuery(table+"  where TypeName!='base'and TypeName=:TypeName")
				.setParameter("TypeName", TypeName).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#get(int)
	 */
	@Override
	public  List<ItemTypes> getAll(int  AccsessLevel) {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where TypeName!='base' and AccsessLevel =:AccsessLevel order by TypeName")
				.setParameter("AccsessLevel",  AccsessLevel).list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	@Override
	public List<ItemTypes> getAll() {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where TypeName!='base' order by TypeName").list();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List<ItemTypes> getAll(int start, int limit) {
		  
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where TypeName!='base' order by TypeName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	@Override
	public int save(ItemTypes index){
		  
		 
			getSessionFactory().getCurrentSession().save(index);
			getSessionFactory().getCurrentSession().flush();
		return index.getID();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(ItemTypes index) {
		  
		 
			getSessionFactory().getCurrentSession().flush();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(ItemTypes object)  {
		  
		 
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
