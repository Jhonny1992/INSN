package com.ecosystems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.UnidadOrganicaBean;
import com.ecosystems.entity.UsuarioBean;
@Repository
public class UnidadOrganicaDAOImpl implements UnidadOrganicaDAO {

	@Autowired
	public SessionFactory factory;
	
	@Transactional
	@Override
	public UnidadOrganicaBean agregar(UnidadOrganicaBean bean) {
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
	public UnidadOrganicaBean actualizar(UnidadOrganicaBean bean) {
		try {
			Session sesion = factory.getCurrentSession();
			
			UnidadOrganicaBean ant = sesion.get(UnidadOrganicaBean.class, bean.getcodUnidadOrganica());
			ant.setNombre(bean.getNombre());
			ant.setDescripcion(bean.getDescripcion());
			ant.setAnexo(bean.getAnexo());
			ant.setJefeEncargado(bean.getJefeEncargado());

			sesion.update(ant);
			
			return bean;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<UnidadOrganicaBean> buscar(String nombre) {
		try {
			Session sesion = factory.getCurrentSession();
			
			String hql = "from UnidadOrganicaBean WHERE (:nombre = '' or nombre like CONCAT('%', :nombre, '%'))";
			
			Query query = sesion.createQuery(hql);
			query.setParameter("nombre", nombre == null ? "" : nombre);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Transactional(readOnly=true)
	@Override
	public UnidadOrganicaBean obtenerPorId(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			
			return sesion.get(UnidadOrganicaBean.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Transactional
	@Override
	public void eliminar(int id) {
		try {
			Session sesion = factory.getCurrentSession();
			UnidadOrganicaBean bean = sesion.get(UnidadOrganicaBean.class, id);
			sesion.delete(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
