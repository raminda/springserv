package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanCurrentReleaseInfoDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentReleaseInfo;
import com.millenniumit.mx.data.relman.service.RelmanCurrentReleaseInfoService;

/**
 * 
 * @author Vimukthi <vimukthi@millenniumit.com>
 * 
 */
@Service("relmanCurrentReleaseInfoService")
public class RelmanCurrentReleaseInfoServiceImpl implements
		RelmanCurrentReleaseInfoService {

	@Autowired
	@Qualifier("relmanCurrentReleaseInfoDao")
	private RelmanCurrentReleaseInfoDao currentRelinfoDao;
	
	/**
	 * @return the currentRelinfoDao
	 */
	public RelmanCurrentReleaseInfoDao getCurrentRelinfoDao() {
		return currentRelinfoDao;
	}

	/**
	 * @param currentRelinfoDao the currentRelinfoDao to set
	 */
	public void setCurrentRelinfoDao(RelmanCurrentReleaseInfoDao currentRelinfoDao) {
		this.currentRelinfoDao = currentRelinfoDao;
	}
	
	@Override
	@Transactional
	public List<RelmanCurrentReleaseInfo> getCurrentReleaseInfo() {
		return currentRelinfoDao.getCurrentReleaseInfo();
	}

	@Override
	@Transactional
	public void saveCurrentReleaseInfo(RelmanCurrentReleaseInfo info) {
		currentRelinfoDao.saveCurrentReleaseInfo(info);
	}
}
