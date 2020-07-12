package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.UsuarioDAO;
import com.ecosystems.entity.UsuarioBean;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public UsuarioBean agregar(UsuarioBean bean) {
		return dao.agregar(bean);
	}

	@Override
	public UsuarioBean actualizar(UsuarioBean bean) {
		return dao.actualizar(bean);
	}

	@Override
	public List<UsuarioBean> buscar(String nombres, String apellidos) {
		return dao.buscar(nombres, apellidos);
	}

	@Override
	public UsuarioBean obtenerPorId(int id) {
		return dao.obtenerPorId(id);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}

	@Override
	public List<UsuarioBean> listarUsuario() {
		return dao.listarUsuario();
	}
}
