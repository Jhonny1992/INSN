package com.ecosystems.dao;

import java.util.List;

import com.ecosystems.entity.UsuarioBean;

public interface UsuarioDAO {
	public UsuarioBean agregar(UsuarioBean bean);
	public UsuarioBean actualizar(UsuarioBean bean);
	public List<UsuarioBean> buscar(String nombres, String apellidos);
	public UsuarioBean obtenerPorId(int id);
	public void eliminar(int id);
	public List<UsuarioBean> listarUsuario();
}
