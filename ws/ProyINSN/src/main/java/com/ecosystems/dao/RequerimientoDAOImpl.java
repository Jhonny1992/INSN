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

import com.ecosystems.entity.DetalleRequerimientoBean;
import com.ecosystems.entity.EstadoRequerimientoBean;
import com.ecosystems.entity.RequerimientoBean;

@Repository
public class RequerimientoDAOImpl implements RequerimientoDAO{
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public RequerimientoBean agregar(RequerimientoBean bean, List<DetalleRequerimientoBean> listaDet) {
		try {
			Session sesion = factory.getCurrentSession();
			sesion.save(bean);
			
			for (DetalleRequerimientoBean det : listaDet) {
				det.setRequerimiento(bean);
				sesion.save(det);
			}
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	 
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<RequerimientoBean> buscar(int estado,Date fechaDesde, Date fechaHasta) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			
			query=session.createQuery("select r from RequerimientoBean r where (:estado = -1 or :estado = r.estado) and r.fechaRegistro between :desde and :hasta");
			query.setParameter("estado", estado == 0 ? -1 : estado);
			query.setParameter("desde", fechaDesde == null ? (new java.util.Date(1900,1,1)) : fechaDesde, TemporalType.DATE);
			query.setParameter("hasta", fechaHasta == null ? (new java.util.Date(3000,1,1)) : fechaHasta, TemporalType.DATE);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional
	public RequerimientoBean actualizar(int codRequerimiento, Date fechaEntrega, int codEstado, String observacion) {
		try {
			Session sesion = factory.getCurrentSession();
			RequerimientoBean ant = sesion.get(RequerimientoBean.class, codRequerimiento);
			ant.setFechaEntrega(fechaEntrega);
			
			EstadoRequerimientoBean estado = new EstadoRequerimientoBean();
			estado.setCodEstado(codEstado);
			ant.setEstado(estado);
			
			ant.setObservacion(observacion);
			
			sesion.update(ant);
			
			return ant;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public RequerimientoBean obtenerPorId(int codRequerimiento) {
		try {
			Session sesion = factory.getCurrentSession();
			
			return sesion.get(RequerimientoBean.class, codRequerimiento);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
