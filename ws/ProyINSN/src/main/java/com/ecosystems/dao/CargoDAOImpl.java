package com.ecosystems.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecosystems.entity.CargoBean;

@Repository
public class CargoDAOImpl implements CargoDAO {
	
	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<CargoBean> listar() {
		try {
			Session sesion = factory.getCurrentSession();
			
			String hql = "from CargoBean";
			
			Query query = sesion.createQuery(hql);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
