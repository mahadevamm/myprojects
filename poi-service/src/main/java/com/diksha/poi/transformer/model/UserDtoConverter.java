package com.diksha.poi.transformer.model;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.UserBO;
import com.diksha.poi.domain.model.EmployeeeDO;
import com.diksha.poi.domain.model.User;
import com.diksha.poi.bo.model.NameBO;
import com.diksha.poi.domain.model.NameDO;

public class UserDtoConverter{

	public static  UserBO convertDOTOBO(User userDO){
		ModelMapper modelMapper = new ModelMapper();
		UserBO userBo = modelMapper.map(userDO, UserBO.class);
		return userBo;
	}
	
	public static  User convertBOTODO(UserBO userBO){
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(userBO, User.class);
		return user;
	}
	
	public static  List<UserBO> convertDOsTOBOs(List<User> userDOs){
	    java.lang.reflect.Type targetListType = new TypeToken<List<UserBO>>() {}.getType();
	    List<UserBO> userBos = new ModelMapper().map(userDOs, targetListType);
		return userBos;
	}

	public static EmployeeeDO convertBOTODOCreatemple(EmployeeeBO employee) {
		ModelMapper modelMapper = new ModelMapper();
		EmployeeeDO user1 = modelMapper.map(employee, EmployeeeDO.class);
		return user1;
	}

	

	public static List<EmployeeeBO> convertDOsTOBOscreatemple12(List<EmployeeeDO> list) {
		  java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeeBO>>() {}.getType();
		    List<EmployeeeBO> userBos = new ModelMapper().map(list, targetListType);
			return userBos;
	}
	public static NameDO convertBOTODOname(NameBO name) {
		ModelMapper modelMapper = new ModelMapper();
		NameDO nameDO = modelMapper.map(name,NameDO.class);
		return nameDO;
	}
}
