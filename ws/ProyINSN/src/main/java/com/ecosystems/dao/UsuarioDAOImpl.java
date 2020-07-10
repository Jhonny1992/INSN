package com.ecosystems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.UsuarioBean;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	@Transactional
	public UsuarioBean agregar(UsuarioBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			sesion.save(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bean;
	}

	@Override
	@Transactional
	public UsuarioBean actualizar(UsuarioBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			sesion.update(bean);
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioBean> buscar(String nombres, String apellidos) {
		try {
			Session sesion = factory.getCurrentSession();
			
			String hql = "from UsuarioBean WHERE (:nombres = '' or nombres like CONCAT('%', :nombres, '%')) AND (:apellidos is null or apellidos like CONCAT('%', :apellidos, '%'))";
			
			Query query = sesion.createQuery(hql);
			query.setParameter("nombres", nombres == null ? "" : nombres);
			query.setParameter("apellidos", apellidos == null ? "" : apellidos);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioBean obtenerPorId(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			
			return sesion.get(UsuarioBean.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public void eliminar(int id) {		
		try {
			Session sesion = factory.getCurrentSession();
			UsuarioBean bean = sesion.get(UsuarioBean.class, id);
			sesion.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}