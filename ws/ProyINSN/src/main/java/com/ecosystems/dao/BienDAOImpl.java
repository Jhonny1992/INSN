package com.ecosystems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.BienBean;
import com.ecosystems.entity.UsuarioBean;


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
			BienBean ant = sesion.get(BienBean.class, bean.getCodBien());
			ant.setNombre(bean.getNombre());
			ant.setDescripcion(bean.getDescripcion());
			ant.setTipo(bean.getTipo());
			
			sesion.update(ant);
			
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
	
	@Override
	@Transactional
	public void eliminar(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			BienBean bean = sesion.get(BienBean.class, id);
			sesion.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<BienBean> buscar(String nombre) {
		try {
			Session sesion = factory.getCurrentSession();
			
			String hql = "from BienBean WHERE (:nombre = '' or nombre like CONCAT('%', :nombre, '%'))";
			
			Query query = sesion.createQuery(hql);
			query.setParameter("nombre", nombre == null ? "" : nombre);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}
