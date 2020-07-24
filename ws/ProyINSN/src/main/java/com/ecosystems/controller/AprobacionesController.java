package com.ecosystems.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.RequerimientoBean;
import com.ecosystems.services.RequerimientoService;
import com.ecosystems.util.Util;

@Controller
@RequestMapping(value = "/aprobaciones")
public class AprobacionesController {
	
	private @Autowired RequerimientoService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "aprobaciones";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	private List<RequerimientoBean> buscar(@RequestParam(name = "estado") int estado,
										    @RequestParam(name = "desde") String desde,
										    @RequestParam(name = "hasta") String hasta) throws ParseException {
		Date dDesde = Util.StringToFecha(desde, "yyyy-MM-dd");
		Date dHasta = Util.StringToFecha(hasta, "yyyy-MM-dd");
		
		return service.buscar(estado, dDesde, dHasta);
	}
}
