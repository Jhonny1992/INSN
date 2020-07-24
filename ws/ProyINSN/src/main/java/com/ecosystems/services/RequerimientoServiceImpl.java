package com.ecosystems.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.RequerimientoDAO;
import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;

@Service
public class RequerimientoServiceImpl implements RequerimientoService{

	@Autowired
	private RequerimientoDAO dao;

	@Override
	public RequerimientoBean agregar(RequerimientoBean bean, List<DetalleRequerimientoBean> listaDet) {
		return dao.agregar(bean, listaDet);
	}

	@Override
	public List<RequerimientoBean> buscar(int estado, Date fechaDesde, Date fechaHasta) {
		return dao.buscar(estado, fechaDesde, fechaHasta);
	}

	@Override
	public RequerimientoBean actualizar(int codRequerimiento, Date fechaEntrega, int estado, String observacion) {
		return dao.actualizar(codRequerimiento, fechaEntrega, estado, observacion);
	}

	@Override
	public RequerimientoBean obtenerPorId(int codRequerimiento) {
		return dao.obtenerPorId(codRequerimiento);
	}	
}
