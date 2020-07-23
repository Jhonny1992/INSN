package com.ecosystems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.UnidadOrganicaService;
import com.ecosystems.util.Util;

@Controller
@RequestMapping(value = "/gestion")

public class GestionRequerimientoController {
	private @Autowired UnidadOrganicaService unidadOrganicaService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "gestionrequerimiento";
	}
	
	@RequestMapping(value="/unidadOrgánicaXUsuario")
	@ResponseBody
	public UnidadOrganicaBean listarUsuario(HttpSession sesion){
		UsuarioBean usu = Util.getUsuario(sesion);
		
		UnidadOrganicaBean unidadOrganica = unidadOrganicaService.obtenerPorJefeId(usu.getCodUsuario());
		
		return unidadOrganica;
	}
}
