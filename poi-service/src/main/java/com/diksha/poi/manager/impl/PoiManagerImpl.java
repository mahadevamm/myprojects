package com.diksha.poi.manager.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.diksha.poi.bo.model.NameBO;
import com.diksha.poi.bo.model.EmployeeeBO;
import com.diksha.poi.bo.model.ExcelBO;
import com.diksha.poi.bo.model.UserBO;
import com.diksha.poi.dao.POIDao;
import com.diksha.poi.domain.model.User;
import com.diksha.poi.exception.POIException;
import com.diksha.poi.exception.ErrorCodeEnum;
import com.diksha.poi.exception.ExceptionInfo;
import com.diksha.poi.manager.PoiManager;
import com.diksha.poi.transformer.model.UserDtoConverter;
import com.diksha.poi.bo.model.NameBO;
import com.diksha.poi.exception.POIException;

@Component("poiUser")
@Transactional("poiTransactionManager")
public class PoiManagerImpl implements PoiManager {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(PoiManagerImpl.class);
	private static final String FILE_PATH = "‪F:\\Book123.xlsx";
	
	@Resource(name = "poiDao")
	private POIDao poiDao;

	public List<UserBO> getAllUser() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PoiManagerImpl :: In getAll Users");
		}
		try{
			return UserDtoConverter.convertDOsTOBOs(poiDao.getAllUsers());
			
		}catch(POIException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
		
	}
	
	public UserBO getUser(int id){
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PoiManagerImpl :: In getUser :"+id);
		}
		try{
		return UserDtoConverter.convertDOTOBO(poiDao.getUser(id));
		}catch(POIException dhe){
			LOGGER.error("Error in loading by user Id ",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public UserBO createUser(UserBO user) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PoiManagerImpl :: In createUser");
		}
		try{
			return UserDtoConverter.convertDOTOBO(poiDao.createUser(UserDtoConverter.convertBOTODO(user)));
		}catch(POIException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	public UserBO updateUser(UserBO user) {
		if(LOGGER.isDebugEnabled())
		{
			LOGGER.debug("PoiManagerImpl:: In update user");
		}
		try
		{
			return UserDtoConverter.convertDOTOBO(poiDao.updateUser(UserDtoConverter.convertBOTODO(user)));
		}
		catch(POIException dhe)
		{
			LOGGER.error("Error in updating user info",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
		
	}

	@Override
	public Response createmple(EmployeeeBO employee) {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PoiManagerImpl :: In getUser :"+employee);
		}
		try{
		return poiDao.createmple(UserDtoConverter.convertBOTODOCreatemple(employee));
		}catch(POIException dhe){
			LOGGER.error("Error in loading by user Id ",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	}

	@Override
	public List<EmployeeeBO> createmple12() {
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("PoiManagerImpl :: In getAll Users");
		}
		try{
			return UserDtoConverter.convertDOsTOBOscreatemple12(poiDao.getcreatemple12());
			
		}catch(POIException dhe){
			LOGGER.error("Error in loading all users info ",dhe);
			throw new POIException(new ExceptionInfo(ErrorCodeEnum.COMMON_ERROR.getErrorCode(),ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
		}
	
}
	private void writeByteArraysToFile(String filename, byte[] content)
			throws IOException {
		File file = new File(filename);
		BufferedOutputStream writer = new BufferedOutputStream(
				new FileOutputStream(file));
		writer.write(content);
		writer.flush();
		writer.close();
	}
	@Override
	public Response readexcelsampledata(ExcelBO exa,String path) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("UserManagerImp:: in update user");
		}
		HashMap<String, String> praf = new HashMap<String, String>();
		try {
			String filename1 = path+"/WEB-INF/images/"+  exa.getFilename() + ".xlsx";
			byte[] decodedBytes = Base64.decodeBase64(exa.getFile());
			writeByteArraysToFile(filename1, decodedBytes);
			praf.put("isSuccess", "TRUE");
			readExcelSheetsampledata(filename1);
			return Response.ok(praf).build();
		} catch (Exception dhe) {
			dhe.printStackTrace();
			praf.put("data", "FALSE");
			return Response.ok(praf).build();

		}
	}
	private Response readExcelSheetsampledata(String filename1) {
		File myfile = new File(filename1);
		XSSFWorkbook myWorkbook = null;
		XSSFSheet mysheet = null;
		FileInputStream fis = null;
		HashMap<String, String> praf = new HashMap<String, String>();
		int i = 0;
		try {
			fis = new FileInputStream(myfile);
			myWorkbook = new XSSFWorkbook(fis);
			while (i < myWorkbook.getNumberOfSheets()) {
				mysheet = myWorkbook.getSheetAt(i);
				switch (i) {
				case 0:
					readExcelSheetsampledata(mysheet, filename1);
					break;
				/*
				 * case 1: readExcelSheetByOption(mysheet); break;
				 */

				}
				i++;
			}
			praf.put("message", "uploaded sucesfully");
			return Response.ok(praf).build();

		} catch (Exception e) {
			e.printStackTrace();
			praf.put("error", "not uploaded");
			return Response.ok(praf).build();
		}
	}
		private Response readExcelSheetsampledata(XSSFSheet mysheet,
				String filename1) {
			NameBO namebo=null;
			
			Iterator<Row> rowIterator = mysheet.iterator();
			int j = 0;
			while (rowIterator.hasNext()) {
				namebo = new NameBO();

				Row row = rowIterator.next();
				if (row.getRowNum() == 0) {
					continue; // just skip the rows if row number is 0
				} else {
					Iterator<Cell> cellIterator = row.cellIterator();
					int rowIndex = 0;
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (rowIndex) {
						case 0:
							namebo.setFirstName(cell.getStringCellValue());
							break;
						case 1:
							namebo.setMiddleName(cell.getStringCellValue());
							break;
						case 2:
							namebo.setLastName(cell.getStringCellValue());
							break;

						default:
							break;
						}
						rowIndex++;

					}
					addsampledata(namebo);

				}
				System.out.println("");
			}
			return Response.ok("file uploaded and added to table").build();
}
		public Response addsampledata(NameBO name) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("UserManagerImpl :: In createQuestion");
			}
			try {
				return poiDao.addName(name);
			} catch (POIException dhe) {
				LOGGER.error("Error in loading all users info ", dhe);
				throw new POIException(new ExceptionInfo(
						ErrorCodeEnum.COMMON_ERROR.getErrorCode(),
						ErrorCodeEnum.COMMON_ERROR.getErrorMessage()));
			}
		}
}