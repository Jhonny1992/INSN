package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.UnidadOrganicaDAO;
import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;

@Service
public class UnidadOrganicaServiceImpl implements UnidadOrganicaService{

	@Autowired
	private UnidadOrganicaDAO unidadorganicaDAO;
	
	
	@Override
	public UnidadOrganicaBean agregar(UnidadOrganicaBean bean) {
		return unidadorganicaDAO.agregar(bean);
	}

	@Override
	public UnidadOrganicaBean actualizar(UnidadOrganicaBean bean) {
		return unidadorganicaDAO.actualizar(bean);
	}

	@Override
	public List<UnidadOrganicaBean> buscar(String nombre) {
		return unidadorganicaDAO.buscar(nombre);
	}

	@Override
	public UnidadOrganicaBean obtenerPorId(int id) {
		return unidadorganicaDAO.obtenerPorId(id);
	}

	@Override
	public void eliminar(int id) {
		unidadorganicaDAO.eliminar(id);
	}

	@Override
	public List<UsuarioBean> posiblesJefesUnidadOrganica(int codUsuarioEdit) {
		return unidadorganicaDAO.posiblesJefesUnidadOrganica(codUsuarioEdit);
	}
}
