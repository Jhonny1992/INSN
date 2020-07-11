package com.ecosystems.services;

import java.util.Date;
import java.util.List;

import com.ecosystems.entity.BienBean;

public interface BienService {
	public BienBean agregar(BienBean bean);
	public BienBean actualizar(BienBean bean);
	public BienBean obtenerPorId(int id);
	public void eliminar(int id);
	public List<BienBean> list();
	public List<BienBean> buscarXFecha(Date fecha1, Date fecha2);

}
