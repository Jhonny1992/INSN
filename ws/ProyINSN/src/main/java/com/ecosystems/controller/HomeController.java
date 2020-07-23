package com.ecosystems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		
		sesion.invalidate();
		
		return "home";
	}
}
