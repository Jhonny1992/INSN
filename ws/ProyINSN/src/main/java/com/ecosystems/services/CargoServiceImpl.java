package com.ecosystems.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecosystems.dao.CargoDAO;
import com.ecosystems.entity.CargoBean;

@Service
public class CargoServiceImpl implements CargoService {
	private @Autowired CargoDAO dao;

	@Override
	public List<CargoBean> listar() {
		return dao.listar();
	}

}
