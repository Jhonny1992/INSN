package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.DetalleRequerimientoDAO;
import com.ecosystems.entity.DetalleRequerimientoBean;

@Service
public class DetalleRequerimientoServiceImpl implements DetalleRequerimientoService {

	@Autowired
	private DetalleRequerimientoDAO dao;
	
	@Override
	public List<DetalleRequerimientoBean> buscar(int codRequerimiento) {
		return dao.buscar(codRequerimiento);
	}

	@Override
	public DetalleRequerimientoBean agregar(DetalleRequerimientoBean bean) {
		return dao.agregar(bean);
	}
}
