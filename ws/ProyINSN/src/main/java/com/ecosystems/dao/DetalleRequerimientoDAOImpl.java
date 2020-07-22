package com.ecosystems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.DetalleRequerimientoBean;

@Repository
public class DetalleRequerimientoDAOImpl implements DetalleRequerimientoDAO {
	
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<DetalleRequerimientoBean> buscar(int codRequerimiento) {
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			query=session.createQuery("select dr from DetalleRequerimientoBean dr where (:requerimiento=-1 or :requerimiento = dr.codRequerimiento");
			query.setParameter(1, codRequerimiento==0 ? -1 : codRequerimiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional
	@Override
	public DetalleRequerimientoBean agregar(DetalleRequerimientoBean bean) {
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
