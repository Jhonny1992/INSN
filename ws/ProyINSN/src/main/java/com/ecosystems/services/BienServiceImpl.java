package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.BienDAO;
import com.ecosystems.entity.BienBean;

@Service
public class BienServiceImpl implements BienService {
	
	@Autowired
	private BienDAO bienDAO;

	@Override
	public BienBean agregar(BienBean bean) {
		return bienDAO.agregar(bean);
	}

	@Override
	public BienBean actualizar(BienBean bean) {
		return bienDAO.actualizar(bean);
	}

	@Override
	public BienBean obtenerPorId(int id) {
		return bienDAO.obtenerPorId(id);
	}

	@Override
	public void eliminar(int id) {
		bienDAO.eliminar(id);

	}

	@Override
	public List<BienBean> buscar(String nombre) {
		return bienDAO.buscar(nombre);
	}

	

}
