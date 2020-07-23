package com.ecosystems.controller;

import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;
import com.ecosystems.services.BienService;
import com.ecosystems.services.UnidadOrganicaService;
import com.ecosystems.util.Util;

@Controller
@RequestMapping(value = "/gestion")

public class GestionRequerimientoController {
	private @Autowired UnidadOrganicaService unidadOrganicaService;
	private @Autowired BienService bienService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "gestionrequerimiento";
	}
	
	@RequestMapping(value="/unidadOrg�nicaXUsuario")
	@ResponseBody
	public UnidadOrganicaBean listarUsuario(HttpSession sesion){
		UsuarioBean usu = Util.getUsuario(sesion);
		
		UnidadOrganicaBean unidadOrganica = unidadOrganicaService.obtenerPorJefeId(usu.getCodUsuario());
		
		return unidadOrganica;
	}
	
	@RequestMapping("/listarBienes")
	@ResponseBody
	public List<BienBean> buscar(HttpServletRequest request,
								 @RequestParam("nombre") String nombre) {
		List<BienBean> listaTemporal = obtenerListaBienTemp(request);
		List<BienBean> listaBD = bienService.buscar(nombre);
		List<BienBean> listaFinal = new ArrayList<BienBean>();
		
		for (BienBean b : listaBD) {
			int i;
			for (i = 0; i < listaTemporal.size() && listaTemporal.get(i).getCodBien() != b.getCodBien(); ++i) ;
			
			if (i == listaTemporal.size()) {
				listaFinal.add(b);
			}
		}
		
		
		return listaFinal;
	}
	
	@RequestMapping(value = "/agregarBienTemp", method = RequestMethod.GET)
	@ResponseBody
	public List<BienBean> agregarBienTemp(HttpServletRequest request,
										  @RequestParam(name = "codBien") int codBien,
										  @RequestParam(name = "cantidad") int cantidad) {
		List<BienBean> lista = obtenerListaBienTemp(request);

		BienBean bien = bienService.obtenerPorId(codBien);
		bien.setCantidad(cantidad);
		lista.add(bien);
		
		request.getSession().setAttribute("ListaBienesTemp", lista);

		return lista;
	}
	
	@RequestMapping("/listarDetalle")
	@ResponseBody
	public List<BienBean> listarDetalle(HttpServletRequest request) {
		return obtenerListaBienTemp(request);
	}
	
	@RequestMapping(value = "/eliminarDetalle", method = RequestMethod.POST)
	@ResponseBody
	public int eliminarDetalle(HttpServletRequest request,
							   @RequestParam("codBien") int codBien) {
		List<BienBean> lista = obtenerListaBienTemp(request);
		
		BienBean reg = null;
		for (BienBean b : lista) {
			if (b.getCodBien() == codBien)
			{
				reg = b;
				break;
			}
		}
		
		if (reg != null)
			lista.remove(reg);
		
		request.getSession().setAttribute("ListaBienesTemp", lista);
		
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	private List<BienBean> obtenerListaBienTemp(HttpServletRequest request) {
		List<BienBean> lista;
		Object obj = request.getSession().getAttribute("ListaBienesTemp");
		if (obj == null) {
			lista = new ArrayList<BienBean>();
		}
		else {
			lista = (List<BienBean>)obj;
		}
		
		return lista;
	}
}
