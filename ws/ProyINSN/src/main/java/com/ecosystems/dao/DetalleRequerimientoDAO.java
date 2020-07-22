package com.ecosystems.dao;

import java.util.List;

import com.ecosystems.entity.DetalleRequerimientoBean;

public interface DetalleRequerimientoDAO {

	public List<DetalleRequerimientoBean> buscar(int codRequerimiento);
	public DetalleRequerimientoBean agregar(DetalleRequerimientoBean bean);
}
