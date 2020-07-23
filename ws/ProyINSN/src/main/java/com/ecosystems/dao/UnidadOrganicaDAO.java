package com.ecosystems.dao;

import java.util.List;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;

public interface UnidadOrganicaDAO {
	
	public UnidadOrganicaBean agregar(UnidadOrganicaBean bean);
	public UnidadOrganicaBean actualizar(UnidadOrganicaBean bean);
	public List<UnidadOrganicaBean> buscar(String nombre);
	public UnidadOrganicaBean obtenerPorId(int id);
	public void eliminar(int id);
	
	public List<UsuarioBean> posiblesJefesUnidadOrganica(int codUsuarioEdit);
	public UnidadOrganicaBean obtenerPorJefeId(int codUsuario);
}
