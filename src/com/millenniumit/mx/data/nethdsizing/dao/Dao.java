package com.millenniumit.mx.data.nethdsizing.dao;

import java.util.List;

/**
 * @author DECANS
 *
 */
public interface Dao<T> {
	
					/* Super class interface*/
	
	/**
	 * @param ID
	 * @return
	 */
	public T get(int id);
	
	/**
	 * @return
	 */
	public List <T> getAll();
	
	/**
	 * @param start
	 * @param limit
	 * @return
	 */
	public List <T> getAll(int start, int limit);
	
	/**
	 * @param object
	 * @return
	 * @throws Exception 
	 */
	
	public int save(T object);
	
	/** 
	 * @param object
	 */
	public void delete(T object);
	
	/** 
	 * @param object
	 */
	public void update(T object);
}
