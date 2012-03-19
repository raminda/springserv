package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.millenniumit.mx.data.relman.dao.RelmanCurrentCodeItemFileDao;
import com.millenniumit.mx.data.relman.domain.RelmanCurrentCodeItemFile;
import com.millenniumit.mx.data.relman.service.RelmanCurrentCodeItemFileService;




@Service("relmanCurrentCodeItemFileService")
public class RelmanCurrentCodeItemFileServiceImpl implements RelmanCurrentCodeItemFileService {

	@Autowired
	@Qualifier("relmanCurrentCodeItemFileDao")
	private  RelmanCurrentCodeItemFileDao currentcodeitemfiledao;
	

	public RelmanCurrentCodeItemFileDao getCurrentcodeitemfiledao() {
		return currentcodeitemfiledao;
	}

	public void setCurrentcodeitemfiledao(
			RelmanCurrentCodeItemFileDao currentcodeitemfiledao) {
		this.currentcodeitemfiledao = currentcodeitemfiledao;
	}


	@Transactional
	public List<RelmanCurrentCodeItemFile> getRelmanCurrentCodeItemFiles() {
				return currentcodeitemfiledao.getRelmanCurrentCodeItemFiles();
	}

}