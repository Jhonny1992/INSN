package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	@RequestMapping("/")
	public String index() {
		return "usuario";
	}
	
	
	@RequestMapping("/buscar")
	@ResponseBody
	public List<UsuarioBean> buscar(@RequestParam("nombres") String nombres,
									@RequestParam("apellidos") String apellidos) {
		return service.buscar(nombres, apellidos);
	}
}
