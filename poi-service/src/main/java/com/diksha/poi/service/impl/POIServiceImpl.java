package com.diksha.poi.service.impl;
/**
 * 
 */
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.PATCH;
import org.springframework.stereotype.Service;

import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.UserBO;
import com.diksha.poi.exception.POIException;
import com.diksha.poi.manager.PoiManager;
import com.diksha.poi.service.POIService;
import com.diksha.poi.bo.model.ExcelBO;
import com.diksha.poi.exception.POIException;

/**
 * Purpose:
 * 
 * Create Date :4/9/2016 
 * 
 * @author Mahadeva
 * @param <ExcelBO>
 *
 */
@Path("/v1")
@Service("poiService")
public class POIServiceImpl<ExcelBO> implements POIService {

	@Resource(name = "poiUser")
	private PoiManager poiManager;
	
	@Context
	HttpServletRequest req;

	
	/**
	 * {@link com.diksha.poi.service.POIService#getAllUsers()}
	 */
	@GET
	@Path("/users")
	@Produces("application/json")
	public List<UserBO> getAllUsers() throws POIException{
		return poiManager.getAllUser();
	}

	
	/**
	 * {@link com.diksha.poi.service.POIService#getUser(int)}
	 */
	@GET
	@Path("/users/{userid}")
	@Produces("application/json")
	public UserBO getUser(@PathParam("userid") int userid) throws POIException {
		return poiManager.getUser(userid);
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserBO createUser(UserBO user) throws POIException {
		return poiManager.createUser(user);	
	}


	@GET
	@Path("/echo")
	public void echo() {
		System.out.println("POIServiceImpl.echo()");
	}


	@PATCH
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserBO update(UserBO user) throws POIException {
		// TODO Auto-generated method stub
		return poiManager.updateUser(user);
	}
	@POST
	@Path("employeeeeee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createmple(EmployeeeBO employee) throws POIException {
		return poiManager.createmple(employee);	
	}
	@GET
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeeBO> createmple12() throws POIException{
		return poiManager.createmple12();
	}
	
	//excel sheet
	@POST
	@Path("sampleexcedatalbase64")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response readexcelsampledata(com.diksha.poi.bo.model.ExcelBO ex) throws POIException {
		String path=req.getServletContext().getRealPath("/");
		return poiManager.readexcelsampledata(ex,path);
	}

	
}
