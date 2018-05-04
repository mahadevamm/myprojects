package com.diksha.poi.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

public interface BaseHibernateDao<E, PK extends Serializable> {
	/**
	 * This method persists a session factory
	 * 
	 * @param newInstance
	 * @return
	 */
	SessionFactory getSessionFactory();
	/**
	 * This method persists a new object into database.
	 * 
	 * @param newInstance
	 * @return
	 */
	PK save(E newInstance);

	/**
	 * This method updates a persisted object in database.
	 * 
	 * @param transientObject
	 */
	void update(E transientObject);

	/**
	 * This method creates/updates a new/existing object in database.
	 * 
	 * @param transientObject
	 */
	void saveOrUpdate(E transientObject);

	/**
	 * This method deletes a persisted object based on id.
	 * 
	 * @param id
	 */
	void delete(E persistentObject);

	/**
	 * This method retrieves a persisted object based on id.
	 * @param id
	 * @param type
	 * @return
	 */
	E findById(PK id, Class<E> type);

	/**
	 * This method retrieves all persisted objects based on a criteria mapped.
	 * @param type
	 * @return
	 */
	List<E> findAll(Class<E> type);
	
	public void setSessionFactory(SessionFactory sessionFactory);
}