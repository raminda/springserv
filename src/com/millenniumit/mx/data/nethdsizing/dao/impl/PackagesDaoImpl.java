package com.millenniumit.mx.data.nethdsizing.dao.impl;

import java.sql.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.millenniumit.mx.data.nethdsizing.dao.PackagesDao;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;

/**
 * 
 * @author DECANS
 *
 */
@SuppressWarnings("unchecked")
@Repository("PackagesDao")
public class PackagesDaoImpl implements PackagesDao {

	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory SessionFactory;
	private String table=new String();
	protected PackagesDaoImpl() {
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
	
	public PackagesDaoImpl(SessionFactory SessionFactory){
		table="from Packages ";
		this.SessionFactory=SessionFactory;
	}
	/**
	 *  @param ID
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(String,int)
	 */
	@Override
	public Packages get(int ID) {
		 
		 
		return (Packages) getSessionFactory().getCurrentSession()
				.createQuery(table+" where ID =:ID")
				.setParameter("ID", ID).uniqueResult();
	}
	
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll()
	 */
	
	@Override
	public List<Packages> getAll(){
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by PackageName").list();
	}

	/**
	 * @param id
	 * @param Type =PackagesName-1 PackagesID-2
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(String,int)
	 */
	@Override
	public Packages get(String id) {
		 
		 
		return (Packages) getSessionFactory().getCurrentSession().createQuery(table+" where PackageName =:PackageName")
					.setParameter("PackageName", id).uniqueResult();
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#getAll(int, int)
	 */
	@Override
	public List <Packages> getAll(int start, int limit) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" order by PackageName")
				.setFirstResult(start).setMaxResults(limit).list();
	}
	/**
	 * @param date1,date2
	 * @param type= LUDate-1,EOL-2
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(Date,Date,int)
	 */
	@Override
	public List<Packages> getAll(Date date1, Date date2) {
		 
		 
		return getSessionFactory().getCurrentSession()
				.createQuery(table+" where EOLdate>:date1 and EOLdate<:date2  order by PackageName")
				.setParameter("date1", date1)
				.setParameter("date2", date2).list();
	}
	
	/**
	 * @param data
	 * @param Type
	 * @param =LUdate-1,EOL-2
	 * @param = Equal-1,Greater-2,Lower-3
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(Date,int,int)
	 */
	@Override
	public List<Packages> getAll(Date date,int sumtype) {
		 
		 
		if(sumtype==1){
				return getSessionFactory().getCurrentSession()
					.createQuery(table+" where EOLdate=:date order by PackageName")
					.setParameter("date", date).list();
			}
			else if(sumtype==2){
				return getSessionFactory().getCurrentSession()
					.createQuery(table+" where EOLdate>:date order by PackageName")
					.setParameter("date",date).list();
			}
			else{
				return getSessionFactory().getCurrentSession()
					.createQuery(table+" where EOLdate<:date order by PackageName")
					.setParameter("date", date).list();
			}
	}
	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#save(java.lang.Object)
	 */
	
	@Override
	public int save(Packages index)  {
		 
		 
		getSessionFactory().getCurrentSession().save(index);
		getSessionFactory().getCurrentSession().flush();
		return index.getId();
	}

	/**
	 *  (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.dao.Dao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Packages index)  {
		 
		 
		getSessionFactory().getCurrentSession().delete(index);
		getSessionFactory().getCurrentSession().flush();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.dao.Dao#update(java.lang.Object)
	 */
	@Override
	public void update(Packages index)  {
		 
		 
		getSessionFactory().getCurrentSession().update(index);
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