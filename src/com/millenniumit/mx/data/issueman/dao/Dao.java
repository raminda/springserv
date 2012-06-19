/**
 * 
 */
package com.millenniumit.mx.data.issueman.dao;

import java.util.List;

/**
 * @author Vimukthi
 *
 */
public interface Dao<T> {
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T get(Long id);
	
	/**
	 * 
	 * @return
	 */
	public List<T> getAll();
	
	/**
	 * 
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<T> getAll(int start, int limit);
	
	/**
	 * 
	 * @param object
	 * @return
	 */
	public Long save(T object);
	
	/**
	 * 
	 * @param object
	 */
	public void delete(T object);
}
