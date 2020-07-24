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

import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;
import com.ecosystems.services.DetalleRequerimientoService;
import com.ecosystems.services.RequerimientoService;
import com.ecosystems.util.Util;

@Controller
@RequestMapping(value = "/aprobaciones")
public class AprobacionesController {
	
	private @Autowired RequerimientoService requerimientoService;
	private @Autowired DetalleRequerimientoService detRequerimientoservice;
	
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
		
		return requerimientoService.buscar(estado, dDesde, dHasta);
	}
	
	@RequestMapping("/obtener")
	@ResponseBody
	private RequerimientoBean obtenerPorId(@RequestParam("codRequerimiento") int codRequerimiento) {
		return requerimientoService.obtenerPorId(codRequerimiento);
	}
	
	@RequestMapping("/actualizar")
	@ResponseBody
	public RequerimientoBean actualizar(@RequestParam("codRequerimiento") int codRequerimiento,
								  @RequestParam("fechaEntrega") String fechaEntrega,
								  @RequestParam("estado") int estado,
								  @RequestParam("observacion") String observacion) throws ParseException {
		
		Date dFechaEntrega = null;
		if (!fechaEntrega.isEmpty()) {
			dFechaEntrega = Util.StringToFecha(fechaEntrega, "yyyy-MM-dd");
		}
		
		return requerimientoService.actualizar(codRequerimiento, dFechaEntrega, estado, observacion);
	}
	
	@RequestMapping("/listarDetalle")
	@ResponseBody
	private List<DetalleRequerimientoBean> listarDetalle(@RequestParam(name = "codRequerimiento") int codRequerimiento) {
		return detRequerimientoservice.buscar(codRequerimiento);
	}
}
