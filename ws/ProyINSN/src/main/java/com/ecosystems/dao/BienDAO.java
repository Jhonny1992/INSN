package com.ecosystems.dao;


import java.util.Date;
import java.util.List;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.UsuarioBean;


public interface BienDAO {
	public BienBean agregar(BienBean bean);
	public BienBean actualizar(BienBean bean);
	public BienBean obtenerPorId(int id);
	public void eliminar(int id);
	public List<BienBean> list();
	public List<BienBean> buscarXFecha(Date fecha1, Date fecha2);

}
