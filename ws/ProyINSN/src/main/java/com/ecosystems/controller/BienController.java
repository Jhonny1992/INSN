package com.ecosystems.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.BienService;

@Controller
@RequestMapping(value = "/bien")
public class BienController {

	@Autowired
	private BienService bienService;

	@RequestMapping("/")
	public String index() {
		return "bien";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public List<BienBean> buscar(@RequestParam("nombre") String nombre) {
		return bienService.buscar(nombre);
	}
	
	@RequestMapping("/obtener")
	@ResponseBody
	public BienBean obtenerPorId(@RequestParam("id") int id) {
		return bienService.obtenerPorId(id);
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.POST)
	@ResponseBody
	public BienBean actualizar(@RequestParam("codBien") int codBien,
								  @RequestParam("nombre") String nombre,
								  @RequestParam("descripcion") String descripcion,
								  @RequestParam("tipo") int tipo) {
		BienBean bean = new BienBean();
		bean.setCodBien(codBien);
		bean.setNombre(nombre);
		bean.setDescripcion(descripcion);
		bean.setTipo(tipo);
		
		return bienService.actualizar(bean);
	}
	

}
