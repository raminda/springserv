
package com.millenniumit.mx.data.nethdsizing.service.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.nethdsizing.dao.EquipmentMapingDao;
import com.millenniumit.mx.data.nethdsizing.dao.impl.EquipmentMapingDaoImpl;
import com.millenniumit.mx.data.nethdsizing.domain.EquipmentMaping;
import com.millenniumit.mx.data.nethdsizing.domain.Equipments;
import com.millenniumit.mx.data.nethdsizing.domain.ItemTypes;
import com.millenniumit.mx.data.nethdsizing.service.EquipmentMapingService;

/**
 * 
 * @author Raminda
 *
 */
@Service("EquipmentMapingService")
public class  EquipmentMapingServiceImpl implements  EquipmentMapingService {


@Autowired
@Qualifier("EquipmentMapingDao")
	private EquipmentMapingDao equipmentMapingDao;

	protected EquipmentMapingServiceImpl() {
	}

	/**
	 * @return the EquipmentsBulkDeo
	 */
	public EquipmentMapingDao getEquipmentsMapingDao() {
		return equipmentMapingDao;
	}

	/**
	 * @param EquipmentsBulkDeo the EquipmentsBulkDeo to set
	 */
	public void setEquipmentsMapingDao(EquipmentMapingDao EquipmentsMapingDao) {
		this.equipmentMapingDao = EquipmentsMapingDao;
	}
	public EquipmentMapingServiceImpl (SessionFactory SessionFactory){
		equipmentMapingDao=new EquipmentMapingDaoImpl();
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk(java.lang.Long)
	 */
	@Override
	@Transactional
	public EquipmentMaping getEquipmentMapings(int ID) {
		return getEquipmentsMapingDao().get(ID);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk(java.lang.String)
	 */
	@Override
	@Transactional
	public  List<EquipmentMaping> getEquipmentMapings(Equipments EquipmentID,ItemTypes itemType) {
		return getEquipmentsMapingDao().getAll(EquipmentID,itemType);
	}

	@Override
	@Transactional
	public  List<EquipmentMaping> getEquipmentMapings(Equipments PerantID,Equipments ChildID) {
		return getEquipmentsMapingDao().getAll(PerantID,ChildID);
	}
	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#getEquipmentsBulk()
	 */
	@Override
	@Transactional
	public List<EquipmentMaping> getEquipmentMapings() {
		return getEquipmentsMapingDao().getAll();
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.ITICService#getKpiIndexes(int, int)
	 */
	@Override
	@Transactional
	public List <EquipmentMaping> getEquipmentMapings(int start, int limit) {
		return getEquipmentsMapingDao().getAll(start, limit);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#saveEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.EquipmentsBulk)
	 */
	@Override
	@Transactional
	public int save(EquipmentMaping index) {
		return getEquipmentsMapingDao().save(index);
	}

	/** (non-Javadoc)
	 * @see com.millenniumit.mx.data.ITIC.service.EquipmentMapingServiceImpl#deleteEquipmentsBulk(com.millenniumit.mx.data.ITIC.domain.EquipmentsBulk)
	 */
	@Override
	@Transactional
	public void delete(EquipmentMaping index) {
		getEquipmentsMapingDao().delete(index);		
	}

	/* (non-Javadoc)
	 * @see com.millenniumit.mx.data.itic.service.EquipmentMapingService#update(com.millenniumit.mx.data.itic.domain.EquipmentMaping)
	 */
	@Override
	@Transactional
	public void update(EquipmentMaping index) {
		getEquipmentsMapingDao().update(index);
		
	}

}
