package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.services.UnidadOrganicaService;

@Controller
@RequestMapping("/unidadorganica")
public class UnidadOrganicaController {

	@Autowired
	private UnidadOrganicaService unidadorganicaService;
	
	@RequestMapping("/")
	private String index() {
		return "unidadorganica";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	private List<UnidadOrganicaBean> buscar(@RequestParam(name="nombre") String nombre){
		return unidadorganicaService.buscar(nombre);
	}
}
