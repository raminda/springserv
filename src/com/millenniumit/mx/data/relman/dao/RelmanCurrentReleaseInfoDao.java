package com.millenniumit.mx.data.relman.dao;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCurrentReleaseInfo;

public interface RelmanCurrentReleaseInfoDao {
	public List<RelmanCurrentReleaseInfo> getCurrentReleaseInfo();	
	public void saveCurrentReleaseInfo(RelmanCurrentReleaseInfo info);	
}
