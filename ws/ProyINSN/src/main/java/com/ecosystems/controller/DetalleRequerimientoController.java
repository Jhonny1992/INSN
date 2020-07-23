package com.ecosystems.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;
import com.ecosystems.services.DetalleRequerimientoService;

@Controller
@RequestMapping("/detalle")
public class DetalleRequerimientoController {
	
	@Autowired
	private DetalleRequerimientoService detalleRequerimientoService;
	
	@RequestMapping(value= "/" , method = RequestMethod.GET)
	public String index() {
		return "detalleRequerimiento";
	}
	
	@RequestMapping(value = "/buscarRequerimiento", method = RequestMethod.GET)
	@ResponseBody
	public List<DetalleRequerimientoBean> buscarRequerimiento(@RequestParam("requerimiento") int codRequerimiento) {
		return detalleRequerimientoService.buscar(codRequerimiento);
	}
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	@ResponseBody
	public DetalleRequerimientoBean agregar(@RequestParam("codDetalleRequerimiento") int codDetalleRequerimiento,
								  @RequestParam("requerimiento") int codRequerimiento,
								  @RequestParam("bien") int codBien,
								  @RequestParam("cantidad") int cantidad
								  
								  ) {
		DetalleRequerimientoBean bean = new DetalleRequerimientoBean();
		
		RequerimientoBean requerimiento = new RequerimientoBean();
		requerimiento.setCodRequerimiento(codRequerimiento);
		
		BienBean bien = new BienBean();
		bien.setCodBien(codBien);
		
		bean.setCodDetalleRequerimiento(codDetalleRequerimiento);
		bean.setRequerimiento(requerimiento);
		bean.setBien(bien);
		bean.setCantidad(cantidad);
		
		
		return detalleRequerimientoService.agregar(bean);
	}
	
	

}
