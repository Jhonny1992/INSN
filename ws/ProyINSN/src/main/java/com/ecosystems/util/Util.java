package com.ecosystems.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import com.ecosystems.entity.UsuarioBean;

public class Util {
	public static UsuarioBean getUsuario(HttpSession sesion) {
		return (UsuarioBean) sesion.getAttribute("usuario");
	}
	
	public static String fechaToString(java.util.Date fecha, String patron) {
		DateFormat formato = new SimpleDateFormat(patron);
		return formato.format(fecha);
	}
	
	public static java.sql.Date ConvertJavaDateToSqlDate(java.util.Date fecha) {
		return new java.sql.Date(fecha.getTime());
	}
	
	public static java.util.Date ConvertSqlDateToJavaDate(java.sql.Date fecha) {
		return new java.util.Date(fecha.getTime());
	}
}
