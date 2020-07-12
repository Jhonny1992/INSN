package com.ecosystems.dao;

import java.util.List;
import com.ecosystems.entity.BienBean;



public interface BienDAO {
	public BienBean agregar(BienBean bean);
	public BienBean actualizar(BienBean bean);
	public List<BienBean> buscar(String nombre);
	public BienBean obtenerPorId(int id);
	public void eliminar(int id);

}
