package com.ecosystems.services;

import java.util.Date;
import java.util.List;

import com.ecosystems.entity.RequerimientoBean;

public interface RequerimientoService {
	
	public RequerimientoBean agregar(RequerimientoBean bean);
	public List<RequerimientoBean> buscar(int codUnidad, Date fechamin, Date fechamax);
	

}
