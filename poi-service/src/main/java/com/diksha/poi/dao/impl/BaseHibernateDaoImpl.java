package com.diksha.poi.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.diksha.poi.dao.BaseHibernateDao;


public class BaseHibernateDaoImpl<E, PK extends Serializable> implements BaseHibernateDao<E, Serializable> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public PK save(E newInstance) {
		return (PK) getSessionFactory().getCurrentSession().save(newInstance);
	}


	public void update(E transientObject) {
		getSessionFactory().getCurrentSession().update(transientObject);
	}

	public void saveOrUpdate(E transientObject) {
		getSessionFactory().getCurrentSession().saveOrUpdate(transientObject);
	}

	public void delete(E persistentObject) {
		getSessionFactory().getCurrentSession().delete(persistentObject);
	}

	

	public List<E> findAll(Class<E> type) {
		return getSessionFactory().getCurrentSession().createCriteria(type).list();
	}


	public E findById(Serializable id, Class<E> type) {
		// TODO Auto-generated method stub
		return null;
	}


	
	}


