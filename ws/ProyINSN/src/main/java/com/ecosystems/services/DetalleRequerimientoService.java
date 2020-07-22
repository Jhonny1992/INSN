package com.ecosystems.services;

import java.util.List;

import com.ecosystems.entity.DetalleRequerimientoBean;

public interface DetalleRequerimientoService {

	public List<DetalleRequerimientoBean> buscar(int codRequerimiento);
	public DetalleRequerimientoBean agregar(DetalleRequerimientoBean bean);
}
