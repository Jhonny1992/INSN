package com.ecosystems.services;

import java.util.List;

import com.ecosystems.entity.UsuarioBean;

public interface UsuarioService {
	public UsuarioBean agregar(UsuarioBean bean);
	public UsuarioBean actualizar(UsuarioBean bean);
	public List<UsuarioBean> buscar(String nombres, String apellidos);
	public UsuarioBean obtenerPorId(int id);
	public void eliminar(int id);
	public List<UsuarioBean> listarUsuario();
	public UsuarioBean autenticar(String usuario, String clave);
}
