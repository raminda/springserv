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
	 * @param int ID
	 * @return
	 */
	@Override
	public Company get(int ID);

	/**
	 * 
	 * @return List<Company>
	 */
	@Override
	public List<Company> getAll();
	
	/**
	 * 
	 * @return  List<String>
	 */
	public List<String> getAllNames();
	
	/**
	 * @param String CompanyName
	 * @return
	 */
	public Company get(String CompanyName);
	
	/**
	 * @param Start,Limit
	 * @return List<Company>
	 */
	@Override
	public List<Company> getAll(int start, int limit);
	
	/**
	 * @param String CompanyName
	 * @return  List<Company>
	 */
	public List<Company> getAll(String CompanyName);
	/**
	 * 
	 * @param object
	 * @return Company object
	 * @throws Exception 
	 */
	@Override
	public int save(Company object);
	
	/**
	 * 
	 * @param Company object
	 * @throws Exception
	 */
	@Override
	public void delete(Company object);
	
	/**
	 * 
	 * @param Company object
	 * @throws Exception
	 */
	@Override
	public void update(Company object);

	
}
