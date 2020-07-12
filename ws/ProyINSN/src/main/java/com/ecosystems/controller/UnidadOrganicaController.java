package com.ecosystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.services.UnidadOrganicaService;

@Controller
@RequestMapping("/unidadorganica")
public class UnidadOrganicaController {

	@Autowired
	private UnidadOrganicaService unidadorganicaService;
	
	@RequestMapping("/")
	private String index() {
		return "unidadorganica";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	private List<UnidadOrganicaBean> buscar(@RequestParam("nombre") String nombre){
		return unidadorganicaService.buscar(nombre);
	}
	
	@RequestMapping("/obtener")
	@ResponseBody
	private UnidadOrganicaBean obtenerPorId(@RequestParam("id") int id) {
		return unidadorganicaService.obtenerPorId(id);
	}
	
	@RequestMapping("/actualizar")
	@ResponseBody
	public UnidadOrganicaBean actualizar(@RequestParam("codUnidadOrganica") int codUnidadOrganica,
								  @RequestParam("nombre") String nombre,
								  @RequestParam("descripcion") String descripcion,
								  @RequestParam("anexo") String anexo,
								  @RequestParam("jefeEncargado") int jefeEncargado) {
		UnidadOrganicaBean bean = new UnidadOrganicaBean();
		bean.setcodUnidadOrganica(codUnidadOrganica);
		bean.setNombre(nombre);
		bean.setDescripcion(descripcion);
		bean.setAnexo(anexo);
		bean.setJefeEncargado(jefeEncargado);
		
		return unidadorganicaService.actualizar(bean);
	}

	@RequestMapping("/eliminar")
	@ResponseBody
	public void eliminar(@RequestParam(name="id") int id) {
		unidadorganicaService.eliminar(id);
	}

}
