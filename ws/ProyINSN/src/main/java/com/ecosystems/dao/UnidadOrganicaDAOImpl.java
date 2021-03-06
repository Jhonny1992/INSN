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
			
			UnidadOrganicaBean ant = sesion.get(UnidadOrganicaBean.class, bean.getCodUnidadOrganica());
			ant.setNombre(bean.getNombre());
			ant.setDescripcion(bean.getDescripcion());
			ant.setAnexo(bean.getAnexo());
			ant.setUsuario(bean.getUsuario());

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
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<UsuarioBean> posiblesJefesUnidadOrganica(int codUsuarioEdit) {
		try {
			Session sesion = factory.getCurrentSession();
			String hql;
			Query query;
			
			//String hql = "Select u from UsuarioBean u left join UnidadOrganicaBean uo on uo.usuario = u.codUsuario Where uo.usuario is null";
			
			if (codUsuarioEdit == 0) {
				hql = "Select u from UsuarioBean u Where u.cargo in (2, 3) and u.codUsuario not in(select distinct uo.usuario from UnidadOrganicaBean uo)";
				query = sesion.createQuery(hql);
			}
			else {
				hql = "Select u from UsuarioBean u Where u.cargo in (2, 3) and u.codUsuario not in(select distinct uo.usuario from UnidadOrganicaBean uo) or u.codUsuario = ?1";
				query = sesion.createQuery(hql);
				query.setParameter(1, codUsuarioEdit);
			}
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public UnidadOrganicaBean obtenerPorJefeId(int codUsuario) {
		try {
			Session sesion = factory.getCurrentSession();
			String hql = "Select uo From UnidadOrganicaBean uo inner join UsuarioBean u on u.codUsuario = uo.usuario where u.codUsuario = ?1";
			Query query = sesion.createQuery(hql);
			query.setParameter(1, codUsuario);

			return (UnidadOrganicaBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
