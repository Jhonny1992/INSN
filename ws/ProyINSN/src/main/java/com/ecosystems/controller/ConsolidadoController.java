package com.ecosystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/consolidado")
public class ConsolidadoController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "consolidadorequerimientos";
	}
}
