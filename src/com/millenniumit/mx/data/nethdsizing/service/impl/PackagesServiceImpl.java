package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.dao.PackagesDao;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.service.PackagesService;

/**
 * 
 * @author Raminda
 *
 */
@Service("PackagesService")
public class PackagesServiceImpl implements PackagesService {

@Autowired
@Qualifier("PackagesDao")
	private PackagesDao PackagesDao;

public PackagesServiceImpl() {
	}

	/**
	 * @return the PackagesDeo
	 */
	public PackagesDao getPackagesDao() {
		return PackagesDao;
	}

	/**
	 * @param PackagesDeo the PackagesDeo to set
	 */
	public void setPackagesDao(PackagesDao PackagesDao) {
		this.PackagesDao = PackagesDao;
	}
	/**
	 * 
	 */
	@Override
	@Transactional
	public Packages getPackagess(int ID) {
		return getPackagesDao().get(ID);
	}

	@Override
	@Transactional
	public Packages getPackages(String Packages) {
		return getPackagesDao().get(Packages);
	}

	@Override
	@Transactional
	public List<Packages> getPackages() {
		return getPackagesDao().getAll();
	}

	@Override
	@Transactional
	public List<Packages> getPackages(int start, int limit) {
		return getPackagesDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.SiteTypeService#deleteSiteType(com.millenniumit.mx.data.ITIC.domain.SiteType)
	 */

	@Override
	@Transactional
	public List<Packages> getAll(Date date, int Type) {
		return getPackagesDao().getAll(date, Type);
	}

	@Override
	@Transactional
	public List<Packages> getAll(Date date1, Date date2) {
		return getPackagesDao().getAll(date1, date2);
	}
	
	@Override
	@Transactional
	public int save(Packages index) {
		return getPackagesDao().save(index);
	}

	@Override
	@Transactional
	public void delete(Packages index) {
		getPackagesDao().delete(index);
		
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.PackagesService#update(com.millenniumit.mx.data.itic.domain.Packages)
	 */
	@Override
	@Transactional
	public void update(Packages index) {
		getPackagesDao().update(index);
		
	}



}
