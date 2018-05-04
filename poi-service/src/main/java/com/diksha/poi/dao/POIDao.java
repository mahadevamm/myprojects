package com.diksha.poi.dao;

import java.util.List;

import javax.ws.rs.core.Response;

import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.NameBO;
import com.diksha.poi.domain.model.EmployeeeDO;
import com.diksha.poi.domain.model.User;

public interface POIDao {

	void setDhcHibernateDao(BaseHibernateDao<User, Integer> dhcHibernateDao);
	
	List<User> getAllUsers();
	
	User getUser(int id);
	
	User createUser(User user);
	
	User updateUser(User user);

	Response createmple(EmployeeeDO convertBOTODOCreatemple);

	List<EmployeeeDO> getcreatemple12();

	Response addName(NameBO name);

}