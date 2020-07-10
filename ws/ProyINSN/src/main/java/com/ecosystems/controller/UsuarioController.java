package com.ecosystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@RequestMapping("/")
	public String index() {
		return "usuario";
	}
}
