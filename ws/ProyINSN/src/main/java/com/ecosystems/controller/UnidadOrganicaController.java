package com.ecosystems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.UnidadOrganicaService;
import com.ecosystems.util.Util;

@Controller
@RequestMapping("/unidadorganica")
public class UnidadOrganicaController {

	@Autowired
	private UnidadOrganicaService unidadorganicaService;
	
	@RequestMapping("/")
	private String index(HttpServletRequest request) {
		UsuarioBean usuario = Util.getUsuario(request.getSession());
		System.out.println(usuario);
		
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
		UsuarioBean usuario=new UsuarioBean();
		usuario.setCodUsuario(jefeEncargado);
		
		bean.setCodUnidadOrganica(codUnidadOrganica);
		bean.setNombre(nombre);
		bean.setDescripcion(descripcion);
		bean.setAnexo(anexo);
		bean.setUsuario(usuario);
		
		return unidadorganicaService.actualizar(bean);
	}
	
	@RequestMapping("/agregar")
	@ResponseBody
	public UnidadOrganicaBean agregar(@RequestParam("nombre") String nombre,
			  @RequestParam("descripcion") String descripcion,
			  @RequestParam("anexo") String anexo,
			  @RequestParam("jefeEncargado") int jefeEncargado) {
		UnidadOrganicaBean bean = new UnidadOrganicaBean();
		UsuarioBean usuario=new UsuarioBean();
		usuario.setCodUsuario(jefeEncargado);
		
		bean.setNombre(nombre);
		bean.setDescripcion(descripcion);
		bean.setAnexo(anexo);
		bean.setUsuario(usuario);
		
		return unidadorganicaService.agregar(bean);
	}
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public int eliminar(@RequestParam("id") int id) {
		unidadorganicaService.eliminar(id);
		
		return 1;
	}

	@RequestMapping(value="/posiblesJefes")
	@ResponseBody
	public List<UsuarioBean> listarUsuario(@RequestParam(name = "codUsuarioEdit") int codUsuarioEdit){
		return unidadorganicaService.posiblesJefesUnidadOrganica(codUsuarioEdit);
	}
}
