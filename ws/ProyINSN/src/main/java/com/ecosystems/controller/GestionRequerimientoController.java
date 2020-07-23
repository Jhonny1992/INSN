package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
import com.ecosystems.services.BienService;

@Controller
@RequestMapping(value = "/gestion")

public class GestionRequerimientoController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "gestionrequerimiento";
	}
	
	
}
