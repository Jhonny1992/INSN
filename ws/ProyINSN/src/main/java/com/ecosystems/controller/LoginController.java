package com.ecosystems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.UsuarioService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired UsuarioService service;
	
	@RequestMapping("/")
	public String index(HttpSession sesion) {
		sesion.invalidate();
		
		return "login";
	}
	
	@RequestMapping("/auth")
	public String autenticar(HttpServletRequest request,
							@RequestParam(name = "usuario") String usuario,
							@RequestParam(name = "clave") String clave) {
		
		UsuarioBean u = service.autenticar(usuario, clave);
		
		if (u == null) {
			System.out.println("No existe, credenciales incorrectas");
			return "login";
		}
		
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("usuario", u);
		
		int segundos = 6000;
		sesion.setMaxInactiveInterval(segundos);
		
		return "home";
	}
}
