/*
public class EuipmentMapingDao {

}
*/
package com.millenniumit.mx.data.nethdsizing.dao;


import java.util.List;

import com.millenniumit.mx.data.nethdsizing.domain.Company;
/**
 * 
 * @author DECANS <draminda@gmail.com>
 * @category interface for company Access 
 *
 */
public interface  CompanyDao extends Dao <Company> {
								
/* Methods For  implementation in Imp. class   */
	
	/**
	 * 
	 * @param ID
	 * @return
	 */
	@Override
	public Company get(int ID);

	/**
	 * 
	 * @return
	 */
	@Override
	public List<Company> getAll();
	
	/**
	 * @param CompanyName
	 * @return
	 */
	public Company get(String CompanyName);
	
	/**
	 * @param Start,Limit
	 * @return
	 */
	@Override
	public List<Company> getAll(int start, int limit);
	
	/**
	 * @param object
	 * @return 
	 */
	public List<Company> getAll(String CompanyName);
	/**
	 * 
	 * @param object
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int save(Company object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void delete(Company object);
	
	/**
	 * 
	 * @param object
	 */
	@Override
	public void update(Company object);

	
}
