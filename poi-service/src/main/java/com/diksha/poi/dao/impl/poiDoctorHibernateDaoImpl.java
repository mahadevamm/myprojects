package com.diksha.poi.dao.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.diksha.poi.dao.BaseHibernateDao;
import com.diksha.poi.dao.POIDoctorDao;
import com.diksha.poi.domain.model.User;

public class poiDoctorHibernateDaoImpl implements POIDoctorDao {
	private static final Log LOGGER = LogFactory.getLog(poiDoctorHibernateDaoImpl.class);

	@Resource(name = "poiHibernateDao")
	private BaseHibernateDao<User, Integer> poiHibernateDao;

	public BaseHibernateDao<User, Integer> getDhcHibernateDao() {
		return poiHibernateDao;
	}

	public void setDhcHibernateDao(BaseHibernateDao<User, Integer> poiHibernateDao) {
		this.poiHibernateDao = poiHibernateDao;
	}
	
	

}
