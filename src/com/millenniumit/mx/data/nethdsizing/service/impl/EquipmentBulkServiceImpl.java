package com.millenniumit.mx.data.nethdsizing.service.impl;

/*public class EquipmentsBulkServiceImpl {

}
*/

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentBulk;
import com.millenniumit.mx.data.nethdsizing.domain.Packages;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentsBulkService;
import com.millenniumit.mx.data.nethdsizing.dao.EquipmentbulkDao;

/**
 * 
 * @author Raminda
 *
 */
@Service("EquipmentsBulkService")
public class  EquipmentBulkServiceImpl implements  EquipmentsBulkService {

@Autowired
@Qualifier("EquipmentbulkDao")
private EquipmentbulkDao EquipmentsBulkDao;

	/**
	 * @return the EquipmentsBulkDeo
	 */
	public EquipmentbulkDao getEquipmentsBulkDao() {
		return EquipmentsBulkDao;
	}
	/**
	 * @param EquipmentsBulkDeo the EquipmentsBulkDeo to set
	 */
	public void setEquipmentsBulkDao(EquipmentbulkDao EquipmentsBulkDao) {
		this.EquipmentsBulkDao = EquipmentsBulkDao;
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk(java.lang.Long)
	 */
	@Override
	@Transactional
	public EquipmentBulk getEquipmentsBulks(int id) {
		return getEquipmentsBulkDao().get(id);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk(java.lang.String)
	 */
	@Override
	@Transactional
	public  List<EquipmentBulk> getEquipmentsBulk(Equipments EquipmentID) {
		return getEquipmentsBulkDao().getAll(EquipmentID);
	}

	@Override
	@Transactional
	public  List<EquipmentBulk> getPackageBulk(Packages PackageID) {
		return getEquipmentsBulkDao().getAll(PackageID);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#getEquipmentsBulk()
	 */
	@Override
	@Transactional
	public List<EquipmentBulk> getEquipmentsBulk() {
		return getEquipmentsBulkDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	@Transactional
	public List <EquipmentBulk> getEquipmentsBulk(int start, int limit) {
		return getEquipmentsBulkDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#saveEquipmentsBulk(com.millenniumit.mx.data.EquipmentBulk.domain.EquipmentsBulk)
	 */
	@Override
	@Transactional
	public int save(EquipmentBulk index) {
		return getEquipmentsBulkDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentsBulkService#deleteEquipmentsBulk(com.millenniumit.mx.data.EquipmentBulk.domain.EquipmentsBulk)
	 */
	@Override
	@Transactional
	public void delete(EquipmentBulk index) {
		getEquipmentsBulkDao().delete(index);		
	}

	@Override
	@Transactional
	public EquipmentBulk EquipmentsBulkget(Packages PackageID,Equipments ItemId) {
		return getEquipmentsBulkDao().get(PackageID, ItemId);
	}
	@Override
	@Transactional
	public List<EquipmentBulk> EquipmentsBulkgetD(Packages PackageID,Equipments ItemId) {
		return getEquipmentsBulkDao().getD(PackageID, ItemId);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.EquipmentsBulkService#update(com.millenniumit.mx.data.itic.domain.EquipmentsBulk)
	 */
	@Override
	@Transactional
	public void update(EquipmentBulk index) {
		getEquipmentsBulkDao().update(index);
		
	}

}
