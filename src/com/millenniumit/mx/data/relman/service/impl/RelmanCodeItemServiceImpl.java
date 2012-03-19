package com.millenniumit.mx.data.relman.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.millenniumit.mx.data.relman.dao.RelmanCodeItemDao;
import com.millenniumit.mx.data.relman.domain.RelmanCodeItem;
import com.millenniumit.mx.data.relman.service.RelmanCodeItemService;

@Service("relmanCodeItemService")
public class RelmanCodeItemServiceImpl implements RelmanCodeItemService {

	@Autowired
	@Qualifier("relmanCodeItemDao")
	private RelmanCodeItemDao codeitemdao;

	public RelmanCodeItemDao getCodeitemdao() {
		return codeitemdao;
	}

	public void setCodeitemdao(RelmanCodeItemDao codeitemdao) {
		this.codeitemdao = codeitemdao;
	}

	@Override
	@Transactional
	public List<RelmanCodeItem> getRelmanCodeItems() {
		return codeitemdao.getRelmanCodeItems();
	}

	@Override
	@Transactional
	public RelmanCodeItem getRelmanCodeItem(String relmanId) {
		return codeitemdao.getRelmanCodeItem(relmanId);
	}

	@Override
	@Transactional
	public RelmanCodeItem getRelmanCodeItem(Long id) {
		return codeitemdao.getRelmanCodeItem(id);
	}

}