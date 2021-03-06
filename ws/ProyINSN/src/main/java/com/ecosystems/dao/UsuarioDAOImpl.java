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
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	@Transactional
	public UsuarioBean actualizar(UsuarioBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			UsuarioBean ant = sesion.get(UsuarioBean.class, bean.getCodUsuario());
			ant.setNombres(bean.getNombres());
			ant.setApellidos(bean.getApellidos());
			ant.setNroDocumento(bean.getNroDocumento());
			ant.setUsername(bean.getUsername());
			ant.setPassword(bean.getPassword());
			ant.setCorreo(bean.getCorreo());
			ant.setCargo(bean.getCargo());
			
			sesion.update(ant);
			
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
			
			String hql = "select u from UsuarioBean u join CargoBean c on c.codCargo = u.cargo WHERE (:nombres = '' or u.nombres like CONCAT('%', :nombres, '%')) AND (:apellidos is null or u.apellidos like CONCAT('%', :apellidos, '%'))";
			
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
	@Transactional
	public void eliminar(int id) {		
		try {
			Session sesion = factory.getCurrentSession();
			UsuarioBean bean = sesion.get(UsuarioBean.class, id);
			sesion.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<UsuarioBean> listarUsuario() {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			query=session.createQuery("select ub from UsuarioBean ub");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Override
	@Transactional(readOnly=true)
	public UsuarioBean autenticar(String usuario, String clave) {
		try {
			Session sesion = factory.getCurrentSession();
			String hql = "From UsuarioBean where username = ?1 and password = ?2";
			Query query = sesion.createQuery(hql);
			query.setParameter(1, usuario);
			query.setParameter(2, clave);

			return (UsuarioBean) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}	
}
