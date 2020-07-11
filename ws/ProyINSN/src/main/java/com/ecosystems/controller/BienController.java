package com.ecosystems.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
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

	@RequestMapping(value = "/lista")
	public String lista(Model model) {
		List<BienBean> lista = bienService.list();
		model.addAttribute("bienes", lista);
		return "listabien";
	}

	@RequestMapping(value = "/listAllBien")
	@ResponseBody
	public List<BienBean> listAllReferencias() {
		List<BienBean> lista = bienService.list();
		return lista;
	}

	@RequestMapping(value = "/findID")
	@ResponseBody
	public BienBean findID(@RequestParam("idBien") int id) {
		BienBean bean;
		bean = bienService.obtenerPorId(id);
		return bean;
	}
	
	@RequestMapping(value = "/deleteBien")
	public String deleteBien(@RequestParam("codigo") int id, Model m) {
		bienService.eliminar(id);
		m.addAttribute("MENSAJE", "Registro eliminado correctamente");
		return "listabien";
		} 
	
	@RequestMapping("/buscarXFecha")
	@ResponseBody
	public List<BienBean> buscarXFecha(@RequestParam("fechaInicio") Date fechaInicio,
										@RequestParam("fechaFin") Date fechaFin){
		List<BienBean> lista=bienService.buscarXFecha(fechaInicio, fechaFin);
		return lista;
	}

}
