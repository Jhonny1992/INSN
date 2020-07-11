package com.ecosystems.services;

import java.util.List;

import com.ecosystems.entity.UnidadOrganicaBean;

public interface UnidadOrganicaService {
	
	public UnidadOrganicaBean agregar(UnidadOrganicaBean bean);
	public UnidadOrganicaBean actualizar(UnidadOrganicaBean bean);
	public List<UnidadOrganicaBean> buscar(String nombre);
	public UnidadOrganicaBean obtenerPorId(int id);
	public void eliminar(int id);

}
