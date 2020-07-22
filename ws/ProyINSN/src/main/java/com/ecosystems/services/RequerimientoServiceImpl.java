package com.ecosystems.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.RequerimientoDAO;
import com.ecosystems.entity.RequerimientoBean;

@Service
public class RequerimientoServiceImpl implements RequerimientoService{

	@Autowired
	private RequerimientoDAO requerimientoDAO;

	@Override
	public RequerimientoBean agregar(RequerimientoBean bean) {
		return requerimientoDAO.agregar(bean);
	}

	@Override
	public List<RequerimientoBean> buscar(int codUnidad, Date fechamin, Date fechamax) {

		return requerimientoDAO.buscar(codUnidad, fechamin, fechamax);
	}

	
}
