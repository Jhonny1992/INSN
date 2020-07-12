package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.CargoBean;
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
	
	@RequestMapping("/obtener")
	@ResponseBody
	public UsuarioBean obtenerPorId(@RequestParam("id") int id) {
		return service.obtenerPorId(id);
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	@ResponseBody
	public UsuarioBean actualizar(@RequestParam("codUsuario") int codUsuario,
								  @RequestParam("nombres") String nombres,
								  @RequestParam("apellidos") String apellidos,
								  @RequestParam("dni") String dni,
								  @RequestParam("username") String username,
								  @RequestParam("clave") String clave,
								  @RequestParam("correo") String correo,
								  @RequestParam("codCargo") int codCargo) {
		
		UsuarioBean bean = new UsuarioBean();
		CargoBean cargo = new CargoBean();
		cargo.setCodCargo(codCargo);
		
		bean.setCodUsuario(codUsuario);
		bean.setNombres(nombres);
		bean.setApellidos(apellidos);
		bean.setNroDocumento(dni);
		bean.setUsername(username);
		bean.setPassword(clave);
		bean.setCorreo(correo);
		bean.setCargo(cargo);
		
		return service.actualizar(bean);
	}
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	@ResponseBody
	public UsuarioBean agregar(@RequestParam("nombres") String nombres,
							   @RequestParam("apellidos") String apellidos,
							   @RequestParam("dni") String dni,
							   @RequestParam("username") String username,
							   @RequestParam("clave") String clave,
						  	   @RequestParam("correo") String correo,
						  	   @RequestParam("codCargo") int codCargo) {
		
		UsuarioBean bean = new UsuarioBean();
		CargoBean cargo = new CargoBean();
		cargo.setCodCargo(codCargo);
		
		bean.setNombres(nombres);
		bean.setApellidos(apellidos);
		bean.setNroDocumento(dni);
		bean.setUsername(username);
		bean.setPassword(clave);
		bean.setCorreo(correo);
		bean.setCargo(cargo);
		
		return service.agregar(bean);
	}
}
