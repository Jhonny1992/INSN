package com.ecosystems.util;

import javax.servlet.http.HttpSession;

import com.ecosystems.entity.UsuarioBean;

public class Util {
	public static UsuarioBean getUsuario(HttpSession sesion) {
		return (UsuarioBean) sesion.getAttribute("usuario");
	}
}
