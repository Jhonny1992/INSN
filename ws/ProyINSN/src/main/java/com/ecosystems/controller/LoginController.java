package com.ecosystems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecosystems.entity.UsuarioBean;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@RequestMapping("/")
	public String index() {
		return "login";
	}
	
	@RequestMapping("/auth")
	public String autenticar(HttpSession sesion,HttpServletRequest request) {
		//HttpSession sesion = request.getSession();
		
		UsuarioBean u = new UsuarioBean();
		u.setCodUsuario(1);
		u.setUsername("ealdaz");
		sesion.setAttribute("user", u);
		
		int segundos = 6000;
		sesion.setMaxInactiveInterval(segundos);
		
		return "home";
	}
}
