package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.entity.DetalleRequerimientoBean;

@Service
public class DetalleRequerimientoServiceImpl implements DetalleRequerimientoService {

	@Autowired
	private DetalleRequerimientoService detalleRequerimientoService;
	
	@Override
	public List<DetalleRequerimientoBean> buscar(int codRequerimiento) {
		return detalleRequerimientoService.buscar(codRequerimiento);
	}

	@Override
	public DetalleRequerimientoBean agregar(DetalleRequerimientoBean bean) {
		return detalleRequerimientoService.agregar(bean);
	}

}
