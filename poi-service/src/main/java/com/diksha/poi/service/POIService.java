package com.diksha.poi.service;

import java.util.List;

import com.diksha.poi.bo.model.UserBO;
import com.diksha.poi.exception.POIException;
/**
 * Purpose: All methods associated with DHC Web services
 *  - load all users
 *  - load by requested user
 *  - delete a user
 *   -creation of user
 *   -modification of user
 * Created or modified date : 09-08-2016    
 * @author MadhuSudan
 *
 */
public interface POIService {

	void echo();
    /**
     * This is used to load all available user informations 
     * @return List<UserBO> - load all UserBusiness objects 
     * @throws POIException - Exception in case of no DB Connected or table does not exist
     */
	List<UserBO> getAllUsers() throws POIException;
    /**
     * 
     * THis is used to load user information based on ther id
     * @param id
     * @return
     * @throws POIException
     */
	UserBO getUser(int id) throws POIException;
    /**
     * 
     * @param user
     * @return
     * @throws POIException
     */
	UserBO createUser(UserBO user) throws POIException;
	
	
	/**
	 * this is used update the user information
	 * @param user
	 * @return UserBO - load updated UserBusiness objects 
	 * @throws POIException - Exception in case of no DB Connected or table does not exist
	 */
	
	UserBO update(UserBO user)throws POIException;

}
