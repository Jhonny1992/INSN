package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.CargoBean;
import com.ecosystems.services.CargoService;

@Controller
@RequestMapping(value = "/cargo")
public class CargoController {
	private @Autowired CargoService service;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public List<CargoBean> listar() {
		return service.listar();
	}
}
