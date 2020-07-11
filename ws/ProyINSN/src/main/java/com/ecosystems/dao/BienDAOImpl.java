package com.ecosystems.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.BienBean;


@Repository
public class BienDAOImpl implements BienDAO{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public BienBean agregar(BienBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			sesion.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}
	
	@Transactional
	@Override
	public BienBean actualizar(BienBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			sesion.update(bean);
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public BienBean obtenerPorId(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			
			return sesion.get(BienBean.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Transactional(readOnly = true)
	@Override
	public void eliminar(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			BienBean bean = sesion.get(BienBean.class, id);
			sesion.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<BienBean> list() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select b from BienBean b";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<BienBean> buscarXFecha(Date fecha1, Date fecha2) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			
			query=session.createQuery("select b from BienBean b where b.fechaRegistro between ?1 and ?2");
			query.setParameter(1, fecha1);
			query.setParameter(2, fecha2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
