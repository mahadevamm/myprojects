package com.diksha.poi.manager;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.ExcelBO;
import com.diksha.poi.bo.model.UserBO;

public interface PoiManager {
	
	List<UserBO> getAllUser();
	
	UserBO getUser(@NotBlank @NotEmpty @NotNull int id);
	
	UserBO createUser(UserBO user);

	UserBO updateUser(UserBO user);

	Response createmple(EmployeeeBO employee);

	List<EmployeeeBO> createmple12();
	
	Response readexcelsampledata(ExcelBO exa,String path);

}
