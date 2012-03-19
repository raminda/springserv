package com.millenniumit.mx.data.relman.service;

import java.util.List;

import com.millenniumit.mx.data.relman.domain.RelmanCurrentReleaseInfo;

public interface RelmanCurrentReleaseInfoService {
	public List<RelmanCurrentReleaseInfo> getCurrentReleaseInfo();	
	public void saveCurrentReleaseInfo(RelmanCurrentReleaseInfo info);	
}