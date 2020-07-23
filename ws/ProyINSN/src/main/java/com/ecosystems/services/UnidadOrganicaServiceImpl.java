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
	private UnidadOrganicaDAO dao;
	
	
	@Override
	public UnidadOrganicaBean agregar(UnidadOrganicaBean bean) {
		return dao.agregar(bean);
	}

	@Override
	public UnidadOrganicaBean actualizar(UnidadOrganicaBean bean) {
		return dao.actualizar(bean);
	}

	@Override
	public List<UnidadOrganicaBean> buscar(String nombre) {
		return dao.buscar(nombre);
	}

	@Override
	public UnidadOrganicaBean obtenerPorId(int id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}

	@Override
	public List<UsuarioBean> posiblesJefesUnidadOrganica(int codUsuarioEdit) {
		return dao.posiblesJefesUnidadOrganica(codUsuarioEdit);
	}

	@Override
	public UnidadOrganicaBean obtenerPorJefeId(int codUsuario) {
		return dao.obtenerPorJefeId(codUsuario);
	}
}
