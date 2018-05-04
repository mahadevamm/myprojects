package com.diksha.poi.dao;

import com.diksha.poi.domain.model.User;

public interface POIDoctorDao {
	void setDhcHibernateDao(BaseHibernateDao<User, Integer> dhcHibernateDao);
	
}
