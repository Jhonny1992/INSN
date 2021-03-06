package com.ecosystems.services;

import java.util.Date;
import java.util.List;

import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;

public interface RequerimientoService {
	public RequerimientoBean agregar(RequerimientoBean bean, List<DetalleRequerimientoBean> listaDet);
	public List<RequerimientoBean> buscar(int estado, Date fechaDesde, Date fechaHasta);
	public RequerimientoBean actualizar(int codRequerimiento, Date fechaEntrega, int estado, String observacion);
	public RequerimientoBean obtenerPorId(int codRequerimiento);
}
