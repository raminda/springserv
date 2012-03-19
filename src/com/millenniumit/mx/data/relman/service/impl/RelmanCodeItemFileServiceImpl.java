package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanCodeItemFileDao;
import com.millenniumit.mx.data.relman.domain.RelmanCodeItemFile;
import com.millenniumit.mx.data.relman.service.RelmanCodeItemFileService;

@Service("relmanCodeItemFileService")
public class RelmanCodeItemFileServiceImpl implements RelmanCodeItemFileService {

	@Autowired
	@Qualifier("relmanCodeItemFileDao")
	private  RelmanCodeItemFileDao codeitemfiledao;
	

	public RelmanCodeItemFileDao getCodeitemfiledao() {
		return codeitemfiledao;
	}


	public void setCodeitemfiledao(RelmanCodeItemFileDao codeitemfiledao) {
		this.codeitemfiledao = codeitemfiledao;
	}

	@Override
	@Transactional
	public List<RelmanCodeItemFile> getRelmanCodeItemFiles() {
		return codeitemfiledao.getRelmanCodeItemFiles();
	}


	@Override
	@Transactional
	public RelmanCodeItemFile getRelmanCodeItemFile(Long id) {
		return codeitemfiledao.getRelmanCodeItemFile(id);
	}


//	@Override
//	@Transactional
//	public List<?> getLowestAssociationLevelObjects(Object criteria) {
//		return codeitemfiledao.getRelmanCodeItemFiles();
//	}

}