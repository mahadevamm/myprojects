/** Filename: ErrorCodeEnum.java
 * Author: Mallikarjuna
 * Creation: 08-08-2016
 * 
 * (C) Snipe IT Solutions. 2016
 *
 * All rights are reserved. Reproduction or transmission in whole or in part,in 
 * any form or by any means, electronic, mechanical or otherwise, is prohibited 
 * without the prior written permission of the copyright owner.
 **/

package com.diksha.poi.exception;

public enum ErrorCodeEnum {

	ERROR_HTTP_STATUS_404(404, "The requested resource is not available"),
	COMMON_ERROR(10001, "Unknown Error occured"), 
	FIELD_EMPTY_ERROR(10002, "Field can not be Empty or Null : {0} "), 
	INTERRUPT_ERROR(10005, "Interrupt occured while receiving response"), 
	TIMEOUT_ERROR(10006, "Timeout occured for communication gateway request in {0} seconds"), 
	JSON_PARSER_ERROR(10007, "JSON parsing error for wrong data {0}"), 
	DAO_EXCEPTION(10008,"Dao Exception"), 
	USERS_NOT_EMPTY(1009,"Can't delete the userGroup.UserGroup has associated users");

	private final int errorCode;
	private final String errorMessage;

	private ErrorCodeEnum(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets error code
	 * 
	 * @return errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets Error Message
	 * 
	 * @return errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

}
