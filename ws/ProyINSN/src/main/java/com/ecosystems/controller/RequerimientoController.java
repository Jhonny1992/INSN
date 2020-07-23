package com.ecosystems.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.EstadoRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;
import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.services.DetalleRequerimientoService;
import com.ecosystems.services.RequerimientoService;

@Controller
@RequestMapping(value = "/requerimiento")
public class RequerimientoController {
	
	@Autowired
	private DetalleRequerimientoService detalleRequerimientoService;
	
	@Autowired
	private RequerimientoService requerimientoService;
	
	@RequestMapping(value= "/" , method = RequestMethod.GET)
	public String index() {
		return "requerimiento";
	}
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	@ResponseBody
	public List<RequerimientoBean> buscar(@RequestParam("codUnidad") int codUnidad,
											@RequestParam("fechamin") Date fechamin,
											@RequestParam("fechamax") Date fechamax) {
		return requerimientoService.buscar(codUnidad, fechamin, fechamax);
	}
	
	@RequestMapping(value = "/agregar", method = RequestMethod.POST)
	@ResponseBody
	public RequerimientoBean agregar(@RequestParam("descripcion") String descripcion,
								  @RequestParam("codUnidad") int codUnidad,
								  @RequestParam("estado") int estado
								  
								  ) {
		RequerimientoBean bean = new RequerimientoBean();
		
		UnidadOrganicaBean uOrganica= new UnidadOrganicaBean();
		uOrganica.setCodUnidadOrganica(codUnidad);
		
		EstadoRequerimientoBean eRequerimiento= new EstadoRequerimientoBean();
		eRequerimiento.setCodEstado(estado);
		
		bean.setDescripcion(descripcion);
		bean.setCodUnidad(uOrganica);
		bean.setEstado(eRequerimiento);
		
		return requerimientoService.agregar(bean);
	}
	
	//detalleRequerimiento
	
	@RequestMapping(value = "/buscarRequerimiento", method = RequestMethod.GET)
	@ResponseBody
	public List<DetalleRequerimientoBean> buscarRequerimiento(@RequestParam("requerimiento") int codRequerimiento) {
		return detalleRequerimientoService.buscar(codRequerimiento);
	}

}
