
package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.dao.CompanyDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.CompanyDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.Company;
import com.millenniumit.mx.data.nethdsizing.service.CompanyService;
/**
 * 
 * @author Raminda
 *
 */
@Service("CompanyService")
public class  CompanyServiceImpl implements  CompanyService {
	
	@Autowired
	@Qualifier("CompanyDao")
	private CompanyDao CompanyDao;
	protected CompanyServiceImpl() {
	}


	public CompanyServiceImpl(SessionFactory SessionFactory){
		CompanyDao=new CompanyDaoImpl();
	}
	

	/**
	 * @return {@link CompanyDao}
	 */
	public CompanyDao getCompanyDao() {
		return CompanyDao;
	}

	/**
	 * @param  {@link CompanyDao}
	 */
	public void setCompanyDao(CompanyDao CompanyDao) {
		this.CompanyDao = CompanyDao;
	}

	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #get(int)}
*/
	@Override
	@Transactional
	public Company get(int ID) {
		return getCompanyDao().get(ID);
	}

	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #getAll(int, int)}
	 */
	@Override
	@Transactional
	public  List<Company> getAll(int start ,int limit) {
		return getCompanyDao().getAll(start, limit);
	}
/**
 * @see 'CompanyServiceImpl{@link #get(String)}
 */
	@Override
	@Transactional
	public  Company get(String CompanyName) {
		return getCompanyDao().get(CompanyName);
	}
	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #getAll()}
	 */
	@Override
	@Transactional
	public List<Company> getAll() {
		return getCompanyDao().getAll();
	}
	/** (non-Javadoc)
	 * @see 'CompanyServiceImpl{@link #save(Company)}
	 */
	@Override
	@Transactional
	public int save(Company index){
		return getCompanyDao().save(index);
	}

	/** (non-Javadoc)
	 * @throws Exception 
	 * @see `CompanyServiceImpl{@link #update(Company)}
	 */
	@Override
	@Transactional
	public void delete(Company index) {
		getCompanyDao().delete(index);		
	}

/**
 * @throws Exception 
 * @see `CompanyServiceImpl{@link #update(Company)}
 */
	@Override
	@Transactional
	public void update(Company index){
		getCompanyDao().update(index);
		
	}
	@Override
	protected void finalize() throws Throwable {
		
		super.finalize();
	}

}
