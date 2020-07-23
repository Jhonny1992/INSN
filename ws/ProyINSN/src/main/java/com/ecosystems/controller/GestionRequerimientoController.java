package com.ecosystems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
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
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/agregarBienTemp", method = RequestMethod.POST)
	@ResponseBody
	public List<BienBean> agregarBienTemp(HttpServletRequest request) {
		
		String cb = request.getParameter("codBien");
		
		List<BienBean> lista;
		Object obj = request.getSession().getAttribute("ListaBienesTemp");
		if (obj == null) {
			lista = new ArrayList<BienBean>();
		}
		else {
			lista = (List<BienBean>)obj;
		}
		
		BienBean bien = new BienBean();
		//bien.setCodBien(codBien);
		lista.add(bien);

		return lista;
	}

}
