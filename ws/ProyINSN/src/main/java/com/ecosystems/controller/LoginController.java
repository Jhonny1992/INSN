package com.ecosystems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/auth")
	public String autenticar(HttpSession sesion) {
		sesion.setAttribute("user", "Edinson");
		
		int segundos = 5;
		sesion.setMaxInactiveInterval(segundos);
		
		return "home";
	}
}
