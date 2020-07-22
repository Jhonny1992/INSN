package com.ecosystems.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.RequerimientoBean;

@Repository
public class RequerimientoDAOImpl implements RequerimientoDAO{
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public RequerimientoBean agregar(RequerimientoBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			sesion.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	 
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<RequerimientoBean> buscar(int codUnidad,Date fechamin, Date fechamax) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			
			query=session.createQuery("select r from RequerimientoBean r where (:codUnidad=-1 or :codUnidad = r.codUnidadOrganica) and r.fechaRegistro between ?1 and ?2");
			query.setParameter(1, codUnidad==0 ? -1 : codUnidad);
			query.setParameter(2, fechamin == null ? (new java.util.Date(1900,1,1)) : fechamin, TemporalType.DATE);
			query.setParameter(3, fechamax == null ? (new java.util.Date(3000,1,1)) : fechamax, TemporalType.DATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	

}
